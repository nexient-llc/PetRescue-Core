package com.systemsinmotion.petrescue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.petfinder.entity.PetfinderPetRecord;

import com.systemsinmotion.petrescue.web.bean.AdoptionApplication;
import com.systemsinmotion.petrescue.web.bean.CurrentPet;
import com.systemsinmotion.petrescue.web.bean.PreviousPet;
import com.systemsinmotion.petrescue.web.bean.Vet;

public class Entities {
	
	public static final String PETNAME = "Pet name";
	public static final String ANIMALTYPE = "Animal type";

	public static final Boolean AGREEDTOHOMEVISIT = true;
	public static final Boolean AWAREOFUNKNOWNISSUES = true;
	public static final Boolean FAMILYAWARE = true;
	public static final Boolean HAVEAPPLIEDELSEWHERE = true;
	public static final Boolean PETSALLOWED = true;
	public static final Boolean PETSALLOWEDPROOF = true;
	public static final Boolean PLANTOATTENDOBEDIENCECLASSES = true;
	
	public static final Integer ADULTCOUNT = 2;
	public static final Integer CHILDCOUNT = 3;
	public static final Integer CURRENTPETCOUNT = 4;
	public static final Integer HOURSALONE = 5;
	public static final Integer HOUSEHOLDMEMBERCOUNT = 6;
	public static final Integer PREVIOUSPETCOUNT = 7;
	
	public static final String ADDRESS1 = "Address 1";
	public static final String ADDRESS2 = "Address 2";
	public static final String CARETAKER = "Caretaker";
	public static final String CITY = "City";
	public static final String DAYTIMELOCATION = "Day time location";
	public static final String DESTRUCTIVEBEHAVIOR = "Destructive Behavior";
	public static final String EMAIL = "Email";
	public static final String EMAILCONFIRM = "Confirm Email";
	public static final String FAILEDADOPTIONREASON = "Failed adoption reason";
	public static final String FAMILYNOTAWAREREASON = "Family not aware reason";
	public static final String FENCEDYARD = "Fenced Yard";
	public static final String FIRSTNAME = "Firstname";
	public static final String GIVEUPSITUATION = "Give up situation";
	public static final String HOMEPHONE = "Home phone";
	public static final String HOWCONTAINPET = "How contain pet";
	public static final String IDEALPET = "Ideal pet";
	public static final String LASTNAME = "lastname";
	public static final String LIVINGSITUATION = "Living situation";
	public static final String MOBILEPHONE = "mobile phone";
	public static final String MONTHSLIVED = "months lived";
	public static final String MOVINGPLAN = "moving plan";
	public static final String PETLIVINGLOCATION = "pet living location";
	public static final String PLANTODECLAW = "plan to declaw";
	public static final String SLEEPLOCATION = "sleep location";
	public static final String TIMESEARCHING = "time searching";
	public static final String WHEREAPPLIED = "where applied";
	public static final String WILLINGTOINSTALLFENCE = "willing to install fense";
	public static final String YEARSLIVED = "years lived";
	public static final String ZIPCODE = "zipcode";
	
	public static final List<String> WHYWANTPET = Arrays.asList("Reason one", "Reason two", "Reason three");


	public static AdoptionApplication getApplication() {
		AdoptionApplication application = new AdoptionApplication();
		
		List<String> BREEDS;
		List<Integer> CHILDAGES;
		List<CurrentPet> CURRENTPETS;
		List<Integer> HOUSEHOLDMEMBERAGES;
		List<PreviousPet> PREVIOUSPETS;
		List<Vet> VETS;

		PetfinderPetRecord pet = getPet();
		application.setPetName(pet.getName());
		application.setAnimalType(pet.getAnimal().value());
		application.setBreeds(pet.getBreeds().getBreed());

		application.setFirstName(FIRSTNAME);
		application.setLastName(LASTNAME);
		application.setAddress1(ADDRESS1);
		application.setAddress2(ADDRESS2);
		application.setZipCode(ZIPCODE);
		application.setCity(CITY);
		application.setHomePhone(HOMEPHONE);
		application.setMobilePhone(MOBILEPHONE);
		application.setEmail(EMAIL);
		application.setEmailConfirm(EMAILCONFIRM);
		application.setWhyWantPet(WHYWANTPET);

		List<Vet> vets = new ArrayList<Vet>();
		Vet vet = new Vet();
		vet.setName("Mr. Vet");
		vet.setPhone("2342342345");
		vets.add(vet);
		Vet vet2 = new Vet();
		vet2.setName("Mr. Rival");
		vet2.setPhone("2342342346");
		vets.add(vet2);

		application.setVets(vets);

		application.setLivingSituation("rent");
		application.setPetsAllowed(true);
		application.setPetsAllowedProof(true);

		application.setYearsLived("10");
		application.setMonthsLived("0");
		application.setHouseholdMemberCount(3);
		application.setHouseholdMemberAges(Arrays.asList(new Integer[] { 10, 15, 25 }));
		application.setFamilyAware(false);
		application.setFamilyNotAwareReason("Because they smell and I don't talk to them");
		application.setCaretaker("Gramama");

		application.setAwareOfUnknownIssues(true);
		application.setAgreedToHomeVisit(false);

		application.setPetLivingLocation("outside");
		application.setPlanToDeclaw("all");
		application.setDestructiveBehavior("cry");
		application.setAnimalType("DOG");
		application.setHaveAppliedElsewhere(true);
		application.setTimeSearching("along");
		application.setWhereApplied("home");
		application.setSleepLocation("in bed");
		application.setFailedAdoptionReason("None");
		application.setFencedYard("completely");
		application.setGiveUpSituation("None");

		application.setCurrentPetCount(2);
		List<CurrentPet> curPets = new ArrayList<CurrentPet>();
		curPets.add(getCurrentPet("Spike Jr."));
		curPets.add(getCurrentPet("Meow 2"));
		application.setCurrentPets(curPets);

		application.setPreviousPetCount(2);
		List<PreviousPet> prevPets = new ArrayList<PreviousPet>();
		prevPets.add(getPreviousPet("Spike"));
		prevPets.add(getPreviousPet("Meow"));
		application.setPreviousPets(prevPets);

		return application;
	}

	public static PetfinderPetRecord getPet() {
		PetfinderPetRecord pet = new PetfinderPetRecord();

		return pet;
	}
	
	public static PetfinderPetRecord getPet(String name) {
		PetfinderPetRecord pet = getPet();
		pet.setName(name);

		return pet;
		
	}
	
	public static CurrentPet getCurrentPet() {
		CurrentPet pet = new CurrentPet();
		pet.setName("Spike Jr.");
		pet.setBreed("Doggy");
		pet.setAge(1);
		pet.setIsIndoor(true);
		pet.setHasVaccines(true);
		pet.setIsHeartwormed(true);
		pet.setIsSterilized(false);
		return pet;
	}
	
	public static CurrentPet getCurrentPet(String name) {
		CurrentPet pet = getCurrentPet();
		pet.setName(name);
		
		return pet;
	}
	
	public static PreviousPet getPreviousPet() {
		PreviousPet pet = new PreviousPet();
		pet.setName("Spike");
		pet.setBreed("Doggy");
		pet.setAge(5);
		pet.setIsIndoor(true);

		return pet;
	}
	
	public static PreviousPet getPreviousPet(String name) {
		PreviousPet pet = getPreviousPet();
		pet.setName(name);
		
		return pet;
	}
}
