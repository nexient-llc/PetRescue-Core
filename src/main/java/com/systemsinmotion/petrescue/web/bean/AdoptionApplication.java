package com.systemsinmotion.petrescue.web.bean;

import java.io.Serializable;
import java.util.List;

import com.systemsinmotion.petrescue.entity.PetRecord;
import com.systemsinmotion.util.OutputUtils;

public class AdoptionApplication implements Serializable {

	private static final long serialVersionUID = 1118000426493607246L;

	private PetRecord pet;
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

	public PetRecord getPet() {
		return pet;
	}

	public void setPet(PetRecord pet) {
		this.pet = pet;
	}

	public Boolean getAgreedToHomeVisit() {
		return agreedToHomeVisit;
	}

	public void setAgreedToHomeVisit(Boolean agreedToHomeVisit) {
		this.agreedToHomeVisit = agreedToHomeVisit;
	}

	public Boolean getAwareOfUnknownIssues() {
		return awareOfUnknownIssues;
	}

	public void setAwareOfUnknownIssues(Boolean awareOfUnknownIssues) {
		this.awareOfUnknownIssues = awareOfUnknownIssues;
	}

	public Boolean getFamilyAware() {
		return familyAware;
	}

	public void setFamilyAware(Boolean familyAware) {
		this.familyAware = familyAware;
	}

	public Boolean getHaveAppliedElsewhere() {
		return haveAppliedElsewhere;
	}

	public void setHaveAppliedElsewhere(Boolean haveAppliedElsewhere) {
		this.haveAppliedElsewhere = haveAppliedElsewhere;
	}

	public Boolean getPetsAllowed() {
		return petsAllowed;
	}

	public void setPetsAllowed(Boolean petsAllowed) {
		this.petsAllowed = petsAllowed;
	}

	public Boolean getPetsAllowedProof() {
		return petsAllowedProof;
	}

	public void setPetsAllowedProof(Boolean petsAllowedProof) {
		this.petsAllowedProof = petsAllowedProof;
	}

	public Boolean getPlanToAttendObedienceClasses() {
		return planToAttendObedienceClasses;
	}

	public void setPlanToAttendObedienceClasses(Boolean planToAttendObedienceClasses) {
		this.planToAttendObedienceClasses = planToAttendObedienceClasses;
	}

	public Integer getAdultCount() {
		return adultCount;
	}

	public void setAdultCount(Integer adultCount) {
		this.adultCount = adultCount;
	}

	public Integer getChildCount() {
		return childCount;
	}

	public void setChildCount(Integer childCount) {
		this.childCount = childCount;
	}

	public Integer getCurrentPetCount() {
		return currentPetCount;
	}

	public void setCurrentPetCount(Integer currentPetCount) {
		this.currentPetCount = currentPetCount;
	}

	public Integer getHoursAlone() {
		return hoursAlone;
	}

	public void setHoursAlone(Integer hoursAlone) {
		this.hoursAlone = hoursAlone;
	}

	public Integer getHouseholdMemberCount() {
		return householdMemberCount;
	}

	public void setHouseholdMemberCount(Integer householdMemberCount) {
		this.householdMemberCount = householdMemberCount;
	}

	public Integer getPreviousPetCount() {
		return previousPetCount;
	}

	public void setPreviousPetCount(Integer previousPetCount) {
		this.previousPetCount = previousPetCount;
	}

	public List<Integer> getChildAges() {
		return childAges;
	}

	public void setChildAges(List<Integer> childAges) {
		this.childAges = childAges;
	}

	public List<Integer> getHouseholdMemberAges() {
		return householdMemberAges;
	}

	public void setHouseholdMemberAges(List<Integer> householdMemberAges) {
		this.householdMemberAges = householdMemberAges;
	}

	public List<PreviousPet> getPreviousPets() {
		return previousPets;
	}

	public void setPreviousPets(List<PreviousPet> previousPets) {
		this.previousPets = previousPets;
	}

	public List<Vet> getVets() {
		return vets;
	}

	public void setVets(List<Vet> vets) {
		this.vets = vets;
	}

	public List<String> getWhyWantPet() {
		return whyWantPet;
	}

	public void setWhyWantPet(List<String> whyWantPet) {
		this.whyWantPet = whyWantPet;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCaretaker() {
		return caretaker;
	}

	public void setCaretaker(String caretaker) {
		this.caretaker = caretaker;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDaytimeLocation() {
		return daytimeLocation;
	}

	public void setDaytimeLocation(String daytimeLocation) {
		this.daytimeLocation = daytimeLocation;
	}

	public String getDestructiveBehavior() {
		return destructiveBehavior;
	}

	public void setDestructiveBehavior(String destructiveBehavior) {
		this.destructiveBehavior = destructiveBehavior;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmailConfirm() {
		return emailConfirm;
	}

	public void setEmailConfirm(String emailConfirm) {
		this.emailConfirm = emailConfirm;
	}

	public String getFailedAdoptionReason() {
		return failedAdoptionReason;
	}

	public void setFailedAdoptionReason(String failedAdoptionReason) {
		this.failedAdoptionReason = failedAdoptionReason;
	}

	public String getFamilyNotAwareReason() {
		return familyNotAwareReason;
	}

	public void setFamilyNotAwareReason(String familyNotAwareReason) {
		this.familyNotAwareReason = familyNotAwareReason;
	}

	public String getFencedYard() {
		return fencedYard;
	}

	public void setFencedYard(String fencedYard) {
		this.fencedYard = fencedYard;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGiveUpSituation() {
		return giveUpSituation;
	}

	public void setGiveUpSituation(String giveUpSituation) {
		this.giveUpSituation = giveUpSituation;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getHowContainPet() {
		return howContainPet;
	}

	public void setHowContainPet(String howContainPet) {
		this.howContainPet = howContainPet;
	}

	public String getIdealPet() {
		return idealPet;
	}

	public void setIdealPet(String idealPet) {
		this.idealPet = idealPet;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLivingSituation() {
		return livingSituation;
	}

	public void setLivingSituation(String livingSituation) {
		this.livingSituation = livingSituation;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getMonthsLived() {
		return monthsLived;
	}

	public void setMonthsLived(String monthsLived) {
		this.monthsLived = monthsLived;
	}

	public String getMovingPlan() {
		return movingPlan;
	}

	public void setMovingPlan(String movingPlan) {
		this.movingPlan = movingPlan;
	}

	public String getPetLivingLocation() {
		return petLivingLocation;
	}

	public void setPetLivingLocation(String petLivingLocation) {
		this.petLivingLocation = petLivingLocation;
	}

	public String getPlanToDeclaw() {
		return planToDeclaw;
	}

	public void setPlanToDeclaw(String planToDeclaw) {
		this.planToDeclaw = planToDeclaw;
	}

	public String getSleepLocation() {
		return sleepLocation;
	}

	public void setSleepLocation(String sleepLocation) {
		this.sleepLocation = sleepLocation;
	}

	public String getTimeSearching() {
		return timeSearching;
	}

	public void setTimeSearching(String timeSearching) {
		this.timeSearching = timeSearching;
	}

	public String getWhereApplied() {
		return whereApplied;
	}

	public void setWhereApplied(String whereApplied) {
		this.whereApplied = whereApplied;
	}

	public String getWillingToInstallFence() {
		return willingToInstallFence;
	}

	public void setWillingToInstallFence(String willingToInstallFence) {
		this.willingToInstallFence = willingToInstallFence;
	}

	public String getYearsLived() {
		return yearsLived;
	}

	public void setYearsLived(String yearsLived) {
		this.yearsLived = yearsLived;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return OutputUtils.toString(this);
	}
}
