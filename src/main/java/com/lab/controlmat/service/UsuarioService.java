package com.lab.controlmat.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lab.controlmat.dto.Credenciales;
import com.lab.controlmat.dto.PersonasDTO;
import com.lab.controlmat.dto.ProductoDTO;
import com.lab.controlmat.entity.Persona;
import com.lab.controlmat.exception.NoExistException;

public interface UsuarioService {

	public int findExistUsuario(Credenciales credenciales);
	
	public PersonasDTO addPersona(PersonasDTO personaDTO) throws JsonProcessingException;

	public void findById(int idPersona) throws NoExistException;;

}
