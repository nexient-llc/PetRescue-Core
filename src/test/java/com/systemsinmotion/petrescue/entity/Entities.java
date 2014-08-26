package com.systemsinmotion.petrescue.entity;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import com.systemsinmotion.petrescue.entity.type.*;

public class Entities {
	static Random random = new Random();

	public static final String PET_NAME = "Pet name" + random.nextInt();
	public static final String PET_DESCRIPTION = "Pet description"
			+ random.nextInt();
	public static final Integer PET_AGE = random.nextInt();
	public static final Boolean PET_DECLAWED = random.nextBoolean();
	public static final Boolean PET_FIXED = random.nextBoolean();
	public static final Boolean PET_HOUSEBROKEN = random.nextBoolean();
	public static final Boolean PET_NO_CATS = random.nextBoolean();
	public static final Boolean PET_NO_DOGS = random.nextBoolean();
	public static final Boolean PET_NO_KIDS = random.nextBoolean();
	public static final Boolean PET_SPECIAL_NEEDS = random.nextBoolean();
	public static final Boolean PET_VACCINATED = random.nextBoolean();

	public static final AgeType[] ageTypeList = AgeType.values();
	public static final AgeType PET_AGE_TYPE = ageTypeList[random
			.nextInt(ageTypeList.length)];
	public static final GenderType[] genderTypeList = GenderType.values();
	public static final GenderType PET_GENDER_TYPE = genderTypeList[random
			.nextInt(genderTypeList.length)];
	public static final StatusType[] statusTypeList = StatusType.values();
	public static final StatusType PET_STATUS_TYPE = statusTypeList[random
			.nextInt(statusTypeList.length)];
	public static final SizeType[] sizeTypeList = SizeType.values();
	public static final SizeType PET_SIZE_TYPE = sizeTypeList[random
			.nextInt(sizeTypeList.length)];

	public static final String ANIMALTYPE_NAME = "Animal type name"
			+ random.nextInt();

	public static final String LOCATION_CONTACT_NAME = "loc contact name"
			+ random.nextInt();
	public static final String LOCATION_ADDRESS_1 = "loc first address"
			+ random.nextInt();
	public static final String LOCATION_ADDRESS_2 = "loc second address"
			+ random.nextInt();
	public static final String LOCATION_CITY = "loc city" + random.nextInt();
	public static final String LOCATION_STATE_OR_PROVINCE = "loc state or province"
			+ random.nextInt();
	public static final String LOCATION_ZIP_CODE = "loc zip code"
			+ random.nextInt();
	public static final String LOCATION_COUNTRY = "loc country"
			+ random.nextInt();
	public static final String LOCATION_LATITUDE = "loc latitude"
			+ random.nextInt();
	public static final String LOCATION_LONGITUDE = "loc longitude"
			+ random.nextInt();
	public static final String LOCATION_PHONE = "loc phone" + random.nextInt();
	public static final String LOCATION_FAX = "loc fax" + random.nextInt();
	public static final String LOCATION_EMAIL = "loc email" + random.nextInt();
	public static final String LOCATION_DESCRIPTION = "loc description"
			+ random.nextInt();
	public static final Boolean LOCATION_ACCEPT_MORE_PETS = random
			.nextBoolean();

	public static final String BREED_NAME = "Breed name" + random.nextInt();

	public static final String PHOTO_SIZE = "Photo size" + random.nextInt();
	public static final String PHOTO_URL = "Photo url" + random.nextInt();

	// ****************************Pet**********************************
	public static PetRecord pet() {
		PetRecord pet = new PetRecord();
		pet.setAge(PET_AGE);
		pet.setAgeType(PET_AGE_TYPE);
		pet.setAnimal(animalType());
		pet.setBreeds(breeds());
		pet.setDeclawed(PET_DECLAWED);
		pet.setDescription(PET_DESCRIPTION);
		pet.setFixed(PET_FIXED);
		pet.setGender(PET_GENDER_TYPE);
		pet.setHousebroken(PET_HOUSEBROKEN);
		pet.setLocation(location());
		pet.setName(PET_NAME);
		pet.setNoCats(PET_NO_CATS);
		pet.setNoDogs(PET_NO_DOGS);
		pet.setNoKids(PET_NO_KIDS);
		pet.setPhotos(photos());
		pet.setSize(PET_SIZE_TYPE);
		pet.setSpecialNeeds(PET_SPECIAL_NEEDS);
		pet.setStatus(PET_STATUS_TYPE);
		pet.setVaccinated(PET_VACCINATED);
		return pet;

	}

	// **************************Animal Type*******************************
	public static AnimalType animalType() {
		AnimalType animalType = new AnimalType();
		animalType.setAnimalType(ANIMALTYPE_NAME);
		return animalType;
	}

	// ****************************Location*******************************
	public static Location location() {
		Location location = new Location();
		location.setAcceptMorePets(LOCATION_ACCEPT_MORE_PETS);
		location.setAddress1(LOCATION_ADDRESS_1);
		location.setAddress2(LOCATION_ADDRESS_2);
		location.setCity(LOCATION_CITY);
		location.setContactName(LOCATION_CONTACT_NAME);
		location.setCountry(LOCATION_COUNTRY);
		location.setDescription(LOCATION_DESCRIPTION);
		location.setEmail(LOCATION_EMAIL);
		location.setFax(LOCATION_FAX);
		location.setLatitude(LOCATION_LATITUDE);
		location.setLongitude(LOCATION_LONGITUDE);
		location.setPhone(LOCATION_PHONE);
		location.setStateOrProvince(LOCATION_STATE_OR_PROVINCE);
		location.setZipCode(LOCATION_ZIP_CODE);
		return location;
	}

	// ****************************Breed**********************************
	public static Set<Breed> breeds() {
		Breed breed = new Breed();
		breed.setAnimalType(ANIMALTYPE_NAME);
		breed.setName(BREED_NAME);

		Set<Breed> breeds = new HashSet<Breed>();
		breeds.add(breed);
		return breeds;
	}

	// ****************************Photo**********************************
	public static Set<Photo> photos() {
		Photo photo = new Photo();
		photo.setSize(PHOTO_SIZE);
		photo.setUrl(PHOTO_URL);
		
		Set<Photo> photos = new HashSet<Photo>();
		photos.add(photo);
		return photos;

	}

}
