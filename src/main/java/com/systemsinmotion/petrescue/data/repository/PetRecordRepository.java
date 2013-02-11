package com.systemsinmotion.petrescue.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.systemsinmotion.petrescue.entity.PetRecord;

@Repository
public interface PetRecordRepository extends JpaRepository<PetRecord, Long> {

}
