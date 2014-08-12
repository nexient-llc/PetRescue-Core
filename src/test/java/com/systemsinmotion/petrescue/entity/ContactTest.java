package com.systemsinmotion.petrescue.entity;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

import org.junit.Test;
import org.mockito.Mockito;

public class ContactTest {

	ContactType mockType = new ContactType();

	@Test
	public void setContactIdAndgetContactId() throws Exception {

		BigInteger mock = Mockito.mock(BigInteger.class);
		mockType.setContactId(mock);
		assertEquals(mockType.getContactId(), mock);

	}

	@Test
	public void setAndGetAddressOneAndTwo() throws Exception {

		mockType.setAddress1("1234");
		mockType.setAddress2("1234");
		assertEquals(mockType.getAddress1(), mockType.getAddress2());
	}

	@Test
	public void setAndGetZip() throws Exception {

		mockType.setZip("1234");
		assertEquals(mockType.getZip(), "1234");

	}

	@Test
	public void setAndGetState() throws Exception {
		mockType.setState("State");
		assertEquals(mockType.getState(), "State");
	}

	@Test
	public void setAndGetEmail() throws Exception {

		mockType.setEmail("email");
		assertEquals(mockType.getEmail(), "email");
	}

	@Test
	public void setAndGetPhone() throws Exception {

		mockType.setPhone("phone");
		assertEquals(mockType.getPhone(), "phone");
	}

	@Test
	public void setAndGetName() throws Exception {
		mockType.setName("name");

		assertEquals(mockType.getName(), "name");
	}

	@Test
	public void setAndGetFax() throws Exception {
		mockType.setFax("fax");
		assertEquals(mockType.getFax(), "fax");
	}

}
