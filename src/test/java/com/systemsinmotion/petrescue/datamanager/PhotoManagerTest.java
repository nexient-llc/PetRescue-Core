package com.systemsinmotion.petrescue.datamanager;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.systemsinmotion.petrescue.data.PhotoRepository;
import com.systemsinmotion.petrescue.entity.Photo;

public class PhotoManagerTest {
	Random random;
	int id;
	@InjectMocks
	PhotoManager photoManager;
	
	@Mock
	PhotoRepository mockPhotoRepository;
	
	@Mock
	Photo mockPhoto;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		random = new Random();
		id = random.nextInt();
	}
	
	@Test
	public void testGetPhotoById() throws Exception {
		photoManager.findPhotoById(id);
		verify(mockPhotoRepository).findOne(id);
	}
	
	@Test
	public void testGetAllPhotos() throws Exception {
		photoManager.findAllPhotos();
		verify(mockPhotoRepository).findAll();
	}
	
	@Test
	public void testGetPhotoByPetId() throws Exception {
		photoManager.findPhotosByPetId(id);
		verify(mockPhotoRepository).findByPetId(id);
		
	}
	
	@Test
	public void testStorePhoto() throws Exception {
		photoManager.storePhoto(mockPhoto);
		verify(mockPhotoRepository).saveAndFlush(mockPhoto);
		
	}
	
	@Test
	public void testRemovePhoto() throws Exception {
		photoManager.removePhoto(mockPhoto);
		verify(mockPhotoRepository).delete(mockPhoto);
		
	}

}
