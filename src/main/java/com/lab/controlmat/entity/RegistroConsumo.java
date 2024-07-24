package com.lab.controlmat.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "registro_consumo")
public class RegistroConsumo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_registro")
    private int idRegistro;

    @ManyToOne
    @JoinColumn(name = "fk_id_material_insumo")
    private MaterialInsumo materialInsumo;

    @ManyToOne
    @JoinColumn(name = "fk_id_producto")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "fk_id_usuario")
    private UsuarioRol usuario;

    @Column(name = "cantidad_usada")
    private int cantidadUsada;

    @Column(name = "adiciones")
    private int adiciones;

    @Column(name = "devoluciones")
    private int devoluciones;

    @Column(name = "mat_recha_desperdicio")
    private int materialesRechazadosDesperdicio;

	public int getIdRegistro() {
		return idRegistro;
	}

	public void setIdRegistro(int idRegistro) {
		this.idRegistro = idRegistro;
	}

	public MaterialInsumo getMaterialInsumo() {
		return materialInsumo;
	}

	public void setMaterialInsumo(MaterialInsumo materialInsumo) {
		this.materialInsumo = materialInsumo;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public UsuarioRol getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioRol usuario) {
		this.usuario = usuario;
	}

	public int getCantidadUsada() {
		return cantidadUsada;
	}

	public void setCantidadUsada(int cantidadUsada) {
		this.cantidadUsada = cantidadUsada;
	}

	public int getAdiciones() {
		return adiciones;
	}

	public void setAdiciones(int adiciones) {
		this.adiciones = adiciones;
	}

	public int getDevoluciones() {
		return devoluciones;
	}

	public void setDevoluciones(int devoluciones) {
		this.devoluciones = devoluciones;
	}

	public int getMaterialesRechazadosDesperdicio() {
		return materialesRechazadosDesperdicio;
	}

	public void setMaterialesRechazadosDesperdicio(int materialesRechazadosDesperdicio) {
		this.materialesRechazadosDesperdicio = materialesRechazadosDesperdicio;
	}

}