package com.systemsinmotion.petrescue.web.bean;

import java.io.Serializable;

public class PreviousPet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2806484124715032595L;
	String name;
	Integer ownedHowLong;
	String breed;
	String whereNow;
	
	public String getName() {
		return name;
	}

	public void setName(String petName) {
		this.name = petName;
	}

	public Integer getOwnedHowLong() {
		return ownedHowLong;
	}

	public void setOwnedHowLong(Integer petAge) {
		this.ownedHowLong = petAge;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String petBreed) {
		this.breed = petBreed;
	}

	public String getWhereNow() {
		return whereNow;
	}

	public void setWhereNow(String whereNow) {
		this.whereNow = whereNow;
	}
}
