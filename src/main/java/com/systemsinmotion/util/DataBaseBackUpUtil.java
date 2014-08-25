package com.systemsinmotion.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.datatype.XMLGregorianCalendar;

import org.petfinder.entity.PetContactType;
import org.petfinder.entity.PetOptionType;
import org.petfinder.entity.PetfinderPetRecord;
import org.petfinder.entity.PetfinderPetRecord.Options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.systemsinmotion.petrescue.entity.AnimalType;
import com.systemsinmotion.petrescue.entity.Breed;
import com.systemsinmotion.petrescue.entity.Location;
import com.systemsinmotion.petrescue.entity.PetRecord;
import com.systemsinmotion.petrescue.entity.RemoteIdentifier;
import com.systemsinmotion.petrescue.entity.type.GenderType;
import com.systemsinmotion.petrescue.entity.type.SizeType;
import com.systemsinmotion.petrescue.entity.type.StatusType;
import com.systemsinmotion.petrescue.service.PetService;
import com.systemsinmotion.petrescue.service.RemoteIdentifierService;
import com.systemsinmotion.petrescue.web.PetFinderConsumer;

@Component
@PropertySource("classpath:/backup.properties")
public class DataBaseBackUpUtil {

	@Autowired
	PetService petService;

	@Autowired
	PetFinderConsumer petFinderService;

	@Autowired
	RemoteIdentifierService remoteIdentifierService;

	@Autowired
	Environment environment;

	@Bean
	public DataBaseBackUpUtil dataBaseBackUpUtil() {
		return new DataBaseBackUpUtil();
	}

	public String getCronProperty() {

		return this.environment.getProperty("backup.cron.intervolve",
				"00 00 * * *");
	}

	// @formatter:off
	public boolean updateDataBase() {

		List<PetRecord> petRecordPets = petService.findAllPetRecords();
		List<PetfinderPetRecord> petFinderPets = petFinderService.shelterPets(
				null, null, null, null, null);

		if (petRecordPets == null) {
			petService.storeAllPets(convertToPetRecords(petFinderPets));
		} else {
			for (PetfinderPetRecord externalRecord : petFinderPets) {
				
				RemoteIdentifier remoteIdentifer = 
						remoteIdentifierService.findByRemoteId(String.valueOf(externalRecord.getId().intValue() ) );
				
				if (remoteIdentifer != null && timeStampCheck(externalRecord.getLastUpdate(),remoteIdentifer.getLastUpdated())) {	
					petService.storePetRecord(null);					
				}
			}
		}
		return true;
	}

	private boolean timeStampCheck(XMLGregorianCalendar gregorianCalendar,
			Date date) {
		return gregorianCalendar.toGregorianCalendar().after(date);
	}

	
	
	private List<PetRecord> convertToPetRecords(List<PetfinderPetRecord> externalPets){
		List<PetRecord> pets = new ArrayList<PetRecord>();
		for (PetfinderPetRecord externalRecords : externalPets) {
			pets.add(copyToPetRecord(new PetRecord(),externalRecords));
		}
		return pets;
	}
	
	//@formatter:on

	private PetRecord copyToPetRecord(PetRecord pet,
			PetfinderPetRecord externalPet) {

		AnimalType animal = new AnimalType();
		animal.setAnimalType(externalPet.getAnimal().value());

		pet.setAgeType(externalPet.getAge());
		pet.setAnimal(animal);
		pet.setBreeds(copyBreeds(externalPet));
		pet.setName(externalPet.getName());
		pet.setGender(GenderType.valueOf(externalPet.getSex().value()));
		pet.setStatus(StatusType.valueOf(externalPet.getStatus().value()));
		pet.setDescription(externalPet.getDescription());
		pet.setSize(SizeType.valueOf(externalPet.getSize().value()));

		copyOptions(pet, externalPet);
		pet.setLocation(copyLocation(externalPet));

		return pet;

	}

	private Set<Breed> copyBreeds(PetfinderPetRecord externalPet) {

		Set<Breed> breeds = new HashSet<Breed>();
		Breed breed = new Breed();
		breed.setAnimal(externalPet.getBreeds().getAnimal());

		for (String string : externalPet.getBreeds().getBreed()) {
			// service call for breeds table here when created
			breed.setBreed(string);
			breeds.add(breed);
		}
		return breeds;
	}

	private Location copyLocation(PetfinderPetRecord externalPet) {

		Location location = new Location();
		PetContactType contract = externalPet.getContact();
		location.setAddress1(contract.getAddress1());
		location.setAddress2(contract.getAddress2());
		location.setZipCode(contract.getZip());
		location.setContactName(contract.getName());
		location.setEmail(contract.getEmail());
		location.setFax(contract.getFax());
		location.setPhone(contract.getPhone());
		location.setStateOrProvince(contract.getState());
		// save location with location service when service is created.

		return location;
	}

	private void copyOptions(PetRecord pet, PetfinderPetRecord externalPet) {

		Options options = externalPet.getOptions();
		List<PetOptionType> optionsList = options.getOption();

		for (PetOptionType petOptionType : optionsList) {
			if (petOptionType == PetOptionType.ALTERED) {
				pet.setFixed(true);
			} else if (petOptionType == PetOptionType.HAS_SHOTS) {
				pet.setVaccinated(true);
			} else if (petOptionType == PetOptionType.HOUSEBROKEN) {
				pet.setHousebroken(true);
			} else if (petOptionType == PetOptionType.NO_CATS) {
				pet.setNoCats(true);
			} else if (petOptionType == PetOptionType.NO_DOGS) {
				pet.setNoDogs(true);
			} else if (petOptionType == PetOptionType.NO_DOGS) {
				pet.setNoDogs(true);
			} else if (petOptionType == PetOptionType.NO_KIDS) {
				pet.setNoKids(true);
			} else {
				pet.setSpecialNeeds(true);
			}
		}

	}
}
