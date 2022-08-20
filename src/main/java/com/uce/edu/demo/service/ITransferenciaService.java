package com.uce.edu.demo.service;

import java.math.BigDecimal;

import com.uce.edu.demo.repository.modelo.Transferencia;

public interface ITransferenciaService {

	public void realizarTransferencia(String numeroCtaOrigen, String numeroCtaDestino, BigDecimal monto);

	public void realizarTransferenciaFachada(String numeroCtaOrigen, String numeroCtaDestino, BigDecimal monto);
	
	public Transferencia buscar(Integer id);

}
