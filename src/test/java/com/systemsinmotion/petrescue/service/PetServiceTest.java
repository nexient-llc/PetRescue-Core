package com.systemsinmotion.petrescue.service;

import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.systemsinmotion.petrescue.data.PetRepository;
import com.systemsinmotion.petrescue.entity.PetRecord;
import com.systemsinmotion.petrescue.entity.type.StatusType;

public class PetServiceTest {
	@InjectMocks
	private PetService petService;

	@Mock
	private PetRepository mockPetRepository;

	@Mock
	private PetRecord mockPetRecord;

	@Before
	public void initialize() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void findAllPets() throws Exception {
		petService.findAllPetRecords();
		verify(mockPetRepository).findAll();
	}

	@Test
	public void findPetsByStatus() throws Exception {
		petService.findByStatus(StatusType.A);
		verify(mockPetRepository).findByStatus(StatusType.A);
	}

	@Test
	public void findPetByID() throws Exception {
		petService.findByID(5);
		verify(mockPetRepository).findOne(5);
	}

	@Test
	public void storePet() throws Exception {
		petService.storePetRecord(mockPetRecord);
		verify(mockPetRepository).saveAndFlush(mockPetRecord);
	}

	@Test
	public void removePet() throws Exception {
		petService.removePetRecord(mockPetRecord);
		verify(mockPetRepository).delete(mockPetRecord);

	}

	@Test
	public void setPetStatus() throws Exception {
		petService.setPetRecordStatus(mockPetRecord, StatusType.A);
		verify(mockPetRecord).setStatus(StatusType.A);
		verify(mockPetRepository).saveAndFlush(mockPetRecord);
	}

}
