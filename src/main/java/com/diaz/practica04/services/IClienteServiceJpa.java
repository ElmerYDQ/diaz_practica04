package com.diaz.practica04.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.diaz.practica04.entidades.Cliente;

public interface IClienteServiceJpa {
	
	List<Cliente> findAll();
	
	public Page<Cliente> findAll(Pageable pageable);
	
	Cliente findById(Integer id);
	
	Cliente save(Cliente c);
	
	Cliente update(Cliente c);
	
	void delete(Integer id);
}
