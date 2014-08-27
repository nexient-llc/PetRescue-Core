package com.systemsinmotion.petrescue.datamanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.systemsinmotion.petrescue.data.LocationRepository;

@Service("locationManager")
public class LocationManager {
	@Autowired
	LocationRepository locationRepository;

}
