package com.systemsinmotion.petrescue.datamanager;

import static org.mockito.Mockito.verify;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.systemsinmotion.petrescue.data.RemoteIdentifierRepository;
import com.systemsinmotion.petrescue.datamanager.RemoteIdentifierManager;
import com.systemsinmotion.petrescue.entity.PetRecord;
import com.systemsinmotion.petrescue.entity.RemoteIdentifier;
import com.systemsinmotion.petrescue.entity.type.ApiType;

public class RemoteIdentifierManagerTest {

	@InjectMocks
	private RemoteIdentifierManager remoteIdentifierManager;

	@Mock
	private RemoteIdentifierRepository remoteIdentifierRepository;

	@Mock
	private RemoteIdentifier remoteIdentifier;

	@Mock
	private PetRecord petRecord;

	@Mock
	private Date date;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void findAllRemoteIdentifiersTest() {

		remoteIdentifierManager.findAllRemoteIdentifiers();
		verify(remoteIdentifierRepository).findAll();
	}

	@Test
	public void findPetByIdTest() {

		remoteIdentifierManager.findPetById(petRecord);
		verify(remoteIdentifierRepository).findByPet(petRecord);
	}

	@Test
	public void findByRemoteIdTest() {

		remoteIdentifierManager.findByRemoteId(petRecord.getName());
		verify(remoteIdentifierRepository).findByRemoteId(petRecord.getName());
	}

	@Test
	public void findLastUpdatedBetweenDatesTest() {

		remoteIdentifierManager.findLastUpdatedThatIsLessThan(date);
		verify(remoteIdentifierRepository).findByLastUpdatedLessThan(date);
	}

	@Test
	public void findByLastUpdatedBeforeTest() {

		remoteIdentifierManager.findAllLastUpdatedThatIsBefore(date);
		verify(remoteIdentifierRepository).findByLastUpdatedBefore(date);
	}

	@Test
	public void findAllLastUpdatedThatIsAfterTest() {

		remoteIdentifierManager.findAllLastUpdatedThatIsAfter(date);
		verify(remoteIdentifierRepository).findByLastUpdatedAfter(date);
	}

	@Test
	public void findByApiTest() {

		remoteIdentifierManager.findAllByAPIType(ApiType.PF);
		verify(remoteIdentifierRepository).findByApi(ApiType.PF);
	}

}
