package com.pruebajava.ejb;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.pruebajava.dominio.Cliente;
import com.pruebajava.dominio.Movimiento;
import com.pruebajava.dominio.Response;
import com.pruebajava.util.SeguridadData;

import com.pruebajava.dominio.MovimientoDTO;

/**
 * Session Bean implementation class ProductoServiceBean
 */
@Stateless
public class ProductoServiceBean implements ProductoServiceLocal {

	@EJB
	ProductoRepositoryLocal repositorio;

	public void insertar(Cliente cliente) {

		String clienteX = null;

		try {
			clienteX = SeguridadData.encriptar(cliente.getIdCliente(), "clavesecreta!");
			cliente.setIdCliente(clienteX);
			repositorio.insertar(cliente);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error en la encriptacion" + e);
		}

	}

	public List<Cliente> buscarTodos() {
		return repositorio.buscarTodos();
	}

	@Override
	public void borrar(Cliente cliente) {
		repositorio.borrar(cliente);

	}

	@Override
	public Response buscarCliente(Cliente cliente) {
		Response response = new Response();
		Cliente c = null;
		try {

			if (cliente.getIdCliente().length() > 9) {

				response.setStatus(false);
				response.setMessage("Codigo Incorrecto");
				return response;
			}

			String clienteX = SeguridadData.encriptar(cliente.getIdCliente(), "clavesecreta!");
			cliente.setIdCliente(clienteX);
			c = repositorio.buscarCliente(cliente);

			if (c != null) {
				response.setStatus(true);
				response.setMessage("Cliente Encontrado");

				// buscar movimientos Cliente
				List<Movimiento> m = new ArrayList<Movimiento>();

				m = buscarMovimientos(cliente);

				BigDecimal sum = BigDecimal.ZERO;

				List<MovimientoDTO> movimientos = new ArrayList<MovimientoDTO>();

				if (m != null && !m.isEmpty()) {

					for (Movimiento mov : m) {

						MovimientoDTO movDto = new MovimientoDTO();

						if (mov.getTipoMovimiento().getId().equals("C")) {
							sum = sum.add(mov.getValor());

						} else {
							sum = sum.subtract(mov.getValor());
						}

						movDto.setDescripcion(mov.getDescripcion());
						movDto.setTipo(mov.getTipoMovimiento().getDescripcion());
						movDto.setValor(mov.getValor().toString());

						movimientos.add(movDto);

					}
				}

				sum = sum.abs();

				c.setSaldoCuenta(sum);

				response.setCliente(c);

				response.setMovimiento(movimientos);

				return response;
			}

			response.setStatus(false);
			response.setMessage("Cliente no existe");
			return response;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error en la encriptacion" + e);
		}

		return response;
	}

	@Override
	public List<Movimiento> buscarMovimientos(Cliente cliente) {
		// TODO Auto-generated method stub
		return repositorio.buscarMovimientos(cliente);
	}

}
