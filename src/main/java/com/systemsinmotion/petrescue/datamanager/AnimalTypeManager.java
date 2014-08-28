package com.systemsinmotion.petrescue.datamanager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.systemsinmotion.petrescue.data.AnimalTypeRepository;
import com.systemsinmotion.petrescue.entity.AnimalType;

@Service("animalTypeManager")
public class AnimalTypeManager {

	@Autowired
	private 
	AnimalTypeRepository animalTypeRepository;

	public AnimalType findAnimalTypeById(Integer id) {
		return this.animalTypeRepository.findOne(id);
	}

	public AnimalType findAnimalTypeByName(String name) {
		return this.animalTypeRepository.findByAnimalType(name);
	}

	public List<AnimalType> findAll() {
		return this.animalTypeRepository.findAll();
	}
	
	public AnimalType storeAnimalType(AnimalType animalType) {
		return this.animalTypeRepository.saveAndFlush(animalType);
	}

	public void removeAnimalType(AnimalType animalType) {
		this.animalTypeRepository.delete(animalType);
		
	}

}
