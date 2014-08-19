package com.systemsinmotion.petrescue.entity;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class PetRecordTest {

	private PetRecord petRecord = new PetRecord();

	@Test
	public void setAndGetName() throws Exception {

		petRecord.setName("name");
		assertEquals(petRecord.getName(), "name");
	}

	@Test
	public void setAndGetDescription() throws Exception {

		petRecord.setDescription("description");
		assertEquals(petRecord.getDescription(), "description");
	}

	@Test
	public void testAllSettersAndGetters() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Map<String, Method> getters = getters();
		Map<String, Method> setters = setters();
		
		assertEquals("Number of getters should match setters", setters.size(), getters.size());
		assertEquals("There should be a matching getter for each setter", setters.keySet(), getters.keySet());
		for (String key : setters.keySet())
		{
			Method m = setters.get(key);
			assertEquals("Expected one parameter", 1, m.getParameterCount());
			Parameter[] p = m.getParameters();
			assertEquals("Only expected a single parameters",1,p.length);
			if (p[0].getType().isEnum()) {
				System.out.println("Test: " + p[0].getType().isEnum());
			} else {
				Object o = p[0].getType().newInstance();
				m.invoke(petRecord, o);
			}
		}
	}

	private Map<String, Method> getters() {
		Map<String, Method> map = new HashMap<String, Method>();
		Method[] methods = PetRecord.class.getDeclaredMethods();
		for (Method m : methods) {
			String name = m.getName();
			if (name.startsWith("get")) {
				map.put(name.substring(3), m);
			}
		}

		return map;
	}

	private Map<String, Method> setters() {
		Map<String, Method> map = new HashMap<String, Method>();
		Method[] methods = PetRecord.class.getDeclaredMethods();
		for (Method m : methods) {
			String name = m.getName();
			if (name.startsWith("set")) {
				map.put(name.substring(3), m);
			}
		}

		return map;
	}
}
