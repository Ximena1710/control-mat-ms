package com.lab.controlmat.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoDTO {

	@JsonProperty("id_producto")
	private int idProducto;

	@JsonProperty("codigo_producto")
	private int codigoProducto;

	@JsonProperty("nombre_producto")
	private String nombreProducto;

	@JsonProperty("cantidad_disponible")
	private int cantidadDisponible;

	@JsonProperty("fecha_creacion")
	private String fechaCreacion;

	@JsonProperty("fecha_vencimiento")
	private String fechaVencimiento;

	@JsonProperty("invima")
	private String invima;

}
