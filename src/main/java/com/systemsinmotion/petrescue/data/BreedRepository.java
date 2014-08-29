package com.systemsinmotion.petrescue.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.systemsinmotion.petrescue.entity.Breed;

@Repository("breedRepository")
public interface BreedRepository extends JpaRepository<Breed, Integer> {

	List<Breed> findAllBreedsByAnimalType(String animalTypeName);

	Breed findByName(String name);
}
