package com.lab.controlmat.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "persona")
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_persona")
	private int idPersona;

	@Column(name = "cod_empleado")
	private int codEmpleado;

	@Column(name = "nombres")
	private String nombres;

	@Column(name = "apellidos")
	private String apellidos;

	@Column(name = "documento")
	private String documento;

	@Column(name = "numero_documento")
	private String numeroDocumento;

	@Column(name = "telefono")
	private int telefono;

	@Column(name = "email")
	private String email;

	@Column(name = "fecha_creacion")
	private Timestamp fechaCreacion;

	@Column(name = "fecha_vinculacion")
	private Timestamp fechaVinculacion;

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public int getCodEmpleado() {
		return codEmpleado;
	}

	public void setCodEmpleado(int codEmpleado) {
		this.codEmpleado = codEmpleado;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Timestamp getFechaVinculacion() {
		return fechaVinculacion;
	}

	public void setFechaVinculacion(Timestamp fechaVinculacion) {
		this.fechaVinculacion = fechaVinculacion;
	}

}
