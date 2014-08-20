package com.systemsinmotion.util;

import java.util.Date;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import org.petfinder.entity.PetfinderPetRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.systemsinmotion.petrescue.entity.RemoteIdentifer;
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

		List<RemoteIdentifer> localPets = jpa.findAll(); // replace with our
															// service when
															// created
		List<PetfinderPetRecord> externalPets = petFinderService.shelterPets(
				null, null, null, null, null);

		if (localPets == null) {
			jpa.save(externalPets);
		} else {
			for (PetfinderPetRecord externalRecords : externalPets) {
				RemoteIdentifer pet = (RemoteIdentifer) jpa
						.findOne(externalRecords.getId());
				if (pet != null
						&& timeStampCheck(externalRecords.getLastUpdate(),
								pet.getLastUpdated())) {
					jpa.save(pet);
				}
			}
		}
		return true;
	}

	private boolean timeStampCheck(XMLGregorianCalendar gregorianCalendar,
			Date date) {
		return gregorianCalendar.toGregorianCalendar().after(date);
	}
}
