package com.systemsinmotion.petrescue.service;

import static org.mockito.Mockito.verify;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.systemsinmotion.petrescue.data.RemoteIdentifierRepository;
import com.systemsinmotion.petrescue.entity.PetRecord;
import com.systemsinmotion.petrescue.entity.RemoteIdentifier;
import com.systemsinmotion.petrescue.entity.type.ApiType;

public class RemoteIdentifierServiceTest {

	@InjectMocks
	private RemoteIdentifierService remoteIdentifierService;

	@Mock
	private RemoteIdentifierRepository remoteIdentifierRepository;

	@Mock
	private RemoteIdentifier remoteIdentifier;

	@Mock
	private PetRecord petRecord;

	@Mock
	private Date date;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void findAllRemoteIdentifiersTest() {

		remoteIdentifierService.findAllRemoteIdentifiers();
		verify(remoteIdentifierRepository).findAll();
	}

	@Test
	public void findPetByIdTest() {

		remoteIdentifierService.findPetById(petRecord);
		verify(remoteIdentifierRepository).findByPet(petRecord);
	}

	@Test
	public void findByRemoteIdTest() {

		remoteIdentifierService.findByRemoteId(petRecord.getName());
		verify(remoteIdentifierRepository).findByRemoteId(petRecord.getName());
	}

	@Test
	public void findLastUpdatedBetweenDatesTest() {

		remoteIdentifierService.findLastUpdatedThatIsLessThan(date);
		verify(remoteIdentifierRepository).findByLastUpdatedLessThan(date);
	}

	@Test
	public void findByLastUpdatedBeforeTest() {

		remoteIdentifierService.findAllLastUpdatedThatIsBefore(date);
		verify(remoteIdentifierRepository).findByLastUpdatedBefore(date);
	}

	@Test
	public void findAllLastUpdatedThatIsAfterTest() {

		remoteIdentifierService.findAllLastUpdatedThatIsAfter(date);
		verify(remoteIdentifierRepository).findByLastUpdatedAfter(date);
	}

	@Test
	public void findByApiTest() {

		remoteIdentifierService.findAllByAPIType(ApiType.PF);
		verify(remoteIdentifierRepository).findByApi(ApiType.PF);
	}

}
