package com.pruebajava.ejb;

import java.util.List;

import javax.ejb.Local;

import com.pruebajava.dominio.Cliente;



@Local
public interface ProductoRepositoryJDBCLocal {

	public List<Cliente> buscarTodos();
}
