package com.systemsinmotion.petrescue.datamanager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.systemsinmotion.petrescue.data.PetRepository;
import com.systemsinmotion.petrescue.entity.PetRecord;
import com.systemsinmotion.petrescue.entity.type.StatusType;

@Service("petService")
public class PetManager {
	@Autowired
	PetRepository petRepository;

	public List<PetRecord> findAllPetRecords() {
		return this.petRepository.findAll();
	}

	public List<PetRecord> findByStatus(StatusType status) {
		return this.petRepository.findByStatus(status);
	}

	public PetRecord findByID(Integer id) {
		return this.petRepository.findOne(id);
	}

	public PetRecord storePetRecord(PetRecord petRecord) {
		return petRepository.saveAndFlush(petRecord);
	}

	public void removePetRecord(PetRecord petRecord) {
		petRepository.delete(petRecord);
	}

	public void setPetRecordStatus(PetRecord petRecord, StatusType status) {
		petRecord.setStatus(status);
		storePetRecord(petRecord);
	}

	public void storeAllPets(List<PetRecord> pets) {
		this.petRepository.save(pets);
	}
}
