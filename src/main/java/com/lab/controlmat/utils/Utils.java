package com.lab.controlmat.utils;

import org.modelmapper.ModelMapper;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Utils {

	public static <S, D> D convertEntityAndDto(S object1, Class<D> object2,  ModelMapper modelMapper) {
		return modelMapper.map(object1, object2);
	}

}
