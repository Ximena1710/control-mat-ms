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
import com.lab.controlmat.dto.RegistroConsumoDTO;
import com.lab.controlmat.entity.RegistroConsumo;
import com.lab.controlmat.exception.NoExistException;
import com.lab.controlmat.dto.RegistroConsumoDTO;
import com.lab.controlmat.service.MaterialInsulmoService;
import com.lab.controlmat.service.RegistroConsumoService;

import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;

@CrossOrigin(origins = "https://controlmat-ms.onrender.com", allowedHeaders = "*")
@RestController
@RequestMapping("/v1/consumo")
@Validated
public class RegistroConsumoController {
	
	@Autowired
	RegistroConsumoService registroConsumoService;

	@GetMapping("/find")
	public ResponseEntity<List<RegistroConsumo>> consultarConsumo() {
	    List<RegistroConsumo> consumos = registroConsumoService.findAll();
	    return ResponseEntity.ok(consumos);
	}
	 
	@PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> saveConsumo (@Valid @RequestBody RegistroConsumoDTO registroConsumoDTO)
			throws JsonProcessingException, NoExistException {
		return new ResponseEntity<>(registroConsumoService.saveAndUpdate(registroConsumoDTO), HttpStatus.OK);
	}

	@PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateConsumo(@RequestBody RegistroConsumoDTO registroConsumoDTO)
			throws JsonProcessingException, NoExistException {
		registroConsumoService.saveAndUpdate(registroConsumoDTO);
		return new ResponseEntity<>("Se actualizo correctamente", HttpStatus.OK);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteConsumo(@RequestBody RegistroConsumoDTO registroConsumoDTO)
			throws JsonProcessingException, NoExistException {
		return new ResponseEntity<>(registroConsumoService.delete(registroConsumoDTO), HttpStatus.OK);
	}
}
