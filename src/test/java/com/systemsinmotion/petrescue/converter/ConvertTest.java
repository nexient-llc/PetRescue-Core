package com.systemsinmotion.petrescue.converter;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.petfinder.entity.PetfinderPetRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.systemsinmotion.petrescue.entity.PetRecord;
import com.systemsinmotion.petrescue.web.PetFinderConsumer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:META-INF/spring/petrescue-core.xml" })
public class ConvertTest {
	
	@Autowired
	PetFinderConsumer petFinderService;
	
	private static final String AGE_ADULT = "Adult";
	private static final String ANIMAL_CAT = "cat";
	private static final String ANIMAL_DOG = "dog";
	private static final String BREED_DOMESTIC_SHORT_HAIR = "Domestic Short Hair";
	private static final String BREED_NULL = null;
	private static final Integer COUNT_NULL = null;
	private static final String FORMAT_NULL = null;
	private static final Character GENDER_MALE = 'M';
	private static final String LOCATION_ZIP = "48108";
	private static final String NAME_NULL = null;
	private static final Integer OFFSET_NULL = null;
	private static final String OUTPUT_FULL = "full";
	private static final String SHELTER_NULL = null;
	private static final String shelterId = "MI144";
	private static final String SIZE_NULL = null;
	private static final Character STATUS_NULL = null;

	@Test 
	public void from() {
		PetfinderPetRecord source = petFinderService.randomPet(
				ANIMAL_CAT, BREED_NULL, SIZE_NULL, GENDER_MALE, LOCATION_ZIP,
				SHELTER_NULL, OUTPUT_FULL, FORMAT_NULL);
		PetRecord dest = Convert.from(source);
		assertNotNull(dest);
	}
}
