package com.systemsinmotion.petrescue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.systemsinmotion.petrescue.data.PetRepository;
import com.systemsinmotion.petrescue.entity.PetRecord;
import com.systemsinmotion.petrescue.entity.type.StatusType;

@Service("petService")
public class PetService {
	@Autowired
	PetRepository repository;

	public List<PetRecord> findAllPetRecords() {
		return this.repository.findAll();
	}

	public List<PetRecord> findByStatus(StatusType status) {
		return this.repository.findByStatus(status);
	}

	public PetRecord findByID(Integer id) {
		return this.repository.findOne(id);
	}

	public PetRecord storePetRecord(PetRecord petRecord) {
		return repository.saveAndFlush(petRecord);
	}

	public void removePetRecord(PetRecord petRecord) {
		repository.delete(petRecord);
	}

	public void setPetRecordStatus(PetRecord petRecord, StatusType status) {
		petRecord.setStatus(status);
		storePetRecord(petRecord);
	}

	public void storeAllPets(List<PetRecord> pets) {
		this.repository.save(pets);
	}
}
