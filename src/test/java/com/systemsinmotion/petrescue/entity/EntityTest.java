package com.systemsinmotion.petrescue.entity;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import java.util.Date;

import org.junit.Test;

public class EntityTest {

	private static final String CREATOR = "creator";

	@Test
	public void setAndGetCreator() {

		Entity entity = new Entity();
		entity.setCreator(EntityTest.CREATOR);
		assertEquals(entity.getCreator(), EntityTest.CREATOR);

	}

	@Test
	public void setAndGetTimestamp() {

		Entity entity = new Entity();
		Date mockDate = mock(Date.class);
		entity.setCreatedTimestamp(mockDate);

		assertEquals(entity.getCreatedTimestamp(), mockDate);

	}

	@Test
	public void setAndGetUpdatedTimestamp() {

		Entity entity = new Entity();

		Date mockDate = mock(Date.class);
		entity.setUpdatedTimestamp(mockDate);
		assertEquals(entity.getUpdatedTimestamp(), mockDate);

	}

	@Test
	public void setAndGetUpdateCreator() {

		Entity entity = new Entity();

		entity.setUpdator(EntityTest.CREATOR);
		assertEquals(entity.getUpdator(), EntityTest.CREATOR);
	}
}
