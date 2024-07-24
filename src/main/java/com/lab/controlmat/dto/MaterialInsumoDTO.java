package com.lab.controlmat.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MaterialInsumoDTO {

	@JsonProperty("id_material")
    private int idMaterial;
    
    @JsonProperty("codigo_material")
    private int codigoMaterial;

    @JsonProperty("nombre_material")
    private String nombreMaterial;

    @JsonProperty("unidad_medida")
    private String unidadMedida;

    @JsonProperty("cantidad")
    private int cantidad;

	public int getIdMaterial() {
		return idMaterial;
	}

	public void setIdMaterial(int idMaterial) {
		this.idMaterial = idMaterial;
	}

	public int getCodigoMaterial() {
		return codigoMaterial;
	}

	public void setCodigoMaterial(int codigoMaterial) {
		this.codigoMaterial = codigoMaterial;
	}

	public String getNombreMaterial() {
		return nombreMaterial;
	}

	public void setNombreMaterial(String nombreMaterial) {
		this.nombreMaterial = nombreMaterial;
	}

	public String getUnidadMedida() {
		return unidadMedida;
	}

	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

}