package com.systemsinmotion.petrescue.web.bean;

import java.io.Serializable;

public class CurrentPet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -627381892573085128L;
	String name;
	Integer age;
	String breed;
	Boolean isIndoor;
	Boolean isSterilized;
	Boolean hasVaccines;
	Boolean isHeartwormed;

	public String getName() {
		return name;
	}

	public void setName(String petName) {
		this.name = petName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer petAge) {
		this.age = petAge;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String petBreed) {
		this.breed = petBreed;
	}

	public Boolean getIsIndoor() {
		return this.isIndoor;
	}

	public void setIsIndoor(Boolean isIndoor) {
		this.isIndoor = isIndoor;
	}

	public Boolean getIsSterilized() {
		return this.isSterilized;
	}

	public void setIsSterilized(Boolean isSterilized) {
		this.isSterilized = isSterilized;
	}

	public Boolean getHasVaccines() {
		return this.hasVaccines;
	}

	public void setHasVaccines(Boolean hasVaccines) {
		this.hasVaccines = hasVaccines;
	}

	public Boolean getIsHeartwormed() {
		return this.isHeartwormed;
	}

	public void setIsHeartwormed(Boolean isHeartwormed) {
		this.isHeartwormed = isHeartwormed;
	}
}
