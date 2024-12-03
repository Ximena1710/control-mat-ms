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
import com.lab.controlmat.dto.UsuarioRolDTO;
import com.lab.controlmat.entity.MaterialInsumo;
import com.lab.controlmat.entity.Producto;
import com.lab.controlmat.entity.UsuarioRol;
import com.lab.controlmat.exception.NoExistException;
import com.lab.controlmat.repository.ProductoRepository;
import com.lab.controlmat.repository.UsuarioRolRepository;
import com.lab.controlmat.utils.Utils;

import org.springframework.transaction.annotation.Transactional;


@Service
public class UsuarioRolServiceImpl implements UsuarioRolService{
	
    private final UsuarioRolRepository usuarioRolRepository;
    private final ModelMapper modelMapper;
    ObjectMapper mapper;
    
    @Autowired
	public UsuarioRolServiceImpl(UsuarioRolRepository usuarioRolRepository, ModelMapper modelMapper,
			ObjectMapper mapper) {
		super();
		this.usuarioRolRepository = usuarioRolRepository;
		this.modelMapper = modelMapper;
		this.mapper = mapper;
	}
    
	@Override
	@Transactional(readOnly = true)
	public List<UsuarioRolDTO> findAll() {
		List<UsuarioRol> listUsuarioRol = (List<UsuarioRol>) usuarioRolRepository.findAll();
		return listUsuarioRol.stream()
		        .map(usuarioRol -> Utils.convertEntityAndDto(usuarioRol, UsuarioRolDTO.class, modelMapper))
		        .collect(Collectors.toList());
	}

	@Override
	public String saveAndUpdate(UsuarioRolDTO usuarioRolDTO) throws JsonProcessingException {
		UsuarioRol usuarioRol =  Utils.convertEntityAndDto(usuarioRolDTO, UsuarioRol.class, modelMapper);
		usuarioRolRepository.save(usuarioRol);
		return mapper.writeValueAsString("Se inserto y/o actualizo correctamente");
	}

	@Override
	public String delete(UsuarioRolDTO usuarioRolDTO) throws JsonProcessingException {
		UsuarioRol usuarioRol = Utils.convertEntityAndDto(usuarioRolDTO, UsuarioRol.class, modelMapper);
		usuarioRolRepository.delete(usuarioRol);
		return mapper.writeValueAsString("Se elimino correctamente");
	}

	@Override
	public void findById(int idUsuarioRolDTO) throws NoExistException {
		usuarioRolRepository.findById(idUsuarioRolDTO).orElseThrow(
					() -> new NoExistException("El id_producto no fue encontrado, por favor cree primero un producto")
				);
	}

}
