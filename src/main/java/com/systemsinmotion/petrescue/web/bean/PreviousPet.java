package com.systemsinmotion.petrescue.web.bean;

import java.io.Serializable;

public class PreviousPet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2806484124715032595L;
	String name;
	Integer age;
	String breed;
	Boolean isIndoor;

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

	public void setIndoor(Boolean isIndoor) {
		this.isIndoor = isIndoor;
	}
}
