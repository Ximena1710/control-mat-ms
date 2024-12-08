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
import com.lab.controlmat.dto.ProductoDTO;
import com.lab.controlmat.service.MaterialInsulmoService;
import com.lab.controlmat.service.ProductoService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/v1/producto")
public class ProductoController {
	@Autowired
	ProductoService productoService;

	@GetMapping("/find")
	public List<ProductoDTO> consultarMaterial() {
		return productoService.findAll();
	}

	@PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> saveMaterial(@RequestBody ProductoDTO productoDTO)
			throws JsonProcessingException {
		return new ResponseEntity<>(productoService.saveAndUpdate(productoDTO), HttpStatus.OK);
	}

	@PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateMaterial(@RequestBody ProductoDTO productoDTO)
			throws JsonProcessingException {
		productoService.saveAndUpdate(productoDTO);
		return new ResponseEntity<>("Se actualizo correctamente", HttpStatus.OK);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteMaterial(@RequestBody ProductoDTO productoDTO)
			throws JsonProcessingException {
		return new ResponseEntity<>(productoService.delete(productoDTO), HttpStatus.OK);
	}
}
