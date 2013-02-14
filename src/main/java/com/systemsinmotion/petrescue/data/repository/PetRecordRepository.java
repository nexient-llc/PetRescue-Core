package com.systemsinmotion.petrescue.data.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.systemsinmotion.petrescue.entity.PetRecord;

@Repository
public interface PetRecordRepository extends JpaRepository<PetRecord, BigInteger> {

	@Override
	PetRecord findOne(BigInteger petId);

}
