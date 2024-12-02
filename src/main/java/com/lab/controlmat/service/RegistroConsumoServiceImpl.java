package com.lab.controlmat.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lab.controlmat.dto.MaterialInsumoDTO;
import com.lab.controlmat.dto.PersonasDTO;
import com.lab.controlmat.dto.ProductoDTO;
import com.lab.controlmat.dto.RegistroConsumoDTO;
import com.lab.controlmat.entity.RegistroConsumo;
import com.lab.controlmat.exception.NoExistException;
import com.lab.controlmat.repository.RegistroConsumoRepository;
import com.lab.controlmat.utils.Utils;

import lombok.AllArgsConstructor;

import org.springframework.transaction.annotation.Transactional;



@AllArgsConstructor
@Service
public class RegistroConsumoServiceImpl implements RegistroConsumoService{
	
    private final RegistroConsumoRepository registroConsumoRepository;
    private final ModelMapper modelMapper;
    private final MaterialInsulmoService materialInsulmoService;
    private final ProductoService productoService;
    private final UsuarioService usuarioService;
    ObjectMapper mapper;
    
	@Override
	@Transactional(readOnly = true)
	public List<RegistroConsumoDTO> findAll() {
		List<RegistroConsumo> listRgistroConsumo = (List<RegistroConsumo>) registroConsumoRepository.findAll();
		return listRgistroConsumo.stream()
		        .map(registro -> Utils.convertEntityAndDto(registro, RegistroConsumoDTO.class, modelMapper))
		        .collect(Collectors.toList());
	}

	@Override
	@Transactional
	public String saveAndUpdate(RegistroConsumoDTO registroConsumoDTO) throws JsonProcessingException, NoExistException {
		materialInsulmoService.findById(registroConsumoDTO.getIdMaterialInsumo());
	    productoService.findById(registroConsumoDTO.getIdProducto());
		RegistroConsumo registroConsumo =  Utils.convertEntityAndDto(registroConsumoDTO, RegistroConsumo.class, modelMapper);
		registroConsumoRepository.save(registroConsumo);
		return mapper.writeValueAsString("Se inserto y/o actualizo correctamente");
	}

	@Override
	@Transactional
	public String delete(RegistroConsumoDTO registroConsumoDTO) throws JsonProcessingException {
		RegistroConsumo registroConsumo = Utils.convertEntityAndDto(registroConsumoDTO, RegistroConsumo.class, modelMapper);
		registroConsumoRepository.delete(registroConsumo);
		return mapper.writeValueAsString("Se elimino correctamente");
	}
}
