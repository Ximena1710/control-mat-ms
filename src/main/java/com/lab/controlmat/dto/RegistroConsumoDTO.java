package com.lab.controlmat.dto;

import org.antlr.v4.runtime.misc.NotNull;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistroConsumoDTO {

	@JsonProperty("id_registro")
	private int idRegistro;
	@NotNull
	@JsonProperty("id_material_insumo")
	private int idMaterialInsumo;
	@NotNull
	@JsonProperty("id_producto")
	private int idProducto;
	@NotNull
	@JsonProperty("id_usuario")
	private int idUsuario;
    @Min(value = 1, message = "La cantidad usada debe ser mayor o igual a 1")
    @Positive(message = "La cantidad usada debe ser un número mayor a 0")
	@JsonProperty("cantidad_usada")
	private int cantidadUsada;
    @Min(value = 1, message = "La cantidad usada debe ser mayor o igual a 1")
    @Positive(message = "La cantidad usada debe ser un número mayor a 0")
	private int adiciones;
    @Min(value = 1, message = "La cantidad usada debe ser mayor o igual a 1")
    @Positive(message = "La cantidad usada debe ser un número mayor a 0")
	private int devoluciones;
	@JsonProperty("materiales_rechazados_desperdicio")
	private int materialesRechazadosDesperdicio;

}