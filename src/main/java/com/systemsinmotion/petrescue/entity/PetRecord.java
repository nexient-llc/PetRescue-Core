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

	protected Long id;

	// protected BigInteger petFinderId;

	// protected String shelterId;

	// protected String shelterPetId;

	protected String name;

	// protected AnimalType animal;

	// protected List<String> breeds;

	// protected String mix;

	// protected AgeType age;

	protected GenderType gender;

	// protected SizeType size;

	// protected Set<OptionType> options;

	protected String description;

	// protected Date petFinderLastUpdate;

	// protected StatusType status;

	// protected List<Photo> photos;

	// protected ContactType contact;

	// @Column(name = "age_type", length = 10)
	// @Enumerated(EnumType.STRING)
	// public AgeType getAge() {
	// return this.age;
	// }

	// @Column(name = "animal_type", length = 20)
	// public AnimalType getAnimal() {
	// return this.animal;
	// }

	// @ElementCollection
	// @CollectionTable(name = "pet_breeds", joinColumns = @JoinColumn(name = "pet_id"))
	// @Column(name = "breed", length = 50)
	// public List<String> getBreeds() {
	// return this.breeds;
	// }

	// @OneToOne(mappedBy = "pet_id")
	// public ContactType getContact() {
	// return this.contact;
	// }

	@Column(name = "description", length = 2500)
	public String getDescription() {
		return this.description;
	}

	@Column(name = "gender", length = 1)
	public GenderType getGender() {
		return this.gender;
	}

	// @Column(name = "mix", length = 3)
	// public String getMix() {
	// return this.mix;
	// }

	@Column(name = "pet_name", length = 50)
	public String getName() {
		return this.name;
	}

	// @CollectionTable(name = "pet_options", joinColumns = @JoinColumn(name = "pet_id"))
	// @Column(name = "option", length = 20)
	// @Enumerated(EnumType.STRING)
	// public Set<OptionType> getOptions() {
	// return this.options;
	// }

	// @Column(name = "pet_finder_id")
	// public BigInteger getPetFinderId() {
	// return this.petFinderId;
	// }

	// @Column(name = "pet_finder_update_timestamp")
	// public Date getPetFinderLastUpdate() {
	// return this.petFinderLastUpdate;
	// }

	@Id
	@Column(name = "pet_id")
	@GeneratedValue
	public Long getId() {
		return this.id;
	}

	// @OneToMany(mappedBy = "petId")
	// public List<Photo> getPhotos() {
	// return this.photos;
	// }

	// @Column(name = "shelter_id", length = 20)
	// public String getShelterId() {
	// return this.shelterId;
	// }

	// @Column(name = "shelter_pet_id", length = 20)
	// public String getShelterPetId() {
	// return this.shelterPetId;
	// }

	// @Column(name = "size", length = 2)
	// @Enumerated(EnumType.STRING)
	// public SizeType getSize() {
	// return this.size;
	// }

	// @Column(name = "status", length = 1)
	// @Enumerated(EnumType.STRING)
	// public StatusType getStatus() {
	// return this.status;
	// }

	// public void setAge(AgeType age) {
	// this.age = age;
	// }

	// public void setAnimal(AnimalType animal) {
	// this.animal = animal;
	// }

	// public void setBreeds(List<String> breeds) {
	// this.breeds = breeds;
	// }

	// public void setContact(ContactType contact) {
	// this.contact = contact;
	// }

	public void setDescription(String description) {
		this.description = description;
	}

	public void setGender(GenderType gender) {
		this.gender = gender;
	}

	// public void setMix(String mix) {
	// this.mix = mix;
	// }

	public void setName(String name) {
		this.name = name;
	}

	// public void setOptions(Set<OptionType> options) {
	// this.options = options;
	// }

	// public void setPetFinderId(BigInteger petFinderId) {
	// this.petFinderId = petFinderId;
	// }

	// public void setPetFinderLastUpdate(Date petFinderLastUpdate) {
	// this.petFinderLastUpdate = petFinderLastUpdate;
	// }

	public void setId(Long id) {
		this.id = id;
	}

	// public void setPhotos(List<Photo> photos) {
	// this.photos = photos;
	// }

	// public void setShelterId(String shelterId) {
	// this.shelterId = shelterId;
	// }

	// public void setShelterPetId(String shelterPetId) {
	// this.shelterPetId = shelterPetId;
	// }

	// public void setSize(SizeType size) {
	// this.size = size;
	// }

	// public void setStatus(StatusType status) {
	// this.status = status;
	// }

}
