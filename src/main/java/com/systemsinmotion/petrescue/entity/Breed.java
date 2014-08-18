package com.systemsinmotion.petrescue.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name="breed")
public class Breed extends AbstractPersistable<Integer> {

	private static final long serialVersionUID = 6033007191596936036L;

	@Column(name="name", nullable=false, length=30)
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "animal_id", nullable=false)
	private Animal animal;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
}
