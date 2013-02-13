package com.systemsinmotion.petrescue.entity;

public enum GenderType {
	M("Male"), F("Female");

	public String description;

	private GenderType(String description) {
		this.description = description;
	}

	public static GenderType byDescription(String description) {
		GenderType genderType = null;
		for (GenderType type : GenderType.values()) {
			if (type.description.equalsIgnoreCase(description)) {
				genderType = type;
				break;
			}
		}
		return genderType;
	}
}
