package com.diaz.practica04.daos;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.diaz.practica04.entidades.Cliente;

public interface IClienteDao extends PagingAndSortingRepository<Cliente, Integer> {

}
