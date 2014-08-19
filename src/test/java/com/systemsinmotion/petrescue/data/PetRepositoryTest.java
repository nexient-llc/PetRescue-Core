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
import com.systemsinmotion.petrescue.entity.PetRecord;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PetRescueConfig.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class PetRepositoryTest {

	@Autowired
	PetRepository repository;
	
	@Before
	public void init() {
	}
	
	@Test
	public void findAll() {
		List<PetRecord> records = repository.findAll();
		assertNotNull(records);
		assertTrue(records.size() > 0);
		assertNotNull(records.get(0));
	}
}
