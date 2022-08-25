package com.uce.edu.demo.tarea31.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.tarea31.repository.IClienteRepo;
import com.uce.edu.demo.tarea31.repository.modelo.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteRepo clienteRepository;

	@Override
	public void insertar(Cliente cliente) {
		this.clienteRepository.insertar(cliente);

	}

}