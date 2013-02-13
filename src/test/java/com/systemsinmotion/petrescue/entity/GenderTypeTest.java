package com.systemsinmotion.petrescue.entity;

import static org.junit.Assert.*;

import org.junit.Test;

public class GenderTypeTest {

	@Test
	public void typeMale() {
		assertEquals(GenderType.M, GenderType.byDescription("male"));
	}
	
	@Test
	public void typeFemale() {
		assertEquals(GenderType.F, GenderType.byDescription("FEMALE"));
	}
}
