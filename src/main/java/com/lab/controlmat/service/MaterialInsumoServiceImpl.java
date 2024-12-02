package com.lab.controlmat.service;

import java.util.List;import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lab.controlmat.dto.MaterialInsumoDTO;
import com.lab.controlmat.entity.MaterialInsumo;
import com.lab.controlmat.exception.NoExistException;
import com.lab.controlmat.repository.MaterialInsumoRepository;
import com.lab.controlmat.utils.Utils;

import org.springframework.transaction.annotation.Transactional;



@Service
public class MaterialInsumoServiceImpl implements MaterialInsulmoService{
	
    private final MaterialInsumoRepository materialInsumoRepository;
    private final ModelMapper modelMapper;
    ObjectMapper mapper;
    
    @Autowired
	public MaterialInsumoServiceImpl(MaterialInsumoRepository materialInsumoRepository, ModelMapper modelMapper,
			ObjectMapper mapper) {
		super();
		this.materialInsumoRepository = materialInsumoRepository;
		this.modelMapper = modelMapper;
		this.mapper = mapper;
	}
    
	@Override
	@Transactional(readOnly = true)
	public List<MaterialInsumoDTO> findAll() {
		List<MaterialInsumo> listMaterialInsumo = (List<MaterialInsumo>) materialInsumoRepository.findAll();
		return listMaterialInsumo.stream()
		        .map(material -> Utils.convertEntityAndDto(material, MaterialInsumoDTO.class, modelMapper))
		        .collect(Collectors.toList());
	}

	@Override
	@Transactional
	public String saveAndUpdate(MaterialInsumoDTO materialInsumoDTO) throws JsonProcessingException {
		MaterialInsumo materialInsumo =  Utils.convertEntityAndDto(materialInsumoDTO, MaterialInsumo.class, modelMapper);
		materialInsumoRepository.save(materialInsumo);
		return mapper.writeValueAsString("Se inserto y/o actualizo correctamente");
	}

	@Override
	@Transactional
	public String delete(MaterialInsumoDTO materialInsumoDTO) throws JsonProcessingException {
		MaterialInsumo materialInsumo = Utils.convertEntityAndDto(materialInsumoDTO, MaterialInsumo.class, modelMapper);
		materialInsumoRepository.delete(materialInsumo);
		return mapper.writeValueAsString("Se elimino correctamente");
	}

	@Override
	public void findById(int idMaterialInsumo) throws NoExistException {
		MaterialInsumo materialInsumo = materialInsumoRepository.findById(idMaterialInsumo).orElseThrow(
					() -> new NoExistException("El id_material_insumo no fue encontrado, por favor cree primero un material")
				);
	}
}
