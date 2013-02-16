package com.systemsinmotion.petrescue.entity;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
class Photo implements Serializable {

	private static final long serialVersionUID = 7179570524027044221L;

	private BigInteger id;

	private BigInteger petId;

	private String size;

	private String uri;

	@Id
	@Column(name = "id")
	@GeneratedValue
	public BigInteger getId() {
		return this.id;
	}

	@ManyToOne
	@JoinColumn(name = "pet_id", nullable = false)
	public BigInteger getPetId() {
		return this.petId;
	}

	@Column(name = "size_type", length = 6, nullable = false)
	public String getSize() {
		return this.size;
	}

	@Column(name = "uri", length = 150, nullable = false)
	public String getUri() {
		return this.uri;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public void setPetId(BigInteger petId) {
		this.petId = petId;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

}
