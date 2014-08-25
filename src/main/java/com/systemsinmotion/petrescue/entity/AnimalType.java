package com.systemsinmotion.petrescue.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "animalType")
public class AnimalType extends AbstractPersistable<Integer> {

	private static final long serialVersionUID = -2075530308093537937L;

	@Column(name = "name", nullable = false, length = 30)
	private String animalType;

	public String getAnimalType() {
		return animalType.toString();
	}

	public void setAnimalType(String animalType) {
		this.animalType = animalType;
	}
}
