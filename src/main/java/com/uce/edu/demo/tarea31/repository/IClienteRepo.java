package com.uce.edu.demo.tarea31.repository;

import com.uce.edu.demo.tarea31.repository.modelo.Cliente;

public interface IClienteRepo {

	public void insertar(Cliente cliente);

	public Cliente buscar(String cedula);

}
