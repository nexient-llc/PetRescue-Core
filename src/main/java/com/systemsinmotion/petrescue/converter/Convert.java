package com.systemsinmotion.petrescue.converter;

import com.systemsinmotion.petrescue.entity.*;

import org.modelmapper.ModelMapper;
import org.petfinder.entity.PetfinderPetRecord;

public class Convert {

	public static final PetRecord from(PetfinderPetRecord source) {
		ModelMapper modelMapper = new ModelMapper();
		PetRecord destination = modelMapper.map(source, PetRecord.class);
		return destination;
	}
}
