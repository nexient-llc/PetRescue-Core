package com.systemsinmotion.petrescue.util;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.petfinder.entity.PetfinderPetRecord;
import org.petfinder.entity.PetfinderPetRecord.Media.Photos;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;

import com.systemsinmotion.petrescue.entity.PetRecord;
import com.systemsinmotion.petrescue.entity.Photo;
import com.systemsinmotion.petrescue.service.PetService;
import com.systemsinmotion.petrescue.service.RemoteIdentifierService;
import com.systemsinmotion.petrescue.web.PetFinderConsumer;
import com.systemsinmotion.util.DataBaseBackUpUtil;

public class DataBaseBackUpUtilTest {

	@InjectMocks
	private DataBaseBackUpUtil dataBaseBackUpUtil;

	@Mock
	private PetFinderConsumer petFinderConsumer;

	@Mock
	private DataBaseBackUpUtil mockDataBaseBackUpUtil;

	@Mock
	private PetService petService;

	@Mock
	private PetRecord petRecord;

	@Mock
	private PetfinderPetRecord petfinderPetRecord;

	// @Mock
	// Logger logger;

	@Mock
	private Environment environment;

	@Mock
	private Photo photo;

	@Mock
	private Photos photos;

	@Mock
	private RemoteIdentifierService remoteIdentifierService;

	@Before
	public void before() {
		MockitoAnnotations.initMocks(this);

	}

	@Order(1)
	@Test
	public void GetCronPropertyTest() throws Exception {

		dataBaseBackUpUtil.getCronProperty();
		verify(environment)
				.getProperty("backup.cron.intervolve", "00 00 * * *");

	}

	@Test
	public void updateDataBaseTest() throws Exception {

		dataBaseBackUpUtil.updateDataBase();
		verify(mockDataBaseBackUpUtil).updateDataBase();
	}
}
