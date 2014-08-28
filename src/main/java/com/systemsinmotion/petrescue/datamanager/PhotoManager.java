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
		// TODO Auto-generated method stub
		return null;
		
	}

	public List<Photo> findAllPhotos() {
		// TODO Auto-generated method stub
		return null;
		
	}

	public List<Photo> findPhotosByPetId(int id) {
		// TODO Auto-generated method stub
		return null;
		
	}

	public Photo storePhoto(Photo photo) {
		// TODO Auto-generated method stub
		return null;
		
	}

	public void removePhoto(Photo photo) {
		// TODO Auto-generated method stub
		
	}

}
