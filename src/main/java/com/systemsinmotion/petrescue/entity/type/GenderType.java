package com.systemsinmotion.petrescue.entity.type;

public enum GenderType {
	M("Male"), F("Female"), UNKNOWN("Unknown");

	public String description;

	private GenderType(String description) {
		this.description = description;
	}

	public static GenderType byDescription(String description) {
		GenderType genderType = UNKNOWN;
		for (GenderType type : GenderType.values()) {
			if (type.description.equalsIgnoreCase(description)) {
				genderType = type;
				break;
			}
		}
		return genderType;
	}
}
