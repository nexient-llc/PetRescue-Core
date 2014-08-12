package com.systemsinmotion.petrescue.entity;

import static org.junit.Assert.assertEquals;

import java.sql.Date;

import org.junit.Test;
import org.mockito.Mockito;

public class PetRecordTest {

	private PetRecord petRecord = new PetRecord();

	@Test
	public void setAndGetShelterId() throws Exception {

		petRecord.setShelterId("ID");
		assertEquals(petRecord.getShelterId(), "ID");

	}

	@Test
	public void setAndGetShelterPetId() throws Exception {

		petRecord.setShelterPetId("ID");
		assertEquals(petRecord.getShelterPetId(), "ID");

	}

	@Test
	public void setAndGetPetId() throws Exception {

		Long id = new Long(12);
		petRecord.setPetFinderId(id);
		assertEquals(petRecord.getPetFinderId(), id);

	}

	@Test
	public void setAndGetName() throws Exception {

		petRecord.setName("name");
		assertEquals(petRecord.getName(), "name");
	}

	@Test
	public void setAndGetDescription() throws Exception {

		petRecord.setDescription("description");
		assertEquals(petRecord.getDescription(), "description");
	}

	@Test
	public void setAnGetdMix() throws Exception {

		petRecord.setMix("mix");
		assertEquals(petRecord.getMix(), "mix");
	}

	@Test
	public void setAndGetPetFinderLastUpdate() throws Exception {

		Date mockDate = Mockito.mock(Date.class);
		petRecord.setPetFinderLastUpdate(mockDate);
		assertEquals(petRecord.getPetFinderLastUpdate(), mockDate);
	}

}
