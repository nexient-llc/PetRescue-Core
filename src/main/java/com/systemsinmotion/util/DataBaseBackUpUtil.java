package com.systemsinmotion.util;

import java.util.Date;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import org.petfinder.entity.PetfinderPetRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.systemsinmotion.petrescue.converter.Convert;
import com.systemsinmotion.petrescue.entity.PetRecord;
import com.systemsinmotion.petrescue.service.PetService;
import com.systemsinmotion.petrescue.web.PetFinderConsumer;

@Component
@PropertySource("classpath:/backup.properties")
public class DataBaseBackUpUtil {

	@Autowired
	PetService petService;

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

		List<PetRecord> localPets = petService.findAllPetRecords(); // replace
																	// with our
		// service when
		// created
		List<PetfinderPetRecord> externalPets = petFinderService.shelterPets(
				null, null, null, null, null);

		if (localPets == null) {
			; // petService.storePetRecord(externalPets);
		} else {
			for (PetfinderPetRecord externalRecord : externalPets) {
				// @formatter:off
				PetRecord remoteIdentifer = petService.findByID(externalRecord.getId().intValue());
				if (remoteIdentifer != null && timeStampCheck(externalRecord.getLastUpdate(),null)) {
					petService.storePetRecord(mapPetRecordAndReturn(externalRecord));
					
				//@formatter:on
				}
			}
		}
		return true;
	}

	private boolean timeStampCheck(XMLGregorianCalendar gregorianCalendar,
			Date date) {
		return gregorianCalendar.toGregorianCalendar().after(date);
	}

	private PetRecord mapPetRecordAndReturn(PetfinderPetRecord external) {
		return Convert.from(external);
	}
}
