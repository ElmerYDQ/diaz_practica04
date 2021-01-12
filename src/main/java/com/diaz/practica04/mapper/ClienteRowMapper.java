package com.diaz.practica04.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.diaz.practica04.entidades.Cliente;

public class ClienteRowMapper implements RowMapper<Cliente> {

	@Override
	public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
		Cliente cliente = new Cliente();
		cliente.setId(rs.getInt("id"));
		cliente.setApellido(rs.getString("apellido"));
		cliente.setNombre(rs.getString("nombre"));
		cliente.setCorreo(rs.getString("correo"));
		cliente.setTelefono(rs.getString("telefono"));
		return cliente;
	}

}
