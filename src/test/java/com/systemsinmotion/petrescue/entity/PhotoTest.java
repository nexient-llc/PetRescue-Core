package com.systemsinmotion.petrescue.entity;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.mockito.Mock;

public class PhotoTest {

	@Mock
	Photo mockPhoto = mock(Photo.class);

	@Mock
	PetRecord mockPet = mock(PetRecord.class);

	@Test
	public void setAndGetPet() throws Exception {

		doCallRealMethod().when(mockPhoto).setPet(mockPet);
		doCallRealMethod().when(mockPhoto).getPet();
		mockPhoto.setPet(mockPet);
		verify(mockPhoto).setPet(mockPet);
		assertEquals(mockPhoto.getPet(), mockPet);
	}

	@Test
	public void setAndGetSize() throws Exception {

		doCallRealMethod().when(mockPhoto).setSize("size");
		doCallRealMethod().when(mockPhoto).getSize();

		mockPhoto.setSize("size");
		verify(mockPhoto).setSize("size");
		assertEquals(mockPhoto.getSize(), "size");
	}

	@Test
	public void setAndGetUri() throws Exception {

		doCallRealMethod().when(mockPhoto).setUri("uri");
		doCallRealMethod().when(mockPhoto).getUri();

		mockPhoto.setUri("uri");
		verify(mockPhoto).setUri("uri");
		assertEquals(mockPhoto.getUri(), "uri");
	}

}
