package com.lab.controlmat.repository;

import org.springframework.data.repository.CrudRepository;

import com.lab.controlmat.dto.UsuarioRolDTO;
import com.lab.controlmat.entity.MaterialInsumo;
import com.lab.controlmat.entity.Persona;
import com.lab.controlmat.entity.UsuarioRol;

public interface UsuarioRolRepository extends CrudRepository<UsuarioRol, Integer>{

}
