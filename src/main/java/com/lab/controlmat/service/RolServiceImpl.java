package com.lab.controlmat.service;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lab.controlmat.dto.RolDTO;
import com.lab.controlmat.entity.MaterialInsumo;
import com.lab.controlmat.entity.Producto;
import com.lab.controlmat.entity.Rol;
import com.lab.controlmat.entity.UsuarioRol;
import com.lab.controlmat.exception.NoExistException;
import com.lab.controlmat.repository.ProductoRepository;
import com.lab.controlmat.repository.RolRepository;
import com.lab.controlmat.repository.UsuarioRolRepository;
import com.lab.controlmat.utils.Utils;

import org.springframework.transaction.annotation.Transactional;


@Service
public class RolServiceImpl implements RolService{
	
    private final RolRepository rolRepository;
    private final ModelMapper modelMapper;
    ObjectMapper mapper;
    
    @Autowired
	public RolServiceImpl(RolRepository rolRepository, ModelMapper modelMapper,
			ObjectMapper mapper) {
		super();
		this.rolRepository = rolRepository;
		this.modelMapper = modelMapper;
		this.mapper = mapper;
	}
    
	@Override
	@Transactional(readOnly = true)
	public Rol findById() {
		return rolRepository.findById(1).orElseGet(() -> new Rol());
	}
}
