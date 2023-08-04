package com.pruebajava.dominio;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Response {

	private boolean status;
	private String message;
	private Cliente cliente;
	private List<MovimientoDTO> movimiento;

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<MovimientoDTO> getMovimiento() {
		return movimiento;
	}

	public void setMovimiento(List<MovimientoDTO> movimiento) {
		this.movimiento = movimiento;
	}
	
	
	
	

}
