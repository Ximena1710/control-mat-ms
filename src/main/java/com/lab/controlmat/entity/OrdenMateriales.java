package com.lab.controlmat.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orden_materiales")
public class OrdenMateriales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_numero_orden")
    private int idNumeroOrden;

    @ManyToOne
    @JoinColumn(name = "fk_id_per_solicitante")
    private Persona personaSolicitante;

    @ManyToOne
    @JoinColumn(name = "fk_id_usurol_encargado")
    private UsuarioRol usuarioEncargado;

    @ManyToOne
    @JoinColumn(name = "fk_id_producto")
    private Producto producto;

    @Column(name = "numero_lote")
    private int numeroLote;

    @Column(name = "fecha_solicitud")
    private Timestamp fechaSolicitud;

    @Column(name = "fecha_creacion")
    private Timestamp fechaCreacion;

    @Column(name = "fecha_actualizacion")
    private Timestamp fechaActualizacion;

	public int getIdNumeroOrden() {
		return idNumeroOrden;
	}

	public void setIdNumeroOrden(int idNumeroOrden) {
		this.idNumeroOrden = idNumeroOrden;
	}

	public Persona getPersonaSolicitante() {
		return personaSolicitante;
	}

	public void setPersonaSolicitante(Persona personaSolicitante) {
		this.personaSolicitante = personaSolicitante;
	}

	public UsuarioRol getUsuarioEncargado() {
		return usuarioEncargado;
	}

	public void setUsuarioEncargado(UsuarioRol usuarioEncargado) {
		this.usuarioEncargado = usuarioEncargado;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getNumeroLote() {
		return numeroLote;
	}

	public void setNumeroLote(int numeroLote) {
		this.numeroLote = numeroLote;
	}

	public Timestamp getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(Timestamp fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Timestamp getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Timestamp fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

}