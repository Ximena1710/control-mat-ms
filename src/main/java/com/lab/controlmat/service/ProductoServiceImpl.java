package com.lab.controlmat.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lab.controlmat.dto.MaterialInsumoDTO;
import com.lab.controlmat.dto.ProductoDTO;
import com.lab.controlmat.entity.MaterialInsumo;
import com.lab.controlmat.entity.Producto;
import com.lab.controlmat.exception.NoExistException;
import com.lab.controlmat.repository.ProductoRepository;
import com.lab.controlmat.utils.Utils;

import org.springframework.transaction.annotation.Transactional;


@Service
public class ProductoServiceImpl implements ProductoService{
	
    private final ProductoRepository productoRepository;
    private final ModelMapper modelMapper;
    ObjectMapper mapper;
    
    @Autowired
	public ProductoServiceImpl(ProductoRepository productoRepository, ModelMapper modelMapper,
			ObjectMapper mapper) {
		super();
		this.productoRepository = productoRepository;
		this.modelMapper = modelMapper;
		this.mapper = mapper;
	}
    
	@Override
	@Transactional(readOnly = true)
	public List<ProductoDTO> findAll() {
		List<Producto> listProduct = (List<Producto>) productoRepository.findAll();
		return listProduct.stream()
		        .map(producto -> Utils.convertEntityAndDto(producto, ProductoDTO.class, modelMapper))
		        .collect(Collectors.toList());
	}

	@Override
	@Transactional
	public String saveAndUpdate(ProductoDTO productoDTO) throws JsonProcessingException {
		Producto producto =  Utils.convertEntityAndDto(productoDTO, Producto.class, modelMapper);
		productoRepository.save(producto);
		return mapper.writeValueAsString("Se inserto y/o actualizo correctamente");
	}

	@Override
	@Transactional
	public String delete(ProductoDTO productoDTO) throws JsonProcessingException {
		Producto producto = Utils.convertEntityAndDto(productoDTO, Producto.class, modelMapper);
		productoRepository.delete(producto);
		return mapper.writeValueAsString("Se elimino correctamente");
	}
	
	@Override
	public Producto findById(int idProducto) throws NoExistException {
	    System.out.println("Buscando producto con id: " + idProducto); // Log para verificar el valor de idProducto
		 return productoRepository.findById(idProducto).orElseThrow(
					() -> new NoExistException("El id_material_insumo no fue encontrado, por favor cree primero un material")
				);
	}
}
