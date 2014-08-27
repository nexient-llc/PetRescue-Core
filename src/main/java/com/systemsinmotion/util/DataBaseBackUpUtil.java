package com.systemsinmotion.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.datatype.XMLGregorianCalendar;

import org.petfinder.entity.PetContactType;
import org.petfinder.entity.PetOptionType;
import org.petfinder.entity.PetPhotoType;
import org.petfinder.entity.PetfinderPetRecord;
import org.petfinder.entity.PetfinderPetRecord.Options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.systemsinmotion.petrescue.datamanager.PetManager;
import com.systemsinmotion.petrescue.datamanager.RemoteIdentifierManager;
import com.systemsinmotion.petrescue.entity.AnimalType;
import com.systemsinmotion.petrescue.entity.Breed;
import com.systemsinmotion.petrescue.entity.Location;
import com.systemsinmotion.petrescue.entity.PetRecord;
import com.systemsinmotion.petrescue.entity.Photo;
import com.systemsinmotion.petrescue.entity.RemoteIdentifier;
import com.systemsinmotion.petrescue.entity.type.AgeType;
import com.systemsinmotion.petrescue.entity.type.GenderType;
import com.systemsinmotion.petrescue.entity.type.SizeType;
import com.systemsinmotion.petrescue.entity.type.StatusType;
import com.systemsinmotion.petrescue.web.PetFinderConsumer;

@Component
@PropertySource("classpath:/backup.properties")
public class DataBaseBackUpUtil {

	private static final String DEFAULT_CRON_INTERVAL = "00 00 * * *";

	@Autowired
	PetManager petService;

	@Autowired
	Environment environment;

	@Autowired
	PetFinderConsumer petFinderService;
	
	@Autowired
	RemoteIdentifierManager remoteIdentifierService;





	public String getCronProperty() {

		return this.environment.getProperty("backup.cron.intervolve", DEFAULT_CRON_INTERVAL);
	}

	public boolean updateDataBase() {

		List<PetRecord> petRecordPets = petService.findAllPetRecords();
		List<PetfinderPetRecord> petFinderPets = petFinderService.shelterPets(null, null, null, null, null);

		if (petRecordPets == null) {
			petService.storeAllPets(convertToPetRecords(petFinderPets));
		} else {
			for (PetfinderPetRecord petFinderRecord : petFinderPets) {
				RemoteIdentifier remoteIdentifer = remoteIdentifierService.findByRemoteId(petFinderRecord.getId()
						.toString(10));

				if (remoteIdentifer != null
						&& isPetRecordOutdated(petFinderRecord.getLastUpdate(), remoteIdentifer.getLastUpdated())) {
					petService.storePetRecord(copyToPetRecord(new PetRecord(), petFinderRecord));
				}
			}
		}
		return true;
	}

	private List<PetRecord> convertToPetRecords(final List<PetfinderPetRecord> externalPets) {

		List<PetRecord> pets = new ArrayList<PetRecord>();

		for (PetfinderPetRecord externalRecords : externalPets) {
			pets.add(copyToPetRecord(new PetRecord(), externalRecords));
		}

		return pets;
	}

	private PetRecord copyToPetRecord(PetRecord pet, final PetfinderPetRecord externalPet) {

		pet.setAnimal(copyAnimalType(externalPet));
		pet.setName(externalPet.getName());
		pet.setBreeds(copyBreeds(externalPet));
		pet.setDescription(externalPet.getDescription());
		pet.setSize(SizeType.byDescription(externalPet.getSize().value()));
		pet.setAgeType(AgeType.byDescription(externalPet.getAge().value()));
		pet.setGender(GenderType.byDescription(externalPet.getSex().value()));
		pet.setStatus(StatusType.byDescription(externalPet.getStatus().value()));

		copyOptions(pet, externalPet);
		copyPetFinderPhotosToPetRecord(pet, externalPet);
		pet.setLocation(copyLocation(externalPet));

		return pet;

	}

	private AnimalType copyAnimalType(final PetfinderPetRecord externalPet) {
		AnimalType animal = new AnimalType();
		animal.setAnimalType(externalPet.getAnimal().value());
		// call animalType service when created to save the animal
		return animal;
	}

	private Set<Breed> copyBreeds(final PetfinderPetRecord externalPet) {

		Set<Breed> breeds = new HashSet<Breed>();
		Breed breed = new Breed();
		breed.setName(externalPet.getBreeds().getAnimal());

		for (String breedType : externalPet.getBreeds().getBreed()) {
			// service call for breeds table here when created
			breed.setAnimalType(breedType);
			breeds.add(breed);
			breed = new Breed();
			// breedService.save(breeds);
		}
		return breeds;
	}

	private Location copyLocation(final PetfinderPetRecord externalPet) {

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
		// locationService.save(location);
		// save location with location service when service is created.

		return location;
	}

	private void copyOptions(PetRecord pet, final PetfinderPetRecord externalPet) {

		Options options = externalPet.getOptions();
		List<PetOptionType> optionsList = options.getOption();

		for (PetOptionType petOptionType : optionsList) {
			switch (petOptionType) {
				case ALTERED:
					pet.setFixed(true);
					break;
				case HAS_SHOTS:
					pet.setVaccinated(true);
					break;
				case HOUSEBROKEN:
					pet.setHousebroken(true);
					break;
				case NO_CATS:
					pet.setNoCats(true);
					break;
				case NO_DOGS:
					pet.setNoDogs(true);
					break;
				case NO_KIDS:
					pet.setNoKids(true);
					break;
				case NO_CLAWS:
					pet.setDeclawed(true);
					break;
				default:
					break;
			}
		}
	}

	// mapped PetPhotoType property value to our url in case its wrong
	private void copyPetFinderPhotosToPetRecord(PetRecord pet, final PetfinderPetRecord externalPet) {

		Set<Photo> photos = new HashSet<Photo>();
		Photo petRecordPhoto = new Photo();

		for (PetPhotoType photo : externalPet.getMedia().getPhotos().getPhoto()) {

			petRecordPhoto.setSize(photo.getSize());
			petRecordPhoto.setUrl(photo.getValue());
			petRecordPhoto.setPet(pet.getId());
			photos.add(petRecordPhoto);
			// photoservice.save(photo);
			petRecordPhoto = new Photo();
		}
		pet.setPhotos(photos);
	}

	private boolean isPetRecordOutdated(XMLGregorianCalendar petFinderLastUpdated, Date remoteIdentifierLastUpdated) {
		return petFinderLastUpdated.toGregorianCalendar().after(remoteIdentifierLastUpdated);
	}
}
