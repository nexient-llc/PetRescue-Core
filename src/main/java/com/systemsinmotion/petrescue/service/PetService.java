package com.systemsinmotion.petrescue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.systemsinmotion.petrescue.data.PetRepository;
import com.systemsinmotion.petrescue.entity.PetRecord;

@Service("petService")
public class PetService {
	@Autowired
	PetRepository repository;
	
	public List<PetRecord> findAllPetRecords(){
		return this.repository.findAll();
	}
	public List<PetRecord> findByStatus(String status){
		return this.repository.findByStatus(status);
	}
	
	public PetRecord findByID(Integer id){
		return this.repository.findOne(id);
	}
	
	public PetRecord storePetRecord(PetRecord pet){
		return repository.saveAndFlush(pet);
	}
	
	public void removePetRecord(PetRecord pet){
		repository.delete(pet);
	}
}
