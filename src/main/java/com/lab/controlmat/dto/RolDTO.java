package com.lab.controlmat.dto;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RolDTO {

	@JsonProperty("id_rol")
    private int idRol;

	@JsonProperty("rol_descripcion")
    private String rolDescripcion;

	@JsonProperty("fecha_creacion")
    private Timestamp fechaCreacion;

	@JsonProperty("fecha_modificacion")
    private Timestamp fechaModificacion;

}