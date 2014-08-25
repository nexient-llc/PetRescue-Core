package com.systemsinmotion.petrescue.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.systemsinmotion.petrescue.entity.AnimalType;

//@formatter:off
@Repository("animalTypeRepository")
public interface AnimalTypeRepository extends JpaRepository<AnimalType, Integer> {

	
	public List<AnimalType> findByAnimalType(String animalType);
	
	public List<AnimalType> findByAnimalTypeLike(String animalType);
	
	
}
// @formatter:on
