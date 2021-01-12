package com.diaz.practica04.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.diaz.practica04.daos.IClienteDao;
import com.diaz.practica04.entidades.Cliente;

@Service
public class ClienteServiceJpaImpl implements IClienteServiceJpa {

	@Autowired
	private IClienteDao daoJpa;

	@Override
	public List<Cliente> findAll() {
		return (List<Cliente>) daoJpa.findAll();
	}
	
	@Override
	public Page<Cliente> findAll(Pageable pageable) {
		return daoJpa.findAll(pageable);
	}

	@Override
	public Cliente findById(Integer id) {
		return daoJpa.findById(id).get();
	}

	@Override
	public Cliente save(Cliente c) {
		return daoJpa.save(c);
	}

	@Override
	public Cliente update(Cliente c) {
		return daoJpa.save(c);
	}

	@Override
	public void delete(Integer id) {
		daoJpa.deleteById(id);
	}
	
}
