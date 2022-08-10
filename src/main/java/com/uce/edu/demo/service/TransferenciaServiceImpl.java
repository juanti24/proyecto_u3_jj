package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ICuentaBancariaRepo;
import com.uce.edu.demo.repository.ITransfereciaRepo;
import com.uce.edu.demo.repository.modelo.CuentaBancaria;
import com.uce.edu.demo.repository.modelo.Transferencia;

@Service
public class TransferenciaServiceImpl implements ITransferenciaService {

	@Autowired
	private ICuentaBancariaRepo ICuentaBancariaRepo;

	@Autowired
	private ITransfereciaRepo ITransferenciaRepo;

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void realizar(String Origen, String Destino, BigDecimal monto) {
	
		CuentaBancaria ctaOrigen = this.ICuentaBancariaRepo.buscarPorNumero(Origen);
		BigDecimal saldoOrigen = ctaOrigen.getSaldo();
		BigDecimal saldoFinal = saldoOrigen.subtract(monto);
		ctaOrigen.setSaldo(saldoFinal);
		this.ICuentaBancariaRepo.actualizar(ctaOrigen);
		CuentaBancaria ctaDestino = this.ICuentaBancariaRepo.buscarPorNumero(Destino);
		ctaDestino.setSaldo(ctaDestino.getSaldo().add(monto));
		this.ICuentaBancariaRepo.actualizar(ctaDestino);

		Transferencia trans = new Transferencia();
		trans.setFechaTransferencia(LocalDateTime.now());
		trans.setMonto(monto);
		trans.setCtaOrigin(ctaOrigen);
		trans.setCtaOrigin(ctaDestino);
		this.ITransferenciaRepo.insertar(null);
	}

	@Override
	//@Transactional(value = TxType.REQUIRED)
	public void realizarTransFachada(String ctaOrigen, String Destino, BigDecimal monto) {
		this.realizar(ctaOrigen, Destino, monto);
		
	}

}
