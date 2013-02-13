package com.systemsinmotion.petrescue.entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class ContactType {
	private BigInteger contactId;

	private String name;

	private String address1;

	private String address2;

	private String state;

	private String zip;

	private String phone;

	private String fax;

	private String email;

	public String getAddress1() {
		return this.address1;
	}

	public String getAddress2() {
		return this.address2;
	}

	public String getEmail() {
		return this.email;
	}

	public String getFax() {
		return this.fax;
	}

	@Id
	@Column(name = "id")
	@GeneratedValue
	public BigInteger getContactId() {
		return this.contactId;
	}

	public String getName() {
		return this.name;
	}

	public String getPhone() {
		return this.phone;
	}

	public String getState() {
		return this.state;
	}

	public String getZip() {
		return this.zip;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public void setContactId(BigInteger id) {
		this.contactId = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

}
