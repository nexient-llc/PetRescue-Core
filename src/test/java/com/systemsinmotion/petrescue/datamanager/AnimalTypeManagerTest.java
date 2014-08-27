package com.systemsinmotion.petrescue.datamanager;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.systemsinmotion.petrescue.data.AnimalTypeRepository;
import com.systemsinmotion.petrescue.entity.AnimalType;


public class AnimalTypeManagerTest {
	@InjectMocks
	private AnimalTypeManager animalTypeManager;
	
	@Mock
	private AnimalTypeRepository mockAnimalTypeRepository;
	
	@Mock
	private AnimalType mockAnimalType;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testFindAllAnimalTypes() throws Exception {
		animalTypeManager.findAll();
		verify(mockAnimalTypeRepository).findAll();
	}

	@Test
	public void testFindAnimalTypeByName() throws Exception {
		animalTypeManager.findAnimalTypeByName("");
		verify(mockAnimalTypeRepository).findByName("");
	}
	
	@Test
	public void testFindAnimalTypeById() throws Exception {
		int id = 0;
		animalTypeManager.findAnimalTypeById(id);
		verify(mockAnimalTypeRepository).findOne(id);
	}
	
	@Test
	public void testSaveAnimalType() throws Exception {
		animalTypeManager.storeAnimalType(mockAnimalType);
		verify(mockAnimalTypeRepository).saveAndFlush(mockAnimalType);
	}
	
	@Test
	public void testDeleteAnimalType() throws Exception {
		animalTypeManager.removeAnimalType(mockAnimalType);
		verify(mockAnimalTypeRepository).delete(mockAnimalType);
	}

}
