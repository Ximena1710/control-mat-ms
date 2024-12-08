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
import com.lab.controlmat.service.MaterialInsulmoService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/v1/material")
@RestController
public class MaterialInsumoController {
	@Autowired
	MaterialInsulmoService materialInsulmoService;

	@GetMapping("/find")
	public List<MaterialInsumoDTO> consultarMaterial() {
		return materialInsulmoService.findAll();
	}

	@PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> saveMaterial(@RequestBody MaterialInsumoDTO materialInsumo)
			throws JsonProcessingException {
		return new ResponseEntity<>(materialInsulmoService.saveAndUpdate(materialInsumo), HttpStatus.OK);
	}

	@PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateMaterial(@RequestBody MaterialInsumoDTO materialInsumo)
			throws JsonProcessingException {
		materialInsulmoService.saveAndUpdate(materialInsumo);
		return new ResponseEntity<>("Se actualizo correctamente", HttpStatus.OK);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteMaterial(@RequestBody MaterialInsumoDTO materialInsumoDTO)
			throws JsonProcessingException {
		return new ResponseEntity<>(materialInsulmoService.delete(materialInsumoDTO), HttpStatus.OK);
	}
}
