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

import com.systemsinmotion.petrescue.converter.Convert;
import com.systemsinmotion.petrescue.entity.PetRecord;
import com.systemsinmotion.petrescue.entity.RemoteIdentifer;
import com.systemsinmotion.petrescue.entity.type.ApiType;
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
		List<PetfinderPetRecord> externalPets = petFinderService.shelterPets(
				null, null, null, null, null);

		if (localPets == null) {
			jpa.save(externalPets);
		} else {
			for (PetfinderPetRecord externalRecord : externalPets) {
				// @formatter:off
				RemoteIdentifer remoteIdentifer = (RemoteIdentifer) jpa.findOne(externalRecord.getId());
				
				if (remoteIdentifer != null && timeStampCheck(externalRecord.getLastUpdate(),
								               remoteIdentifer.getLastUpdated())) {
					remoteIdentifer.setApi(ApiType.PF);
					remoteIdentifer.setLastUpdated(externalRecord.getLastUpdate().toGregorianCalendar().getTime());
			    // @formatter:on
					remoteIdentifer.setPet(mapPetToExternalPet(externalRecord));
					jpa.save(remoteIdentifer);
				}
			}
		}
		return true;
	}

	private boolean timeStampCheck(XMLGregorianCalendar gregorianCalendar,
			Date date) {
		return gregorianCalendar.toGregorianCalendar().after(date);
	}

	private PetRecord mapPetToExternalPet(PetfinderPetRecord external) {
		return Convert.from(external);
	}
}
