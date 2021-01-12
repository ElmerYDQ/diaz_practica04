package com.diaz.practica04.daos;

import org.springframework.data.repository.CrudRepository;

import com.diaz.practica04.entidades.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long>{

	public Usuario findByUsername(String username);
}
