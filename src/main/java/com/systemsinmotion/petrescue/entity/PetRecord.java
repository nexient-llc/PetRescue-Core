package com.systemsinmotion.petrescue.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pet_record")
public class PetRecord extends com.systemsinmotion.petrescue.entity.Entity {

	private static final long serialVersionUID = -3413224203938895552L;

	private Long id;

	private String shelterId;

	private String shelterPetId;

	private String name;

	private Long petFinderId;

	private AnimalType animalType;

	@Id
	@Column(name = "id")
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "shelter_id", nullable = false, length = 20)
	public String getShelterId() {
		return shelterId;
	}

	public void setShelterId(String shelterId) {
		this.shelterId = shelterId;
	}

	@Column(name = "shelter_pet_id", length = 20)
	public String getShelterPetId() {
		return shelterPetId;
	}

	public void setShelterPetId(String shelterPetId) {
		this.shelterPetId = shelterPetId;
	}

	@Column(name = "pet_name", nullable = false, length = 50)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "pet_finder_id")
	public Long getPetFinderId() {
		return petFinderId;
	}

	public void setPetFinderId(Long petFinderId) {
		this.petFinderId = petFinderId;
	}

	@Column(name = "animal_type", nullable = false, columnDefinition = "")
	public AnimalType getAnimalType() {
		return animalType;
	}

	public void setAnimalType(AnimalType animalType) {
		this.animalType = animalType;
	}

}
