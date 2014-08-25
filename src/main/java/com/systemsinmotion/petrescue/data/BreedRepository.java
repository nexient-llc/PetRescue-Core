package com.systemsinmotion.petrescue.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.systemsinmotion.petrescue.entity.Breed;

@Repository("breedRepsitory")
public interface BreedRepository extends JpaRepository<Breed, Integer> {

}
