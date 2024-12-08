package com.lab.controlmat.service;

import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lab.controlmat.dto.Credenciales;
import com.lab.controlmat.dto.MaterialInsumoDTO;
import com.lab.controlmat.dto.RegistroConsumoDTO;
import com.lab.controlmat.entity.MaterialInsumo;
import com.lab.controlmat.entity.Persona;
import com.lab.controlmat.entity.RegistroConsumo;
import com.lab.controlmat.exception.NoExistException;

public interface RegistroConsumoService {

	 List<RegistroConsumo> findAll();
	
	 String saveAndUpdate(RegistroConsumoDTO registroConsumoDTO)  throws JsonProcessingException, NoExistException;
	
	 String delete(RegistroConsumoDTO registroConsumoDTO)  throws JsonProcessingException, NoExistException;

}
