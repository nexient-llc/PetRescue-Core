package com.systemsinmotion.petrescue.entity.type;

import static org.junit.Assert.*;

import org.junit.Test;

import com.systemsinmotion.petrescue.entity.type.GenderType;

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
