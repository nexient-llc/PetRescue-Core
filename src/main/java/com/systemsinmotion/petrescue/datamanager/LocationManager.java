package com.systemsinmotion.petrescue.datamanager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.systemsinmotion.petrescue.data.LocationRepository;
import com.systemsinmotion.petrescue.entity.Location;

@Service("locationManager")
public class 

LocationManager {
	@Autowired
	LocationRepository locationRepository;

	public List<Location> findAll() {
		return locationRepository.findAll();
	}

	public Location findById(int id) {
		return locationRepository.findOne(id);
	}

	public Location findByContactName(String contactName) {
		return locationRepository.findByContactName(contactName);
	}

	public Location findByAddress(String address) {
		return locationRepository.findByAddress1(address);
	}

	public Location storeLocation(Location location) {
		return this.locationRepository.saveAndFlush(location);
	}

	public void removeLocation(Location location) {
		this.locationRepository.delete(location);
	}

}
