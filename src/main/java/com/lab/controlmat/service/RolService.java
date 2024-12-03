package com.lab.controlmat.service;

import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lab.controlmat.dto.Credenciales;
import com.lab.controlmat.dto.MaterialInsumoDTO;
import com.lab.controlmat.dto.ProductoDTO;
import com.lab.controlmat.dto.RolDTO;
import com.lab.controlmat.dto.UsuarioRolDTO;
import com.lab.controlmat.entity.MaterialInsumo;
import com.lab.controlmat.entity.Persona;
import com.lab.controlmat.entity.Rol;
import com.lab.controlmat.exception.NoExistException;

public interface RolService {

	public Rol findById();	
}
