package com.systemsinmotion.petrescue.data;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.systemsinmotion.petrescue.config.PetRescueConfig;
import com.systemsinmotion.petrescue.entity.Entities;
import com.systemsinmotion.petrescue.entity.Location;
import com.systemsinmotion.petrescue.entity.PetRecord;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PetRescueConfig.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class PetRepositoryTest {

	@Autowired
	PetRepository repository;
	
	
	private PetRecord petRecord;
	private Location location;
	
	
	@Before
	public void init() {
//		location = Entities.location();
//		locationRepo.save(location);
//		
//		petRecord = Entities.pet();
//		petRecord.setLocation(location);
//		
//		repository.saveAndFlush(Entities.pet());
	}
	
	@Test
	public void findAll() {
		List<PetRecord> records = repository.findAll();
		assertNotNull(records);
		assertTrue(records.size() > 0);
		assertNotNull(records.get(0));
	}
}
