package com.pruebajava.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.pruebajava.dominio.Cliente;
import com.pruebajava.dominio.Movimiento;

/**
 * Session Bean implementation class ProductoRepositoryBean
 */
@Stateless
public class ProductoRepositoryBean implements ProductoRepositoryLocal {

	@PersistenceContext(unitName = "jpa1")
	EntityManager entityManager;

	@Override
	public List<Cliente> buscarTodos() {

		TypedQuery<Cliente> consulta = entityManager.createQuery("select p from Cliente p", Cliente.class);
		return consulta.getResultList();
	}

	@Override
	public void insertar(Cliente cliente) {
		entityManager.persist(cliente);

	}

	@Override
	public void borrar(Cliente cliente) {

		entityManager.remove(entityManager.merge(cliente));

	}

	@Override
	public Cliente buscarCliente(String cliente) {
		return entityManager.find(Cliente.class, cliente);

	}

	@Override
	public List<Movimiento>  buscarMovimientos(String cliente) {

		return (List<Movimiento> )entityManager.createQuery("SELECT c FROM Movimiento c WHERE c.idCliente LIKE :idCliente")
				.setParameter("idCliente", cliente).setMaxResults(10).getResultList();
		
	

	}

}

/*
 * @Singleton public class ProductoRepositoryBean implements
 * ProductoRepositoryLocal {
 * 
 * 
 * List<Producto> lista= new ArrayList<Producto>();
 * 
 * 
 * public ProductoRepositoryBean() {
 * 
 * Producto p1= new Producto(1,"ordenador",400); Producto p2= new
 * Producto(2,"tablet",300); lista.add(p1); lista.add(p2); }
 * 
 * @Override public List<Producto> buscarTodos() {
 * 
 * return lista; }
 * 
 * @Override public void insertar(Producto producto) { // TODO Auto-generated
 * method stub lista.add(producto); }
 * 
 * @Override public void borrar(Producto producto) { lista.remove(producto);
 * 
 * }
 * 
 * }
 */