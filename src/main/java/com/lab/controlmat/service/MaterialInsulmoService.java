package com.lab.controlmat.service;

import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lab.controlmat.dto.Credenciales;
import com.lab.controlmat.dto.MaterialInsumoDTO;
import com.lab.controlmat.entity.MaterialInsumo;
import com.lab.controlmat.entity.Persona;
import com.lab.controlmat.exception.NoExistException;

public interface MaterialInsulmoService {

	 List<MaterialInsumoDTO> findAll();
	
	 String saveAndUpdate(MaterialInsumoDTO materialInsumoDTO)  throws JsonProcessingException;
	
	 String delete(MaterialInsumoDTO materialInsumoDTO)  throws JsonProcessingException;

	 MaterialInsumo findById(int idMaterialInsumo) throws NoExistException;
}
