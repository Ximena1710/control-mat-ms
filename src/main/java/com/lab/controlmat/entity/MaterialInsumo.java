package com.lab.controlmat.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "materiales_insumo")
public class MaterialInsumo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,  generator = "material_generator")
    @SequenceGenerator(name = "material_generator", sequenceName = "materiales_insumo_seq", allocationSize = 1)
    @Column(name = "id_material")
    private int idMaterial;

    @Column(name = "codigo_material")
    private int codigoMaterial;

    @Column(name = "nombre_material")
    private String nombreMaterial;

    @Column(name = "unidad_medida")
    private String unidadMedida;

    @Column(name = "cantidad")
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