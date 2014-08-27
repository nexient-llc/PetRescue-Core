package com.systemsinmotion.petrescue.datamanager;

import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.systemsinmotion.petrescue.data.PetRepository;
import com.systemsinmotion.petrescue.datamanager.PetManager;
import com.systemsinmotion.petrescue.entity.PetRecord;
import com.systemsinmotion.petrescue.entity.type.StatusType;

public class PetManagerTest {
	@InjectMocks
	private PetManager petManager;

	@Mock
	private PetRepository mockPetRepository;

	@Mock
	private PetRecord mockPetRecord;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void findAllPets() throws Exception {
		petManager.findAllPetRecords();
		verify(mockPetRepository).findAll();
	}

	@Test
	public void findPetsByStatus() throws Exception {
		petManager.findByStatus(StatusType.A);
		verify(mockPetRepository).findByStatus(StatusType.A);
	}

	@Test
	public void findPetByID() throws Exception {
		petManager.findByID(5);
		verify(mockPetRepository).findOne(5);
	}

	@Test
	public void storePet() throws Exception {
		petManager.storePetRecord(mockPetRecord);
		verify(mockPetRepository).saveAndFlush(mockPetRecord);
	}

	@Test
	public void removePet() throws Exception {
		petManager.removePetRecord(mockPetRecord);
		verify(mockPetRepository).delete(mockPetRecord);

	}

	@Test
	public void setPetStatus() throws Exception {
		petManager.setPetRecordStatus(mockPetRecord, StatusType.A);
		verify(mockPetRecord).setStatus(StatusType.A);
		verify(mockPetRepository).saveAndFlush(mockPetRecord);
	}
	
	@Test
	public void storeAllPets() throws Exception {
		List<PetRecord> pets = null;
		petManager.storeAllPets(pets);
		verify(mockPetRepository).save(pets);
	}

}
