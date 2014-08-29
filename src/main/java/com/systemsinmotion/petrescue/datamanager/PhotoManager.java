package com.systemsinmotion.petrescue.datamanager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.systemsinmotion.petrescue.data.PhotoRepository;
import com.systemsinmotion.petrescue.entity.Photo;

@Service("photoManager")
public class PhotoManager {
	@Autowired
	PhotoRepository photoRepository;

	public Photo findPhotoById(int id) {
		return photoRepository.findOne(id);
	}

	public List<Photo> findAllPhotos() {
		return photoRepository.findAll();
	}

	public List<Photo> findPhotosByPetId(int id) {
		return photoRepository.findByPetId(id);
	}

	public Photo storePhoto(Photo photo) {
		return photoRepository.saveAndFlush(photo);
	}

	public void removePhoto(Photo photo) {
		photoRepository.delete(photo);
	}

}
