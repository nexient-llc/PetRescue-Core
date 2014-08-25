package com.systemsinmotion.petrescue.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "breed")
public class Breed extends AbstractPersistable<Integer> {

	private static final long serialVersionUID = 6033007191596936036L;

	@Column(name = "animal", nullable = false, length = 30)
	private String animal;

	@Column(name = "breeds", nullable = false, length = 30)
	private List<String> breeds;

	public String getAnimal() {
		return animal;
	}

	public void setAnimal(String animal) {
		this.animal = animal;
	}

	public void setBreed(String breed) {
		this.breeds.add(animal);
	}

	public List<String> getBreeds() {
		return this.breeds;
	}
}
