package com.pruebajava.ejb;

import java.util.List;

import javax.ejb.Local;

import com.pruebajava.dominio.Cliente;
import com.pruebajava.dominio.Movimiento;


@Local
public interface ProductoRepositoryLocal {

	public List<Cliente> buscarTodos();
	public void insertar(Cliente cliente);
	public void borrar(Cliente cliente);
	public Cliente buscarCliente(Cliente cliente);
	public List<Movimiento> buscarMovimientos(Cliente cliente);
}
