package com.lab.controlmat.dto;


import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonasDTO {
	
	@JsonProperty("id_persona")
	public int idPersona;
	
	@JsonProperty("cod_empleado")
	public int codEmpleado;
	
	@JsonProperty("nombre")
	public String nombre;
	
	@JsonProperty("apellido")
	public String apellido;
	
	@JsonProperty("tipo_documento")
	public String tipoDocumento;
	
	@JsonProperty("numero_documento")
	public String numeroDocumento;
	
	@JsonProperty("telefono")
	public String telefono;
	
	@JsonProperty("email")
	public String email;
	
	@JsonProperty("fecha_creacion")
	public LocalDateTime fechaCreacion;
	
	@JsonProperty("fecha_vinculacion")
	public LocalDateTime fechaVinculacion;
	
	@JsonProperty("clave")
	public String clave;
}
