package com.systemsinmotion.petrescue.entity.type;

public enum AgeType {
	BABY("Baby"), YOUNG("Young"), ADULT("Adult"), SENIOR("Senior"), UNKNOWN(
			"Unknown");

	public static AgeType byDescription(String description) {
		AgeType ageType = UNKNOWN;
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
