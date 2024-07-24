package com.lab.controlmat.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private int idRol;

    @Column(name = "rol_descripcion")
    private String rolDescripcion;

    @Column(name = "fecha_creacion")
    private Timestamp fechaCreacion;

    @Column(name = "fecha_modificacion")
    private Timestamp fechaModificacion;

	public int getIdRol() {
		return idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public String getRolDescripcion() {
		return rolDescripcion;
	}

	public void setRolDescripcion(String rolDescripcion) {
		this.rolDescripcion = rolDescripcion;
	}

	public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Timestamp getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Timestamp fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
}