package com.lab.controlmat.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab.controlmat.dto.Credenciales;
import com.lab.controlmat.dto.PersonasDTO;
import com.lab.controlmat.entity.Persona;
import com.lab.controlmat.entity.Producto;
import com.lab.controlmat.exception.NoExistException;
import com.lab.controlmat.repository.UsuarioRepository;
import com.lab.controlmat.utils.Utils;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	 
	@Autowired
	ModelMapper modelMapper;
	 
	@Override
	public int findExistUsuario(Credenciales credenciales) {
		int existUsuario = usuarioRepository.validateUser(credenciales.getUsuario(), credenciales.getClave());
		return existUsuario;
	}


	@Override
	public PersonasDTO addPersona(PersonasDTO personaDTO) {
		Persona persona = Utils.convertEntityAndDto(personaDTO, Persona.class, modelMapper);
		usuarioRepository.save(persona);
		return personaDTO;
	}


	@Override
	public void findById(int idPersona) throws NoExistException {
		usuarioRepository.findById(idPersona).orElseThrow(
				() -> new NoExistException("El id_usuario no fue encontrado, por favor cree primero un usuario")
			);
	}
}
