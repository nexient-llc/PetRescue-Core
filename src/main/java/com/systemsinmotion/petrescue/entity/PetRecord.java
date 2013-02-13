package com.systemsinmotion.petrescue.entity;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pet_record")
public class PetRecord extends com.systemsinmotion.petrescue.entity.Entity {

	private static final long serialVersionUID = -3413224203938895552L;

	protected BigInteger petId;

	protected BigInteger petFinderId;

	protected String shelterId;

	protected String shelterPetId;

	protected String name;

	protected AnimalType animal;

	protected List<String> breeds;

	protected String mix;

	protected AgeType age;

	protected GenderType gender;

	protected SizeType size;

	protected List<OptionType> options;

	protected String description;

	protected Date petFinderLastUpdate;

	protected StatusType status;

	protected List<Photo> photos;

	protected ContactType contact;

	@Column(name = "age_type", length = 10)
	public AgeType getAge() {
		return this.age;
	}

	@Column(name = "animal_type", length = 20)
	public AnimalType getAnimal() {
		return this.animal;
	}

	@ElementCollection
	@CollectionTable(name = "pet_breeds", joinColumns = @JoinColumn(name = "pet_id"))
	@Column(name = "breed", length = 50)
	public List<String> getBreeds() {
		return this.breeds;
	}

	@OneToOne(mappedBy = "pet_id")
	public ContactType getContact() {
		return this.contact;
	}

	@Column(name = "description", length = 2500)
	public String getDescription() {
		return this.description;
	}

	public GenderType getGender() {
		return this.gender;
	}

	public String getMix() {
		return this.mix;
	}

	@Column(name = "pet_name", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public List<OptionType> getOptions() {
		return this.options;
	}

	@Column(name = "pet_finder_id")
	public BigInteger getPetFinderId() {
		return this.petFinderId;
	}

	public Date getPetFinderLastUpdate() {
		return this.petFinderLastUpdate;
	}

	@Id
	@Column(name = "pet_id")
	@GeneratedValue
	public BigInteger getPetId() {
		return this.petId;
	}

	public List<Photo> getPhotos() {
		return this.photos;
	}

	@Column(name = "shelter_id", nullable = false, length = 20)
	public String getShelterId() {
		return this.shelterId;
	}

	@Column(name = "shelter_pet_id", length = 20)
	public String getShelterPetId() {
		return this.shelterPetId;
	}

	public SizeType getSize() {
		return this.size;
	}

	public StatusType getStatus() {
		return this.status;
	}

	public void setAge(AgeType age) {
		this.age = age;
	}

	public void setAnimal(AnimalType animal) {
		this.animal = animal;
	}

	public void setBreeds(List<String> breeds) {
		this.breeds = breeds;
	}

	public void setContact(ContactType contact) {
		this.contact = contact;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setGender(GenderType gender) {
		this.gender = gender;
	}

	public void setMix(String mix) {
		this.mix = mix;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOptions(List<OptionType> options) {
		this.options = options;
	}

	public void setPetFinderId(BigInteger petFinderId) {
		this.petFinderId = petFinderId;
	}

	public void setPetFinderLastUpdate(Date petFinderLastUpdate) {
		this.petFinderLastUpdate = petFinderLastUpdate;
	}

	public void setPetId(BigInteger id) {
		this.petId = id;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}

	public void setShelterId(String shelterId) {
		this.shelterId = shelterId;
	}

	public void setShelterPetId(String shelterPetId) {
		this.shelterPetId = shelterPetId;
	}

	public void setSize(SizeType size) {
		this.size = size;
	}

	public void setStatus(StatusType status) {
		this.status = status;
	}

}
