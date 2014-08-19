package com.systemsinmotion.util;

import java.util.List;

import javax.xml.datatype.DatatypeConstants;

import org.petfinder.entity.PetfinderPetRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.systemsinmotion.petrescue.web.PetFinderConsumer;

@Component
@PropertySource("classpath:/backup.properties")
public class DataBaseBackUpUtil {

	@SuppressWarnings("rawtypes")
	@Autowired
	// service not created yet
	JpaRepository jpa;

	@Autowired
	PetFinderConsumer petFinderService;

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

	@SuppressWarnings("unchecked")
	public boolean updateDataBase() {

		List<PetfinderPetRecord> localPets = jpa.findAll(); // replace with our
															// service and
															// object when
															// created
		List<PetfinderPetRecord> externalPets = petFinderService.shelterPets(
				null, null, null, null, null);

		if (localPets == null) {
			jpa.save(externalPets);
		} else {
			for (PetfinderPetRecord externalRecords : externalPets) {
				PetfinderPetRecord pet = (PetfinderPetRecord) jpa
						.findOne(externalRecords.getId());
				if (pet != null
						&& externalRecords.getLastUpdate().compare(
								pet.getLastUpdate()) == DatatypeConstants.GREATER) {
					pet = externalRecords;
					jpa.save(pet);
				}
			}
		}

		return true;
	}

}
