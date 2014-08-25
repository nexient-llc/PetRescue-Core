package com.systemsinmotion.petrescue.entity.type;


public enum AnimalType {

	/* @formatter:off */
	BARN_YARD("BarnYard"), 
	BIRD("Bird"), 
	CAT("Cat"), 
	DOG("Dog"), 
	HORSE("Horse"), 
	PIG("Pig"), 
	RABBIT("Rabbit"), 
	REPTILE("Reptile"),
	SMALL_FURRY("Small&Furry");
	/* @formatter:on */

	private final String value;

	AnimalType(String v) {
		value = v;
	}

	public String value() {
		return value;
	}

	public static AnimalType fromValue(String v) {
		for (AnimalType c : AnimalType.values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}

}
