package com.pruebajava.dominio;

import java.io.Serializable;
import javax.persistence.*;

import java.math.BigDecimal;


/**
 * The persistent class for the Movimientos database table.
 * 
 */
@Entity
@Table(name="Movimientos")
@NamedQuery(name="Movimiento.findAll", query="SELECT m FROM Movimiento m")
public class Movimiento implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id")
	private String id;

	@Column(name="id_cliente")
	private String idCliente;

	private BigDecimal valor;

	//bi-directional many-to-one association to Tipo_Movimiento
	@ManyToOne
	@JoinColumn(name="Tipo_Movimiento")
	private Tipo_Movimiento tipoMovimiento;
	
	@Column(name="description")
	private String descripcion;
	

	public Movimiento() {
	}

	public String getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Tipo_Movimiento getTipoMovimiento() {
		return this.tipoMovimiento;
	}

	public void setTipoMovimiento(Tipo_Movimiento tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	
	

}