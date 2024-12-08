package com.lab.controlmat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lab.controlmat.dto.MaterialInsumoDTO;
import com.lab.controlmat.dto.UsuarioRolDTO;
import com.lab.controlmat.service.MaterialInsulmoService;
import com.lab.controlmat.service.UsuarioRolService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/v1/usuariorol")
@RestController
public class UsuarioRolController {
	@Autowired
	UsuarioRolService usuarioRolService;

	@GetMapping("/find")
	public List<UsuarioRolDTO> UsuarioRolService() {
		return usuarioRolService.findAll();
	}

	@PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> saveUsuarioRolService(@RequestBody UsuarioRolDTO usuarioRolDTO)
			throws JsonProcessingException {
		return new ResponseEntity<>(usuarioRolService.saveAndUpdate(usuarioRolDTO), HttpStatus.OK);
	}

	@PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateUsuarioRolService(@RequestBody UsuarioRolDTO usuarioRolDTO)
			throws JsonProcessingException {
		usuarioRolService.saveAndUpdate(usuarioRolDTO);
		return new ResponseEntity<>("Se actualizo correctamente", HttpStatus.OK);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteUsuarioRolService(@RequestBody UsuarioRolDTO usuarioRolDTO)
			throws JsonProcessingException {
		return new ResponseEntity<>(usuarioRolService.delete(usuarioRolDTO), HttpStatus.OK);
	}
}
