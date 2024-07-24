package com.lab.controlmat.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "detalle_orden")
public class DetalleOrden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_orden")
    private int idDetalleOrden;

    @ManyToOne
    @JoinColumn(name = "fk_id_orden")
    private OrdenMateriales ordenMateriales;

    @ManyToOne
    @JoinColumn(name = "fk_id_material_insumo")
    private MaterialInsumo materialInsumo;

    @Column(name = "cantidad_requerida")
    private int cantidadRequerida;

    @Column(name = "vig_list_material_ini")
    private Date vigenciaListaMaterialInicio;

    @Column(name = "vig_list_material_fin")
    private Date vigenciaListaMaterialFin;

    @Column(name = "lote_n_analisis")
    private String loteNumeroAnalisis;

	public int getIdDetalleOrden() {
		return idDetalleOrden;
	}

	public void setIdDetalleOrden(int idDetalleOrden) {
		this.idDetalleOrden = idDetalleOrden;
	}

	public OrdenMateriales getOrdenMateriales() {
		return ordenMateriales;
	}

	public void setOrdenMateriales(OrdenMateriales ordenMateriales) {
		this.ordenMateriales = ordenMateriales;
	}

	public MaterialInsumo getMaterialInsumo() {
		return materialInsumo;
	}

	public void setMaterialInsumo(MaterialInsumo materialInsumo) {
		this.materialInsumo = materialInsumo;
	}

	public int getCantidadRequerida() {
		return cantidadRequerida;
	}

	public void setCantidadRequerida(int cantidadRequerida) {
		this.cantidadRequerida = cantidadRequerida;
	}

	public Date getVigenciaListaMaterialInicio() {
		return vigenciaListaMaterialInicio;
	}

	public void setVigenciaListaMaterialInicio(Date vigenciaListaMaterialInicio) {
		this.vigenciaListaMaterialInicio = vigenciaListaMaterialInicio;
	}

	public Date getVigenciaListaMaterialFin() {
		return vigenciaListaMaterialFin;
	}

	public void setVigenciaListaMaterialFin(Date vigenciaListaMaterialFin) {
		this.vigenciaListaMaterialFin = vigenciaListaMaterialFin;
	}

	public String getLoteNumeroAnalisis() {
		return loteNumeroAnalisis;
	}

	public void setLoteNumeroAnalisis(String loteNumeroAnalisis) {
		this.loteNumeroAnalisis = loteNumeroAnalisis;
	}

}