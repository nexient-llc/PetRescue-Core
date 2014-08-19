package com.systemsinmotion.petrescue.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name="location")
public class Location extends AbstractPersistable<Integer> {

	private static final long serialVersionUID = -1072427076791969399L;
	
	@Column(name="contact_name", nullable=false, length=100)
	private String contactName;
	
	@Column(name="address1", nullable=false, length=50)
	private String address1;

	@Column(name="address2", nullable=false, length=50)
	private String address2;
	
	@Column(name="City", nullable=false, length=20)
	private String city;
	
	@Column(name="state_or_province", nullable=false, length=20)
	private String stateOrProvince;
	
	@Column(name="zip_code", nullable=false, length=20)
	private String zipCode;
	
	@Column(name="country", nullable=false, length=20)
	private String country;

	@Column(name="latitude", length=10)
	private String latitude;
	
	@Column(name="longitude", length=10)
	private String longitude;
	
	@Column(name="phone", length=15)
	private String phone;
	
	@Column(name="fax", length=15)
	private String fax;
	
	@Column(name="email", nullable=false, length=100)
	private String email;
	
	@Column(name="description", length=255)
	private String description;
	
	@Column(name="accept_more_pets")
	private Boolean acceptMorePets;

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStateOrProvince() {
		return stateOrProvince;
	}

	public void setStateOrProvince(String stateOrProvince) {
		this.stateOrProvince = stateOrProvince;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getAcceptMorePets() {
		return acceptMorePets;
	}

	public void setAcceptMorePets(Boolean acceptMorePets) {
		this.acceptMorePets = acceptMorePets;
	}
}
