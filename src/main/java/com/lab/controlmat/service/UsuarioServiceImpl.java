package com.lab.controlmat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab.controlmat.dto.Credenciales;
import com.lab.controlmat.entity.Persona;
import com.lab.controlmat.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	 
	 
	@Override
	public int findExistUsuario(Credenciales credenciales) {
		int existUsuario = usuarioRepository.validateUser(credenciales.getUsuario(), credenciales.getClave());
		return existUsuario;
	}

}
