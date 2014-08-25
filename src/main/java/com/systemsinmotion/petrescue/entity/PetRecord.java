package com.systemsinmotion.petrescue.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.systemsinmotion.petrescue.entity.type.AgeType;
import com.systemsinmotion.petrescue.entity.type.GenderType;
import com.systemsinmotion.petrescue.entity.type.SizeType;
import com.systemsinmotion.petrescue.entity.type.StatusType;

@Entity
@Table(name = "pet")
public class PetRecord extends AbstractPersistable<Integer> {

	private static final long serialVersionUID = -3413224203938895552L;

	@Column(name = "name", nullable = false, length = 30)
	private String name;

	@Column(name = "age_years")
	private int age;

	@Column(name = "age_category", length = 20)
	@Enumerated(EnumType.STRING)
	private AgeType ageType;

	@Column(name = "gender")
	@Enumerated(EnumType.STRING)
	private GenderType gender;

	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private StatusType status;

	@Column(name = "description", length = 255)
	private String description;

	@Column(name = "size")
	@Enumerated(EnumType.STRING)
	private SizeType size;

	@Column(name = "declawed")
	private Boolean declawed;

	@Column(name = "vaccinated")
	private Boolean vaccinated;

	@Column(name = "fixed")
	private Boolean fixed;

	@Column(name = "no_kids")
	private Boolean noKids;

	@Column(name = "no_dogs")
	private Boolean noDogs;

	@Column(name = "no_cats")
	private Boolean noCats;

	@Column(name = "special_needs")
	private Boolean specialNeeds;

	@Column(name = "housebroken")
	private Boolean housebroken;

	@Column(name = "animalType", nullable = false, length = 30)
	private AnimalType animalType;

	@ManyToOne
	@JoinColumn(name = "location_id", nullable = false)
	private Location location;

	@ManyToMany
	@JoinTable(name = "pet_breed", joinColumns = { @JoinColumn(name = "id") }, inverseJoinColumns = { @JoinColumn(name = "pet_id") })
	private Set<Breed> breeds;

	@OneToMany
	@JoinColumn(name = "pet_id")
	private Set<Photo> photos;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public AgeType getAgeType() {
		return ageType;
	}

	public void setAgeType(AgeType ageType) {
		this.ageType = ageType;
	}

	public GenderType getGender() {
		return gender;
	}

	public void setGender(GenderType gender) {
		this.gender = gender;
	}

	public StatusType getStatus() {
		return status;
	}

	public void setStatus(StatusType status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public SizeType getSize() {
		return size;
	}

	public void setSize(SizeType size) {
		this.size = size;
	}

	public Boolean getDeclawed() {
		return declawed;
	}

	public void setDeclawed(Boolean declawed) {
		this.declawed = declawed;
	}

	public Boolean getVaccinated() {
		return vaccinated;
	}

	public void setVaccinated(Boolean vaccinated) {
		this.vaccinated = vaccinated;
	}

	public Boolean getFixed() {
		return fixed;
	}

	public void setFixed(Boolean fixed) {
		this.fixed = fixed;
	}

	public Boolean getNoKids() {
		return noKids;
	}

	public void setNoKids(Boolean noKids) {
		this.noKids = noKids;
	}

	public Boolean getNoDogs() {
		return noDogs;
	}

	public void setNoDogs(Boolean noDogs) {
		this.noDogs = noDogs;
	}

	public Boolean getNoCats() {
		return noCats;
	}

	public void setNoCats(Boolean noCats) {
		this.noCats = noCats;
	}

	public Boolean getSpecialNeeds() {
		return specialNeeds;
	}

	public void setSpecialNeeds(Boolean specialNeeds) {
		this.specialNeeds = specialNeeds;
	}

	public Boolean getHousebroken() {
		return housebroken;
	}

	public void setHousebroken(Boolean housebroken) {
		this.housebroken = housebroken;
	}

	public AnimalType getAnimal() {
		return animalType;
	}

	public void setAnimal(AnimalType animalType) {
		this.animalType = animalType;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Set<Breed> getBreeds() {
		return breeds;
	}

	public void setBreeds(Set<Breed> breeds) {
		this.breeds = breeds;
	}

	public Set<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(Set<Photo> photos) {
		this.photos = photos;
	}
}
