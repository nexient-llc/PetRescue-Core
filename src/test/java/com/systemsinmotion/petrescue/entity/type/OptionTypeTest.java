package com.systemsinmotion.petrescue.entity.type;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.systemsinmotion.petrescue.entity.type.OptionType;

public class OptionTypeTest {

	@Test
	public void typeAltered() {
		assertEquals(OptionType.ALTERED, OptionType.byValue("altered"));
	}

	@Test
	public void typeHasShots() {
		assertEquals(OptionType.HAS_SHOTS, OptionType.byValue("hasshots"));
	}

	@Test
	public void typeHouseBroken() {
		assertEquals(OptionType.HOUSEBROKEN, OptionType.byValue("housebroken"));
	}

	@Test
	public void typeNoCats() {
		assertEquals(OptionType.NO_CATS, OptionType.byValue("noCats"));
	}

	@Test
	public void typeNoClaws() {
		assertEquals(OptionType.NO_CLAWS, OptionType.byValue("noClaws"));
	}

	@Test
	public void typeNoDogs() {
		assertEquals(OptionType.NO_DOGS, OptionType.byValue("nodogs"));
	}

	@Test
	public void typeNoKids() {
		assertEquals(OptionType.NO_KIDS, OptionType.byValue("NOKIDS"));
	}

	@Test
	public void typeSpecialNeeds() {
		assertEquals(OptionType.SPECIAL_NEEDS, OptionType.byValue("specialNeeds"));
	}
}
