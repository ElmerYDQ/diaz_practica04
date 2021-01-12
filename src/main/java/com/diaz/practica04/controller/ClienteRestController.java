package com.diaz.practica04.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.diaz.practica04.services.IClienteServiceJpa;
import com.diaz.practica04.entidades.Cliente;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ClienteRestController {
	
	@Autowired
	private IClienteServiceJpa servicio;
	
	@GetMapping(value = "/clientes", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Cliente> listar() {
		return servicio.findAll();
	}
	
	@PostMapping(value="/clientes", consumes=MediaType.APPLICATION_JSON_VALUE)
	public Cliente saveCliente(@RequestBody Cliente cliente) {
		
		return servicio.save(cliente);
	}
	
	@PutMapping(value="/clientes/{id}", consumes=MediaType.APPLICATION_JSON_VALUE)
	public Cliente updateCliente(@RequestBody Cliente cliente) {
		
		return servicio.update(cliente);
	}
	
	@DeleteMapping(value="/clientes/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCliente(@PathVariable Integer id) {
		
		servicio.delete(id);
	}
	
	@GetMapping(value="/clientes/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Cliente obtenerCliente(@PathVariable Integer id) {
		return servicio.findById(id);
	}

}
