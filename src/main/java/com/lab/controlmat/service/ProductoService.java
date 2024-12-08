package com.lab.controlmat.service;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lab.controlmat.dto.ProductoDTO;
import com.lab.controlmat.entity.Producto;
import com.lab.controlmat.exception.NoExistException;

public interface ProductoService {

	 List<ProductoDTO> findAll();
	
	 String saveAndUpdate(ProductoDTO productoDTO)  throws JsonProcessingException;
	
	 String delete(ProductoDTO productoDTO)  throws JsonProcessingException;

	 public Producto findById(int idProducto) throws NoExistException;
}
