package com.systemsinmotion.petrescue.entity.type;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.systemsinmotion.petrescue.entity.type.StatusType;

public class StatusTypeTest {

	@Test
	public void testDescription() throws Exception {

		assertEquals(StatusType.A, StatusType.byDescription("adoptable"));
		assertEquals(StatusType.H, StatusType.byDescription("hold"));
		assertEquals(StatusType.P, StatusType.byDescription("pending"));
		assertEquals(StatusType.X, StatusType.byDescription("adopted"));

	}
}
