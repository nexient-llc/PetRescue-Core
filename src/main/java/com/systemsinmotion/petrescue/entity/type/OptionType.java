package com.systemsinmotion.petrescue.entity.type;

public enum OptionType {
	// @formatter:off
	ALTERED("altered", "Spayed/Neutered"),
	HAS_SHOTS("hasShots", "Up-to-date with routine shots"), 
	HOUSEBROKEN("housebroken", "House trained"), 
	NO_CATS("noCats", "Needs a home with no cats"), 
	NO_CLAWS("noClaws", "Has been declawed"), 
	NO_DOGS("noDogs", "Needs a home with no dogs"), 
	NO_KIDS("noKids", "Needs a home with no young children"), 
	SPECIAL_NEEDS("specialNeeds", "Has special needs");
	// @formatter:on

	public static OptionType byValue(String value) {
		OptionType optionType = null;
		for (OptionType type : OptionType.values()) {
			if (type.value.equalsIgnoreCase(value)) {
				optionType = type;
				break;
			}
		}
		return optionType;
	}

	public String value;

	public String description;

	private OptionType(String value, String description) {
		this.value = value;
		this.description = description;
	}

	public String getValue() {
		return this.value;
	}

}
