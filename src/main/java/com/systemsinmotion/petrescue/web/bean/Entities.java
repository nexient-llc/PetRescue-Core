package com.systemsinmotion.petrescue.web.bean;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.petfinder.entity.AnimalType;
import org.petfinder.entity.PetfinderBreedList;
import org.petfinder.entity.PetfinderPetRecord;

public class Entities {
	
	public static final String PETNAME = "Pet name";
	public static final String ANIMALTYPE = "Animal type";
	public static final List<String> BREED = Arrays.asList("Breed one", "Breed two", "Breed three");

	public static final Boolean AGREEDTOHOMEVISIT = true;
	public static final Boolean AWAREOFUNKNOWNISSUES = true;
	public static final Boolean FAMILYAWARE = true;
	public static final Boolean HAVEAPPLIEDELSEWHERE = true;
	public static final Boolean PETSALLOWED = true;
	public static final Boolean PETSALLOWEDPROOF = true;
	public static final Boolean PLANTOATTENDOBEDIENCECLASSES = true;
	
	public static final Integer ADULTCOUNT = 2;
	public static final Integer CHILDCOUNT = 3;
	public static final Integer HOURSALONE = 5;
	
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
	public static final List<Integer> HOUSEHOLDMEMBERAGES = Arrays.asList(10,15,20);
	public static final List<Integer> HOUSEHOLDMEMBERAGES1 = Arrays.asList(new Integer[] { 10, 15, 25 });
	public static final List<Integer> CHILDAGES = Arrays.asList(10,15);
	
	public static final List<Vet> VETS = vets();
	public static final List<CurrentPet> CURRENTPETS =currentPets();
	public static final List<PreviousPet> PREVIOUSPETS = previousPets();
	public static final Integer PREVIOUSPETCOUNT = PREVIOUSPETS.size();
	public static final Integer CURRENTPETCOUNT = CURRENTPETS.size();
	public static final Integer HOUSEHOLDMEMBERCOUNT = HOUSEHOLDMEMBERAGES.size();
	


	public static AdoptionApplication getApplication() {
		AdoptionApplication application = new AdoptionApplication();
		

		application.setPetName(PETNAME);
		application.setAnimalType(ANIMALTYPE);
		application.setBreeds(BREED);
		application.setVets(VETS);
		application.setPetLivingLocation(PETLIVINGLOCATION);
		application.setPlanToDeclaw(PLANTODECLAW);
		application.setDestructiveBehavior(DESTRUCTIVEBEHAVIOR);
		application.setAnimalType(ANIMALTYPE);

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
		application.setHouseholdMemberAges(HOUSEHOLDMEMBERAGES);
		application.setHouseholdMemberCount(HOUSEHOLDMEMBERCOUNT);
		application.setFamilyAware(FAMILYAWARE);
		application.setFamilyNotAwareReason(FAMILYNOTAWAREREASON);
		application.setCaretaker(CARETAKER);
		application.setAwareOfUnknownIssues(AWAREOFUNKNOWNISSUES);
		application.setAgreedToHomeVisit(AGREEDTOHOMEVISIT);

		application.setLivingSituation(LIVINGSITUATION);
		application.setPetsAllowed(PETSALLOWED);
		application.setPetsAllowedProof(PETSALLOWEDPROOF);

		application.setYearsLived(YEARSLIVED);
		application.setMonthsLived(MONTHSLIVED);

		application.setHoursAlone(HOURSALONE);
		application.setMovingPlan(MOVINGPLAN);
		application.setIdealPet(IDEALPET);
		application.setHaveAppliedElsewhere(HAVEAPPLIEDELSEWHERE);
		application.setTimeSearching(TIMESEARCHING);
		application.setWhereApplied(WHEREAPPLIED);
		application.setSleepLocation(SLEEPLOCATION);
		application.setFailedAdoptionReason(FAILEDADOPTIONREASON);
		application.setFencedYard(FENCEDYARD);
		application.setHowContainPet(HOWCONTAINPET);
		application.setGiveUpSituation(GIVEUPSITUATION);

		application.setCurrentPetCount(CURRENTPETCOUNT);
		application.setCurrentPets(CURRENTPETS);

		application.setPreviousPetCount(PREVIOUSPETCOUNT);
		application.setPreviousPets(PREVIOUSPETS);

		return application;
	}

	private static List<PreviousPet> previousPets() {
		List<PreviousPet> prevPets = new ArrayList<PreviousPet>();
		prevPets.add(getPreviousPet("Spike"));
		prevPets.add(getPreviousPet("Meow"));
		return prevPets;
	}

	private static List<CurrentPet> currentPets() {
		List<CurrentPet> curPets = new ArrayList<CurrentPet>();
		curPets.add(getCurrentPet("Spike Jr."));
		curPets.add(getCurrentPet("Meow 2"));
		return curPets;
	}

	private static List<Vet> vets() {
		List<Vet> vets = new ArrayList<Vet>();
		Vet vet = new Vet();
		vet.setName("Mr. Vet");
		vet.setPhone("2342342345");
		vets.add(vet);
		Vet vet2 = new Vet();
		vet2.setName("Mr. Rival");
		vet2.setPhone("2342342346");
		vets.add(vet2);
		return vets;
	}

	public static PetfinderPetRecord getPet() {
		PetfinderPetRecord pet = new PetfinderPetRecord();
		pet.setName("Meow");
		pet.setAnimal(AnimalType.CAT);
		pet.setDescription("A kitty cat");
		pet.setId(BigInteger.TEN);
		pet.setMix("Yes");
		
		PetfinderBreedList petBreeds = new PetfinderBreedList();
		pet.setBreeds(petBreeds);

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
		pet.setOwnedHowLong(5);
		pet.setWhereNow("Pet Cemetary");

		return pet;
	}
	
	public static PreviousPet getPreviousPet(String name) {
		PreviousPet pet = getPreviousPet();
		pet.setName(name);
		
		return pet;
	}
}
