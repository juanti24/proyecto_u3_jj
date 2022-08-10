package com.uce.edu.demo.service;

import java.math.BigDecimal;

public interface ITransferenciaService {

	public void realizar(String ctaOrigen, String Destino, BigDecimal monto );
	
	public void realizarTransFachada(String ctaOrigen, String Destino, BigDecimal monto );
}
