package com.systemsinmotion.petrescue.datamanager;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.systemsinmotion.petrescue.data.LocationRepository;
import com.systemsinmotion.petrescue.entity.Location;

public class LocationManagerTest {
	int id;
	Random random;
	@InjectMocks
	LocationManager locationManager;
	
	@Mock
	LocationRepository mockLocationRepository;
	
	@Mock
	Location mockLocation;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		random = new Random();
		id = random.nextInt();
	}

	@Test
		public void testFindAllLocations() throws Exception {
			locationManager.findAllLocations();
			verify(mockLocationRepository).findAll();
		}
	
	@Test
		public void testFindLocationById() throws Exception {
			locationManager.findLocationById(id);
			verify(mockLocationRepository).findOne(id);
		}
	
	@Test
	public void testFindByContactName() throws Exception {
		String contactName = "";
		locationManager.findByContactName(contactName);
		verify(mockLocationRepository).findByContactName(contactName);
	}
	
	@Test
	public void testFindByAddress() throws Exception {
		String address = "";
		locationManager.findByAddress(address);
		verify(mockLocationRepository).findByAddress1(address);
	}

	@Test
	public void testStoreLocation() throws Exception {
		locationManager.storeLocation(mockLocation);
		verify(mockLocationRepository).saveAndFlush(mockLocation);
	}
	
	@Test
	public void testRemoveLocation() throws Exception {
		locationManager.removeLocation(mockLocation);
		verify(mockLocationRepository).delete(mockLocation);
	}
}
