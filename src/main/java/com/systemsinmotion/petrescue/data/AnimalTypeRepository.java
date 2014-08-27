package com.systemsinmotion.petrescue.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.systemsinmotion.petrescue.entity.AnimalType;

@Repository("animalTypeRepository")
public interface AnimalTypeRepository extends JpaRepository<AnimalType, Integer> {
	
	public AnimalType findByName(String animalType);
	
}
