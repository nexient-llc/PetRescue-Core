package com.systemsinmotion.petrescue.datamanager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.systemsinmotion.petrescue.data.AnimalTypeRepository;
import com.systemsinmotion.petrescue.entity.AnimalType;

@Service("animalTypeService")
public class AnimalTypeManager {

	@Autowired
	private AnimalTypeRepository animalTypeRepository;

	public void saveAnimalType(AnimalType animalType) {
		this.animalTypeRepository.save(animalType);
	}

	public AnimalType findAnimalTypeById(Integer id) {
		return this.animalTypeRepository.findOne(id);
	}

	public List<AnimalType> findAllByAnimalType(String animalType) {
		return this.animalTypeRepository.findByAnimalType(animalType);
	}

	public List<AnimalType> findAllLikeThisAnimalType(String animalType) {
		return this.animalTypeRepository.findByAnimalTypeLike(animalType);
	}

}
