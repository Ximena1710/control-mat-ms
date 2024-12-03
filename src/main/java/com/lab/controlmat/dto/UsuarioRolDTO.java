package com.lab.controlmat.dto;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lab.controlmat.entity.Persona;
import com.lab.controlmat.entity.Rol;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class UsuarioRolDTO {

    private Rol rol;

    private Persona persona;

	private String clave;

	@JsonProperty("fecha_creacion")
	private LocalDateTime fechaCreacion;

	@JsonProperty("fecha_modificacion")
	private LocalDateTime fechaModificacion;

	private char estado;
   
}