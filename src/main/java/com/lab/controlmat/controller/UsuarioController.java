package com.lab.controlmat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab.controlmat.dto.Credenciales;
import com.lab.controlmat.service.UsuarioService;

@RequestMapping("/v1")
@RestController	
public class UsuarioController {
	@Autowired
	UsuarioService usuarioService; 

	@PostMapping
	public int consultarPersona(@RequestBody Credenciales credenciales) {
		 return usuarioService.findExistUsuario(credenciales);

	}
}
