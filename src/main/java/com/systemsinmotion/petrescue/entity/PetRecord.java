package com.systemsinmotion.petrescue.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.systemsinmotion.petrescue.entity.type.*;

@Entity
@Table(name = "pet")
public class PetRecord extends AbstractPersistable<Integer> {

	private static final long serialVersionUID = -3413224203938895552L;

	@Column(name = "name", nullable = false, length = 30)
	private String name;

	@Column(name = "age_years")
	private int age;

	@Column(name = "age_category", length = 20)
	private AgeType ageType;

	@Column(name = "gender")
	private GenderType gender;

	@Column(name = "status")
	private StatusType status;

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

}
