package com.systemsinmotion.petrescue.datamanager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.systemsinmotion.petrescue.data.BreedRepository;
import com.systemsinmotion.petrescue.entity.Breed;

@Service("breedManager")
public class BreedManager {
	@Autowired
	BreedRepository breedRepository;

	public List<Breed> findAllBreedsByAnimalTypeName(String animalTypeName) {
		return this.breedRepository.findAllBreedsByAnimalType(animalTypeName);
	}

	public Breed findById(int id) {
		return this.breedRepository.findOne(id);
	}

	public List<Breed> findAllBreeds() {
		return this.breedRepository.findAll();
	}

	public Breed storeBreed(Breed breed) {
		return this.breedRepository.saveAndFlush(breed);
	}

	public void removeBreed(Breed breed) {
		breedRepository.delete(breed);
	}

}
