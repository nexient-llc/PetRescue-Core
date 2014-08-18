package com.systemsinmotion.petrescue.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.systemsinmotion.petrescue.entity.type.AnimalType;

@Entity
@Table(name="animal")
public class Animal extends AbstractPersistable<Integer> {

	private static final long serialVersionUID = -2075530308093537937L;

	@Column(name="name", nullable=false, length=30)
	private AnimalType animalType;

	public AnimalType getAnimalType() {
		return animalType;
	}

	public void setAnimalType(AnimalType animalType) {
		this.animalType = animalType;
	}
}
