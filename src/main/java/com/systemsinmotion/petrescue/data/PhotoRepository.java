package com.systemsinmotion.petrescue.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.systemsinmotion.petrescue.entity.Photo;

@Repository("photoRepository")
public interface PhotoRepository extends JpaRepository<Photo, Integer> {

	List<Photo> findByPetId(int id);

}
