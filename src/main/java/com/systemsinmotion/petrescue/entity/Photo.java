package com.systemsinmotion.petrescue.entity;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

// @Entity
@Table(name = "photo")
class Photo extends AbstractPersistable<Long> {

	private static final long serialVersionUID = 7179570524027044221L;

	@ManyToOne
	@JoinColumn(name = "pet_id")
	private PetRecord pet;

	@Column(name = "size_type", length = 6, nullable = false)
	private String size;

	@Column(name = "uri", length = 150, nullable = false)
	private String uri;

	public PetRecord getPet() {
		return this.pet;
	}

	public String getSize() {
		return this.size;
	}

	public String getUri() {
		return this.uri;
	}

	public void setPet(PetRecord pet) {
		this.pet = pet;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

}
