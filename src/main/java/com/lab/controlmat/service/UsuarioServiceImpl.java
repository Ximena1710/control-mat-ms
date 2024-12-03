package com.lab.controlmat.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lab.controlmat.dto.Credenciales;
import com.lab.controlmat.dto.PersonasDTO;
import com.lab.controlmat.dto.RolDTO;
import com.lab.controlmat.dto.UsuarioRolDTO;
import com.lab.controlmat.entity.Persona;
import com.lab.controlmat.entity.Producto;
import com.lab.controlmat.exception.NoExistException;
import com.lab.controlmat.repository.UsuarioRepository;
import com.lab.controlmat.utils.Utils;

import jakarta.transaction.Transactional;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	 
	@Autowired
	private UsuarioRolService usuarioRolService;
	
	@Autowired
	private RolService rolService;
	
	@Autowired
	ModelMapper modelMapper;
	 
	@Override
	public int findExistUsuario(Credenciales credenciales) {
		int existUsuario = usuarioRepository.validateUser(credenciales.getUsuario(), credenciales.getClave());
		return existUsuario;
	}


	@Override
	@Transactional
	public PersonasDTO addPersona(PersonasDTO personaDTO) throws JsonProcessingException {
		Persona persona = Utils.convertEntityAndDto(personaDTO, Persona.class, modelMapper);
		usuarioRepository.save(persona);
		
	    UsuarioRolDTO usuarioRolDTO = getUsuarioRol(personaDTO.getClave(), persona);
	    usuarioRolService.saveAndUpdate(usuarioRolDTO);

		return personaDTO;
	}


	private UsuarioRolDTO getUsuarioRol(String clave, Persona persona) {
		return UsuarioRolDTO
				.builder()
				.rol(rolService.findById())
				.persona(persona)
				.clave(clave)
				.fechaCreacion(persona.getFechaCreacion())
				.fechaModificacion(persona.getFechaCreacion())
				.estado('A')
				.build();
	}


	@Override
	public void findById(int idPersona) throws NoExistException {
		usuarioRepository.findById(idPersona).orElseThrow(
				() -> new NoExistException("El id_usuario no fue encontrado, por favor cree primero un usuario")
			);
	}
}
