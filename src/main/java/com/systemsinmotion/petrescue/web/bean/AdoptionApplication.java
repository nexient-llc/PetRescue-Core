package com.systemsinmotion.petrescue.web.bean;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.systemsinmotion.util.OutputUtils;

@XmlRootElement
public class AdoptionApplication implements Serializable {

	private static final long serialVersionUID = 1118000426493607246L;

	private String petName;
	private String animalType;
	private List<String> breeds;

	private Boolean agreedToHomeVisit;
	private Boolean awareOfUnknownIssues;
	private Boolean familyAware;
	private Boolean haveAppliedElsewhere;
	private Boolean petsAllowed;
	private Boolean petsAllowedProof;
	private Boolean planToAttendObedienceClasses;
	private Integer adultCount;
	private Integer childCount;
	private Integer currentPetCount;
	private Integer hoursAlone;
	private Integer householdMemberCount;
	private Integer previousPetCount;
	private List<Integer> childAges;
	private List<CurrentPet> currentPets;
	private List<Integer> householdMemberAges;
	private List<PreviousPet> previousPets;
	private List<Vet> vets;
	private List<String> whyWantPet;
	private String address1;
	private String address2;
	private String caretaker;
	private String city;
	private String daytimeLocation;
	private String destructiveBehavior;
	private String email;
	private String emailConfirm;
	private String failedAdoptionReason;
	private String familyNotAwareReason;
	private String fencedYard;
	private String firstName;
	private String giveUpSituation;
	private String homePhone;
	private String howContainPet;
	private String idealPet;
	private String lastName;
	private String livingSituation;
	private String mobilePhone;
	private String monthsLived;
	private String movingPlan;
	private String petLivingLocation;
	private String planToDeclaw;
	private String sleepLocation;
	private String timeSearching;
	private String whereApplied;
	private String willingToInstallFence;
	private String yearsLived;
	private String zipCode;

	public String getAddress1() {
		return this.address1;
	}

	public String getAddress2() {
		return this.address2;
	}

	public Integer getAdultCount() {
		return this.adultCount;
	}

	public Boolean getAgreedToHomeVisit() {
		return this.agreedToHomeVisit;
	}

	public String getAnimalType() {
		return this.animalType;
	}

	public Boolean getAwareOfUnknownIssues() {
		return this.awareOfUnknownIssues;
	}

	public List<String> getBreeds() {
		return this.breeds;
	}

	public String getCaretaker() {
		return this.caretaker;
	}

	public List<Integer> getChildAges() {
		return this.childAges;
	}

	public Integer getChildCount() {
		return this.childCount;
	}

	public String getCity() {
		return this.city;
	}

	public Integer getCurrentPetCount() {
		return this.currentPetCount;
	}
	
	public List<CurrentPet> getCurrentPets() {
		return this.currentPets;
	}

	public String getDaytimeLocation() {
		return this.daytimeLocation;
	}

	public String getDestructiveBehavior() {
		return this.destructiveBehavior;
	}

	public String getEmail() {
		return this.email;
	}

	public String getEmailConfirm() {
		return this.emailConfirm;
	}

	public String getFailedAdoptionReason() {
		return this.failedAdoptionReason;
	}

	public Boolean getFamilyAware() {
		return this.familyAware;
	}

	public String getFamilyNotAwareReason() {
		return this.familyNotAwareReason;
	}

	public String getFencedYard() {
		return this.fencedYard;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getGiveUpSituation() {
		return this.giveUpSituation;
	}

	public Boolean getHaveAppliedElsewhere() {
		return this.haveAppliedElsewhere;
	}

	public String getHomePhone() {
		return this.homePhone;
	}

	public Integer getHoursAlone() {
		return this.hoursAlone;
	}

	public List<Integer> getHouseholdMemberAges() {
		return this.householdMemberAges;
	}

	public Integer getHouseholdMemberCount() {
		return this.householdMemberCount;
	}

	public String getHowContainPet() {
		return this.howContainPet;
	}

	public String getIdealPet() {
		return this.idealPet;
	}

	public String getLastName() {
		return this.lastName;
	}

	public String getLivingSituation() {
		return this.livingSituation;
	}

	public String getMobilePhone() {
		return this.mobilePhone;
	}

	public String getMonthsLived() {
		return this.monthsLived;
	}

	public String getMovingPlan() {
		return this.movingPlan;
	}

	public String getPetLivingLocation() {
		return this.petLivingLocation;
	}

	public String getPetName() {
		return this.petName;
	}

	public Boolean getPetsAllowed() {
		return this.petsAllowed;
	}

	public Boolean getPetsAllowedProof() {
		return this.petsAllowedProof;
	}

	public Boolean getPlanToAttendObedienceClasses() {
		return this.planToAttendObedienceClasses;
	}

	public String getPlanToDeclaw() {
		return this.planToDeclaw;
	}

	public Integer getPreviousPetCount() {
		return this.previousPetCount;
	}

	public List<PreviousPet> getPreviousPets() {
		return this.previousPets;
	}

	public String getSleepLocation() {
		return this.sleepLocation;
	}

	public String getTimeSearching() {
		return this.timeSearching;
	}

	public List<Vet> getVets() {
		return this.vets;
	}

	public String getWhereApplied() {
		return this.whereApplied;
	}

	public List<String> getWhyWantPet() {
		return this.whyWantPet;
	}

	public String getWillingToInstallFence() {
		return this.willingToInstallFence;
	}

	public String getYearsLived() {
		return this.yearsLived;
	}

	public String getZipCode() {
		return this.zipCode;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public void setAdultCount(Integer adultCount) {
		this.adultCount = adultCount;
	}

	public void setAgreedToHomeVisit(Boolean agreedToHomeVisit) {
		this.agreedToHomeVisit = agreedToHomeVisit;
	}

	public void setAnimalType(String animalType) {
		this.animalType = animalType;
	}

	public void setAwareOfUnknownIssues(Boolean awareOfUnknownIssues) {
		this.awareOfUnknownIssues = awareOfUnknownIssues;
	}

	public void setBreeds(List<String> breeds) {
		this.breeds = breeds;
	}

	public void setCaretaker(String caretaker) {
		this.caretaker = caretaker;
	}

	public void setChildAges(List<Integer> childAges) {
		this.childAges = childAges;
	}

	public void setChildCount(Integer childCount) {
		this.childCount = childCount;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setCurrentPetCount(Integer currentPetCount) {
		this.currentPetCount = currentPetCount;
	}
	
	public void setCurrentPets(List<CurrentPet> currentPets) {
		this.currentPets = currentPets;
	}

	public void setDaytimeLocation(String daytimeLocation) {
		this.daytimeLocation = daytimeLocation;
	}

	public void setDestructiveBehavior(String destructiveBehavior) {
		this.destructiveBehavior = destructiveBehavior;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setEmailConfirm(String emailConfirm) {
		this.emailConfirm = emailConfirm;
	}

	public void setFailedAdoptionReason(String failedAdoptionReason) {
		this.failedAdoptionReason = failedAdoptionReason;
	}

	public void setFamilyAware(Boolean familyAware) {
		this.familyAware = familyAware;
	}

	public void setFamilyNotAwareReason(String familyNotAwareReason) {
		this.familyNotAwareReason = familyNotAwareReason;
	}

	public void setFencedYard(String fencedYard) {
		this.fencedYard = fencedYard;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setGiveUpSituation(String giveUpSituation) {
		this.giveUpSituation = giveUpSituation;
	}

	public void setHaveAppliedElsewhere(Boolean haveAppliedElsewhere) {
		this.haveAppliedElsewhere = haveAppliedElsewhere;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public void setHoursAlone(Integer hoursAlone) {
		this.hoursAlone = hoursAlone;
	}

	public void setHouseholdMemberAges(List<Integer> householdMemberAges) {
		this.householdMemberAges = householdMemberAges;
	}

	public void setHouseholdMemberCount(Integer householdMemberCount) {
		this.householdMemberCount = householdMemberCount;
	}

	public void setHowContainPet(String howContainPet) {
		this.howContainPet = howContainPet;
	}

	public void setIdealPet(String idealPet) {
		this.idealPet = idealPet;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setLivingSituation(String livingSituation) {
		this.livingSituation = livingSituation;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public void setMonthsLived(String monthsLived) {
		this.monthsLived = monthsLived;
	}

	public void setMovingPlan(String movingPlan) {
		this.movingPlan = movingPlan;
	}

	public void setPetLivingLocation(String petLivingLocation) {
		this.petLivingLocation = petLivingLocation;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public void setPetsAllowed(Boolean petsAllowed) {
		this.petsAllowed = petsAllowed;
	}

	public void setPetsAllowedProof(Boolean petsAllowedProof) {
		this.petsAllowedProof = petsAllowedProof;
	}

	public void setPlanToAttendObedienceClasses(Boolean planToAttendObedienceClasses) {
		this.planToAttendObedienceClasses = planToAttendObedienceClasses;
	}

	public void setPlanToDeclaw(String planToDeclaw) {
		this.planToDeclaw = planToDeclaw;
	}

	public void setPreviousPetCount(Integer previousPetCount) {
		this.previousPetCount = previousPetCount;
	}

	public void setPreviousPets(List<PreviousPet> previousPets) {
		this.previousPets = previousPets;
	}

	public void setSleepLocation(String sleepLocation) {
		this.sleepLocation = sleepLocation;
	}

	public void setTimeSearching(String timeSearching) {
		this.timeSearching = timeSearching;
	}

	public void setVets(List<Vet> vets) {
		this.vets = vets;
	}

	public void setWhereApplied(String whereApplied) {
		this.whereApplied = whereApplied;
	}

	public void setWhyWantPet(List<String> whyWantPet) {
		this.whyWantPet = whyWantPet;
	}

	public void setWillingToInstallFence(String willingToInstallFence) {
		this.willingToInstallFence = willingToInstallFence;
	}

	public void setYearsLived(String yearsLived) {
		this.yearsLived = yearsLived;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return OutputUtils.toString(this);
	}
}
