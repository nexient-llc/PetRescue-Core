package com.systemsinmotion.petrescue.entity;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class Photo implements Serializable {

	private static final long serialVersionUID = 7179570524027044221L;

	private String uri;

	private BigInteger id;

	private String size;

	@Id
	@Column(name = "id")
	@GeneratedValue
	public BigInteger getId() {
		return this.id;
	}

	public String getSize() {
		return this.size;
	}

	public String getUri() {
		return this.uri;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

}
