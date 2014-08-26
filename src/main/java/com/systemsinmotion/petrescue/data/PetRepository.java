package com.systemsinmotion.petrescue.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.systemsinmotion.petrescue.entity.PetRecord;
import com.systemsinmotion.petrescue.entity.type.StatusType;

@Repository("petRepository")
public interface PetRepository extends JpaRepository<PetRecord, Integer> {

	List<PetRecord> findByStatus(StatusType status);

	List<PetRecord> findByStatus(String status);
	
}
