package com.pruebajava.dominio;


import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.math.BigDecimal;


/**
 * The persistent class for the Clientes database table.
 * 
 */
@Entity
@Table(name="Clientes")
@XmlRootElement (name="cliente")
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_cliente")
	private String idCliente;

	@Column(name="estado_cuenta")
	private String estadoCuenta;

	@Column(name="nombre_cliente")
	private String nombreCliente;
	
	@Column(name="apellido_cliente")
	private String apellidoCliente;
	
	@Column(name="edad_cliente")
	private String edadCliente;
	
	@Column(name="fecha_creacion_cuenta")
	private String fechaCreacionCuenta;
	
	@Column(name="numero_cuenta")
	private Integer numeroCuenta;

	@Column(name="saldo_cuenta")
	private BigDecimal saldoCuenta;

	@Column(name="tipo_cuenta")
	private String tipoCuenta;

	public Cliente() {
		super();
	}
	public Cliente(String idCliente, String nombreCliente, Integer numeroCuenta, String tipoCuenta,
			BigDecimal saldoCuenta, String estadoCuenta) {
		super();
		this.idCliente = idCliente;
		this.nombreCliente = nombreCliente;
		this.numeroCuenta = numeroCuenta;
		this.tipoCuenta = tipoCuenta;
		this.saldoCuenta = saldoCuenta;
		this.estadoCuenta = estadoCuenta;
	}

	public String getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getEstadoCuenta() {
		return this.estadoCuenta;
	}

	public void setEstadoCuenta(String estadoCuenta) {
		this.estadoCuenta = estadoCuenta;
	}

	public String getNombreCliente() {
		return this.nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public Integer getNumeroCuenta() {
		return this.numeroCuenta;
	}

	public void setNumeroCuenta(Integer numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public BigDecimal getSaldoCuenta() {
		return this.saldoCuenta;
	}

	public void setSaldoCuenta(BigDecimal saldoCuenta) {
		this.saldoCuenta = saldoCuenta;
	}

	public String getTipoCuenta() {
		return this.tipoCuenta;
	}

	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}
	public String getApellidoCliente() {
		return apellidoCliente;
	}
	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}
	public String getEdadCliente() {
		return edadCliente;
	}
	public void setEdadCliente(String edadCliente) {
		this.edadCliente = edadCliente;
	}
	public String getFechaCreacionCuenta() {
		return fechaCreacionCuenta;
	}
	public void setFechaCreacionCuenta(String fechaCreacionCuenta) {
		this.fechaCreacionCuenta = fechaCreacionCuenta;
	}
	
	

}
