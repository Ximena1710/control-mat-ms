package com.lab.controlmat.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

}