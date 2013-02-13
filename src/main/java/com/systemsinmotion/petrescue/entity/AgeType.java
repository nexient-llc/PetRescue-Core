package com.systemsinmotion.petrescue.entity;

public enum AgeType {
	BABY("Baby"), YOUNG("Young"), ADULT("Adult"), SENIOR("Senior");

	public static AgeType byDescription(String description) {
		AgeType ageType = null;
		for (AgeType type : AgeType.values()) {
			if (type.description.equalsIgnoreCase(description)) {
				ageType = type;
				break;
			}
		}
		return ageType;
	}

	public String description;

	private AgeType(String description) {
		this.description = description;
	}

}
