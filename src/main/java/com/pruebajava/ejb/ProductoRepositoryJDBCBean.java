package com.pruebajava.ejb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

import com.pruebajava.dominio.Cliente;





/**
 * Session Bean implementation class ProductoRepositoryJDBCBean
 */
@Stateless
public class ProductoRepositoryJDBCBean implements ProductoRepositoryJDBCLocal {

	@Resource(lookup = "java:jboss/datasources/MySQLDS")
	DataSource dataSource;

	@Override
	public List<Cliente> buscarTodos() {
		// TODO Auto-generated method stub
		List<Cliente> lista = null;
		try {
			lista = new ArrayList<Cliente>();
			Connection con = dataSource.getConnection();
			Statement sentencia = con.createStatement();
			ResultSet rs = sentencia.executeQuery("select * from clientes");
			while (rs.next()) {

				Cliente cliente = new Cliente(rs.getString("id_cliente"),rs.getString("nombre_cliente"), 
						        rs.getInt("numero_cuenta"),
						rs.getString("tipo_cuenta"), rs.getBigDecimal("saldo_cuenta"), rs.getString("estado_cuenta")
						);

				System.out.println(rs.getString("nombre_cliente"));
				System.out.println(rs.getInt("numero_cuenta"));
				System.out.println(rs.getString("tipo_cuenta"));
				System.out.println(rs.getBigDecimal("saldo_cuenta"));
				System.out.println(rs.getString("estado_cuenta"));
				System.out.println(rs.getInt("id_cliente"));
				lista.add(cliente);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;

	}

}
