package com.systemsinmotion.petrescue.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.petfinder.entity.AnimalType;
import org.petfinder.entity.PetGenderType;
import org.petfinder.entity.PetfinderBreedList;
import org.petfinder.entity.PetfinderPetRecord;
import org.petfinder.entity.PetfinderPetRecordList;
import org.petfinder.entity.PetfinderShelterRecord;
import org.petfinder.entity.PetfinderShelterRecordList;
import org.petfinder.web.service.QueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:META-INF/spring/petrescue-core.xml" })
public class PetFinderConsumerTest {

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

	@Autowired
	PetFinderConsumer petFinderService;

	@Test
	public void catBreedList() {
		final PetfinderBreedList breedList = this.petFinderService.breedList(
				ANIMAL_CAT, null);
		assertNotNull(breedList);
		assertTrue(breedList.getAnimal().equals(ANIMAL_CAT));
	}

	@Test
	public void dogBreedList() {
		final PetfinderBreedList breedList = this.petFinderService.breedList(
				ANIMAL_DOG, null);
		assertNotNull(breedList);
		assertTrue(breedList.getAnimal().equals(ANIMAL_DOG));
	}

	// @Ignore
	@Test
	public void buildQuery() {
		Map<QueryParam, Object> params = new TreeMap<QueryParam, Object>();
		params.put(QueryParam.animal, ANIMAL_CAT);
		params.put(QueryParam.breed, BREED_DOMESTIC_SHORT_HAIR);
		final String token = this.petFinderService.authData().getToken();
		final String query = this.petFinderService.buildQuery(token, params,
				true);
		assertTrue(query.contains("&animal=cat"));
		assertTrue(query.contains("&breed=Domestic%20Short%20Hair"));
	}

	// @Ignore
	@Test
	public void findPet() {
		final PetfinderPetRecordList petRecordList = this.petFinderService
				.findPet(ANIMAL_CAT, BREED_NULL, SIZE_NULL, GENDER_MALE,
						LOCATION_ZIP, AGE_ADULT, OFFSET_NULL, COUNT_NULL,
						OUTPUT_FULL, FORMAT_NULL);
		assertNotNull(petRecordList);
		final List<PetfinderPetRecord> pets = petRecordList.getPet();
		assertNotNull(pets);
		assertTrue(pets.size() > 0);
		final PetfinderPetRecord pet = pets.get(0);
		assertNotNull(pet);
		assertEquals(AnimalType.CAT, pet.getAnimal());
		assertEquals(PetGenderType.M, pet.getSex());
	}

	// @Ignore
	@Test
	public void findShelter() {
		final PetfinderShelterRecordList shelterRecordList = this.petFinderService
				.findShelter(LOCATION_ZIP, NAME_NULL, OFFSET_NULL, COUNT_NULL,
						FORMAT_NULL);
		assertNotNull(shelterRecordList);

	}

	// @Ignore
	@Test
	public void getPet() {
		final PetfinderPetRecord randomPet = this.petFinderService.randomPet(
				ANIMAL_CAT, BREED_NULL, SIZE_NULL, GENDER_MALE, LOCATION_ZIP,
				SHELTER_NULL, OUTPUT_FULL, FORMAT_NULL);
		assertNotNull(randomPet);
		assertEquals(AnimalType.CAT, randomPet.getAnimal());
		assertEquals(PetGenderType.M, randomPet.getSex());

		final PetfinderPetRecord pet = this.petFinderService.readPet(
				randomPet.getId(), null);
		assertNotNull(pet);
		assertEquals(randomPet.getId(), pet.getId());
	}

	// @Ignore
	@Test
	public void getShelter() {
		final PetfinderShelterRecord shelter = this.petFinderService
				.readShelter(FORMAT_NULL);
		assertNotNull(shelter);
		assertEquals(shelterId, shelter.getId());
	}

	// @Ignore
	@Test
	public void randomPet() {
		final PetfinderPetRecord randomPet = this.petFinderService.randomPet(
				ANIMAL_CAT, null, null, GENDER_MALE, LOCATION_ZIP, null,
				OUTPUT_FULL, null);
		assertNotNull(randomPet);
		assertEquals(AnimalType.CAT, randomPet.getAnimal());
	}

	// @Ignore
	@Test
	public void shelterCats() {
		final List<PetfinderPetRecord> cats = this.petFinderService
				.shelterCats(STATUS_NULL, OFFSET_NULL, COUNT_NULL, OUTPUT_FULL,
						FORMAT_NULL);
		assertNotNull(cats);
		for (PetfinderPetRecord cat : cats) {
			assertNotNull(cat);
			assertTrue(cat.getAnimal().equals(AnimalType.CAT));
		}
	}

	// @Ignore
	@Test
	public void shelterDogs() {
		final List<PetfinderPetRecord> dogs = this.petFinderService
				.shelterDogs(STATUS_NULL, OFFSET_NULL, COUNT_NULL, OUTPUT_FULL,
						FORMAT_NULL);
		assertNotNull(dogs);
		for (PetfinderPetRecord dog : dogs) {
			assertNotNull(dog);
			assertTrue(dog.getAnimal().equals(AnimalType.DOG));
		}
	}

	// @Ignore
	@Test
	public void shelterPets() {
		List<PetfinderPetRecord> pets = this.petFinderService.shelterPets(
				STATUS_NULL, OFFSET_NULL, COUNT_NULL, OUTPUT_FULL, FORMAT_NULL);
		assertNotNull(pets);
		PetfinderPetRecord pet = pets.get(0);
		assertNotNull(pet);
	}

	@Ignore
	// takes over a minute to return results from PetFinder
	@Test
	public void shelterPetsByBreed() {
		final PetfinderShelterRecordList recordList = this.petFinderService
				.shelterPetsByBreed(ANIMAL_CAT, BREED_DOMESTIC_SHORT_HAIR, 0,
						1, FORMAT_NULL);
		assertNotNull(recordList);
	}
}
