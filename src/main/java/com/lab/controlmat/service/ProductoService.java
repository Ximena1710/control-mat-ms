package com.lab.controlmat.service;

import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lab.controlmat.dto.Credenciales;
import com.lab.controlmat.dto.MaterialInsumoDTO;
import com.lab.controlmat.dto.ProductoDTO;
import com.lab.controlmat.entity.MaterialInsumo;
import com.lab.controlmat.entity.Persona;
import com.lab.controlmat.exception.NoExistException;

public interface ProductoService {

	 List<ProductoDTO> findAll();
	
	 String saveAndUpdate(ProductoDTO productoDTO)  throws JsonProcessingException;
	
	 String delete(ProductoDTO productoDTO)  throws JsonProcessingException;

	 public void findById(int idProducto) throws NoExistException;
}
