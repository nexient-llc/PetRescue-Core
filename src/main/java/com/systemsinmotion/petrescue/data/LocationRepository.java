package com.systemsinmotion.petrescue.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.systemsinmotion.petrescue.entity.Location;

@Repository("locationRepository")
public interface LocationRepository extends JpaRepository<Location, Integer> {

	Location findByContactName(String contactName);

	Location findByAddress1(String address);

}
