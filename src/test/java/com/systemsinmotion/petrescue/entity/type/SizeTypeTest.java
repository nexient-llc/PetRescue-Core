package com.systemsinmotion.petrescue.entity.type;

import static org.junit.Assert.*;

import org.junit.Test;

import com.systemsinmotion.petrescue.entity.type.SizeType;

public class SizeTypeTest {

	@Test
	public void typeSmall() {
		assertEquals(SizeType.S, SizeType.byDescription("small"));
	}
	
	@Test
	public void typeMedium() {
		assertEquals(SizeType.M, SizeType.byDescription("MEDIUM"));
	}
	
	@Test
	public void typeLarge() {
		assertEquals(SizeType.L, SizeType.byDescription("LaRgE"));
	}
	
	@Test
	public void typeXLarge() {
		assertEquals(SizeType.XL, SizeType.byDescription("XLarge"));
	}
}
