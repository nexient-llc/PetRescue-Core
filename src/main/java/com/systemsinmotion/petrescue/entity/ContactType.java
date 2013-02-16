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

	@Column(name = "address1", length = 50)
	public String getAddress1() {
		return this.address1;
	}

	@Column(name = "address2", length = 50)
	public String getAddress2() {
		return this.address2;
	}

	@Id
	@Column(name = "id")
	@GeneratedValue
	public BigInteger getContactId() {
		return this.contactId;
	}

	@Column(name = "email", length = 100)
	public String getEmail() {
		return this.email;
	}

	@Column(name = "fax", length = 15)
	public String getFax() {
		return this.fax;
	}

	@Column(name = "name", length = 50)
	public String getName() {
		return this.name;
	}

	@Column(name = "phone", length = 15)
	public String getPhone() {
		return this.phone;
	}

	@Column(name = "state", length = 2)
	public String getState() {
		return this.state;
	}

	@Column(name = "zip_code", length = 10)
	public String getZip() {
		return this.zip;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public void setContactId(BigInteger id) {
		this.contactId = id;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFax(String fax) {
		this.fax = fax;
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
