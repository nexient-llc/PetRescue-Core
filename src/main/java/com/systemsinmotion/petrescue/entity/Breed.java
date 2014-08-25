package com.systemsinmotion.petrescue.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "breed")
public class Breed extends AbstractPersistable<Integer> {

	private static final long serialVersionUID = 6033007191596936036L;

	@Column(name = "name", nullable = false, length = 30)
	private String name;

	@Column(name = "animalType", nullable = false, length = 30)
	private String animalType;

	public String getName() {
		return this.name;
	}

	public String getAnimalType() {
		return animalType;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAnimalType(String animalType) {
		this.animalType = animalType;
	}
}
