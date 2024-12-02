package com.lab.controlmat.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "persona")
public class Persona {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,  generator = "persona_generator")
    @SequenceGenerator(name = "persona_generator", sequenceName = "persona_seq", allocationSize = 1)
	@Column(name = "id_persona")
	private int idPersona;

	@Column(name = "cod_empleado")
	private int codEmpleado;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellido")
	private String apellido;

	@Column(name = "tipo_documento")
	private String tipoDocumento;

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

}
