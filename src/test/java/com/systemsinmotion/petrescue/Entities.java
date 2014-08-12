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
	
	private static final String PETNAME = "PETNAME";
	private static final String ANIMALTYPE = "ANIMALTYPE";

	private static final Boolean AGREEDTOHOMEVISIT = true;
	private static final Boolean AWAREOFUNKNOWNISSUES = true;
	private static final Boolean FAMILYAWARE = true;
	private static final Boolean HAVEAPPLIEDELSEWHERE = true;
	private static final Boolean PETSALLOWED = true;
	private static final Boolean PETSALLOWEDPROOF = true;
	private static final Boolean PLANTOATTENDOBEDIENCECLASSES = true;
	private static final Integer ADULTCOUNT = 2;
	private static final Integer CHILDCOUNT = 3;
	private static final Integer CURRENTPETCOUNT = 4;
	private static final Integer HOURSALONE = 5;
	private static final Integer HOUSEHOLDMEMBERCOUNT = 6;
	private static final Integer PREVIOUSPETCOUNT = 7;
	private static final String ADDRESS1 = "ADDRESS1";
	private static final String ADDRESS2 = "ADDRESS2";
	private static final String CARETAKER = "CARETAKER";
	private static final String CITY = "CITY";
	private static final String DAYTIMELOCATION = "DAYTIMELOCATION";
	private static final String DESTRUCTIVEBEHAVIOR = "DESTRUCTIVEBEHAVIOR";
	private static final String EMAIL = "EMAIL";
	private static final String EMAILCONFIRM = "EMAILCONFIRM";
	private static final String FAILEDADOPTIONREASON = "FAILEDADOPTIONREASON";
	private static final String FAMILYNOTAWAREREASON = "FAMILYNOTAWAREREASON";
	private static final String FENCEDYARD = "FENCEDYARD";
	private static final String FIRSTNAME = "FIRSTNAME";
	private static final String GIVEUPSITUATION = "GIVEUPSITUATION";
	private static final String HOMEPHONE = "HOMEPHONE";
	private static final String HOWCONTAINPET = "HOWCONTAINPET";
	private static final String IDEALPET = "IDEALPET";
	private static final String LASTNAME = "LASTNAME";
	private static final String LIVINGSITUATION = "LIVINGSITUATION";
	private static final String MOBILEPHONE = "MOBILEPHONE";
	private static final String MONTHSLIVED = "MONTHSLIVED";
	private static final String MOVINGPLAN = "MOVINGPLAN";
	private static final String PETLIVINGLOCATION = "PETLIVINGLOCATION";
	private static final String PLANTODECLAW = "PLANTODECLAW";
	private static final String SLEEPLOCATION = "SLEEPLOCATION";
	private static final String TIMESEARCHING = "TIMESEARCHING";
	private static final String WHEREAPPLIED = "WHEREAPPLIED";
	private static final String WILLINGTOINSTALLFENCE = "WILLINGTOINSTALLFENCE";
	private static final String YEARSLIVED = "YEARSLIVED";
	private static final String ZIPCODE = "ZIPCODE";


	public static AdoptionApplication getApplication() {
		AdoptionApplication application = new AdoptionApplication();
		
		List<String> BREEDS;
		List<Integer> CHILDAGES;
		List<CurrentPet> CURRENTPETS;
		List<Integer> HOUSEHOLDMEMBERAGES;
		List<PreviousPet> PREVIOUSPETS;
		List<Vet> VETS;
		List<String> WHYWANTPET;

		PetfinderPetRecord pet = getPet();
		application.setPetName(pet.getName());
		application.setAnimalType(pet.getAnimal().value());
		application.setBreeds(pet.getBreeds().getBreed());

		application.setFirstName("Bob");
		application.setLastName("Law");
		application.setAddress1("1234 Unknown Av");
		application.setAddress2("Apt -1");
		application.setZipCode("48197");
		application.setCity("Ypsitucky");
		application.setHomePhone("2342342345");
		application.setMobilePhone("2342342345");
		application.setEmail("bob@law.com");
		application.setEmailConfirm("bob@law.com");
		application.setWhyWantPet(Arrays.asList("Reason one", "Reason two", "Reason three"));

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

	private static PetfinderPetRecord getPet() {
		PetfinderPetRecord pet = new PetfinderPetRecord();

		return pet;
	}
	
	private static PetfinderPetRecord getPet(String name) {
		PetfinderPetRecord pet = getPet();
		pet.setName(name);

		return pet;
		
	}
	
	private static CurrentPet getCurrentPet() {
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
	
	private static CurrentPet getCurrentPet(String name) {
		CurrentPet pet = getCurrentPet();
		pet.setName(name);
		
		return pet;
	}
	
	private static PreviousPet getPreviousPet() {
		PreviousPet pet = new PreviousPet();
		pet.setName("Spike");
		pet.setBreed("Doggy");
		pet.setAge(5);
		pet.setIsIndoor(true);

		return pet;
	}
	
	private static PreviousPet getPreviousPet(String name) {
		PreviousPet pet = getPreviousPet();
		pet.setName(name);
		
		return pet;
	}
}
