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
import com.lab.controlmat.entity.MaterialInsumo;
import com.lab.controlmat.entity.Producto;
import com.lab.controlmat.entity.RegistroConsumo;
import com.lab.controlmat.entity.UsuarioRol;
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
    private final UsuarioRolService usuarioRolService;
    ObjectMapper mapper;
    
	@Override
	@Transactional(readOnly = true)
	public List<RegistroConsumo> findAll() {
		return (List<RegistroConsumo>) registroConsumoRepository.findAll();
	}
	@Override
	@Transactional
	public String saveAndUpdate(RegistroConsumoDTO registroConsumoDTO) throws JsonProcessingException, NoExistException {
	    registroConsumoRepository.save(getRegistroConsumo(registroConsumoDTO));
	    
	    return mapper.writeValueAsString("Se insertó y/o actualizó correctamente");
	}

	@Override
	@Transactional
	public String delete(RegistroConsumoDTO registroConsumoDTO) throws JsonProcessingException, NoExistException {
	    RegistroConsumo registroConsumo = registroConsumoRepository.findById(registroConsumoDTO.getIdRegistro())
	        .orElseThrow(() -> new NoExistException("El registro con el ID proporcionado no existe"));
	    registroConsumoRepository.delete(registroConsumo);
	    return mapper.writeValueAsString("Se eliminó correctamente");
	}

	
	public RegistroConsumo getRegistroConsumo(RegistroConsumoDTO registroConsumoDTO) throws JsonProcessingException, NoExistException {
	    UsuarioRol usuario = usuarioRolService.findById(registroConsumoDTO.getIdUsuario());
		Producto producto = productoService.findById(registroConsumoDTO.getIdProducto());
	    MaterialInsumo materialInsumo = materialInsulmoService.findById(registroConsumoDTO.getIdMaterialInsumo());

	    
	    RegistroConsumo registroConsumo = new RegistroConsumo();
	    registroConsumo.setMaterialInsumo(materialInsumo);
	    registroConsumo.setProducto(producto);
	    registroConsumo.setUsuario(usuario);
	    registroConsumo.setCantidadUsada(registroConsumoDTO.getCantidadUsada());
	    registroConsumo.setAdiciones(registroConsumoDTO.getAdiciones());
	    registroConsumo.setDevoluciones(registroConsumoDTO.getDevoluciones());
	    registroConsumo.setMaterialesRechazadosDesperdicio(registroConsumoDTO.getMaterialesRechazadosDesperdicio());
	    return registroConsumo;
	}
}
