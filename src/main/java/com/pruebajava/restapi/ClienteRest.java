package com.pruebajava.restapi;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.pruebajava.dominio.Cliente;
import com.pruebajava.dominio.Response;
import com.pruebajava.ejb.ProductoServiceLocal;

@Path("/clientes")
@Stateless
@Produces({"application/json"})
public class ClienteRest {
	
	@EJB
	ProductoServiceLocal servicio;
	@GET
	public List<Cliente> buscarTodos(){
		return servicio.buscarTodos();
		
	}
	@POST
	public void insertar(Cliente cliente)
	{
		
		servicio.insertar(cliente);
	}
	
	
	@GET
	@Path("/buscarClientes/find/{cliente}")
	public Response buscarCliente( @PathParam("cliente")    String cliente){
		return servicio.buscarCliente(cliente);
		
	}
	
	
	

}
