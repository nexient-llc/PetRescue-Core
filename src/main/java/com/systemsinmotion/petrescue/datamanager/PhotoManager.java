package com.systemsinmotion.petrescue.datamanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.systemsinmotion.petrescue.data.PhotoRepository;

@Service("photoService")
public class PhotoManager {
	@Autowired
	PhotoRepository repository;

}
