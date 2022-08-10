package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.CuentaBancaria;

public interface ICuentaBancariaRepo {
	
	public void actualizar(CuentaBancaria cta);

	public CuentaBancaria buscarPorNumero(String numero);
}
