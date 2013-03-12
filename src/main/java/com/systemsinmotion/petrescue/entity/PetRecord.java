package com.systemsinmotion.petrescue.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "pet_record")
public class PetRecord extends AbstractPersistable<Long> {

	private static final long serialVersionUID = -3413224203938895552L;

	// private Long petFinderId;

	// private String shelterId;

	// private String shelterPetId;

	// @Column(name = "pet_name", length = 50)
	// private String name;

	// private AnimalType animal;

	// private List<String> breeds;

	// private String mix;

	// private AgeType age;

	// private GenderType gender;

	// private SizeType size;

	// private Set<OptionType> options;

	// @Column(name = "description", length = 2500)
	// private String description;

	// private Date petFinderLastUpdate;

	// private StatusType status;

	// @OneToMany(mappedBy = "pet")
	// private Set<Photo> photos;

	// private ContactType contact;

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

	// public String getDescription() {
	// return this.description;
	// }

	// @Column(name = "gender", length = 1)
	// public GenderType getGender() {
	// return this.gender;
	// }

	// @Column(name = "mix", length = 3)
	// public String getMix() {
	// return this.mix;
	// }

	// @CollectionTable(name = "pet_options", joinColumns = @JoinColumn(name = "pet_id"))
	// @Column(name = "option", length = 20)
	// @Enumerated(EnumType.STRING)
	// public Set<OptionType> getOptions() {
	// return this.options;
	// }

	// @Column(name = "pet_finder_id")
	// public Long getPetFinderId() {
	// return this.petFinderId;
	// }

	// @Column(name = "pet_finder_update_timestamp")
	// public Date getPetFinderLastUpdate() {
	// return this.petFinderLastUpdate;
	// }

	// public String getName() {
	// return this.name;
	// }

	// public Set<Photo> getPhotos() {
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

	// public void setDescription(String description) {
	// this.description = description;
	// }

	// public void setGender(GenderType gender) {
	// this.gender = gender;
	// }

	// public void setMix(String mix) {
	// this.mix = mix;
	// }

	// public void setOptions(Set<OptionType> options) {
	// this.options = options;
	// }

	// public void setPetFinderId(Long petFinderId) {
	// this.petFinderId = petFinderId;
	// }

	// public void setPetFinderLastUpdate(Date petFinderLastUpdate) {
	// this.petFinderLastUpdate = petFinderLastUpdate;
	// }

	// public void setName(String name) {
	// this.name = name;
	// }

	// public void setPhotos(Set<Photo> photos) {
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
