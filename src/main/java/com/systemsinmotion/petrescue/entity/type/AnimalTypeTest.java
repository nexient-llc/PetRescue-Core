package com.systemsinmotion.petrescue.entity.type;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.systemsinmotion.petrescue.entity.type.AnimalType;

public class AnimalTypeTest {

	@Test
	public void createAndGetAnimalType() {

		assertEquals(AnimalType.BARN_YARD, AnimalType.fromValue("BarnYard"));
		assertEquals(AnimalType.BIRD, AnimalType.fromValue("Bird"));
		assertEquals(AnimalType.CAT, AnimalType.fromValue("Cat"));
		assertEquals(AnimalType.DOG, AnimalType.fromValue("Dog"));
		assertEquals(AnimalType.HORSE, AnimalType.fromValue("Horse"));
		assertEquals(AnimalType.PIG, AnimalType.fromValue("Pig"));
		assertEquals(AnimalType.RABBIT, AnimalType.fromValue("Rabbit"));
		assertEquals(AnimalType.REPTILE, AnimalType.fromValue("Reptile"));
		assertEquals(AnimalType.SMALL_FURRY,
				AnimalType.fromValue("Small&Furry"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void test() {

		AnimalType.fromValue(AnimalType.BARN_YARD.value() + "mockValue");

	}
}
