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
	private ITransfereciaRepo iTransferenciaRepository;

	@Autowired
	private ICuentaBancariaRepo iCuentaBancariaRepository;

	@Override
//	@Transactional(value = TxType.REQUIRED)
	@Transactional(value = TxType.REQUIRES_NEW)
	public void realizarTransferencia(String numeroCtaOrigen, String numeroCtaDestino, BigDecimal monto) {
		// 0. Buscar la cuenta origen (obtener saldo)
		CuentaBancaria cuentaOrigen = this.iCuentaBancariaRepository.buscarPorNumero(numeroCtaOrigen);

		// 1. Restar monto a la cuenta origen
		cuentaOrigen.setSaldo(cuentaOrigen.getSaldo().subtract(monto));
		this.iCuentaBancariaRepository.actualizar(cuentaOrigen);
		BigDecimal saldoOrigen = cuentaOrigen.getSaldo();
		BigDecimal saldoFinal = saldoOrigen.subtract(monto);

		cuentaOrigen.setSaldo(saldoFinal);
		this.iCuentaBancariaRepository.actualizar(cuentaOrigen);

		// 0. Buscar la cuenta destino
		CuentaBancaria cuentaDestino = this.iCuentaBancariaRepository.buscarPorNumero(numeroCtaDestino);

		// 2. Sumar el monto a la cuenta destino
		cuentaDestino.setSaldo(cuentaDestino.getSaldo().add(monto));
		this.iCuentaBancariaRepository.actualizar(cuentaDestino);

		// 3. Insertar transferencia
		Transferencia t = new Transferencia();
		t.setFecha(LocalDateTime.now());
		t.setMonto(monto);
		t.setCuentaOrigen(cuentaOrigen);
		t.setCuentaDestino(cuentaDestino);

		this.iTransferenciaRepository.insertar(t);

		if (cuentaOrigen.getTipo().equals("Ahorros")) {
			throw new RuntimeException();
		}
		if (monto.compareTo(saldoOrigen) > 0) {

			throw new RuntimeException();
		}

	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void realizarTransferenciaFachada(String numeroCtaOrigen, String numeroCtaDestino, BigDecimal monto) {
		this.realizarTransferencia(numeroCtaOrigen, numeroCtaDestino, monto);
	}

	@Override
	public Transferencia buscar(Integer id) {
		return this.iTransferenciaRepository.buscar(id);
	}

	// Si ambos metodos tiene REQUIRED, ambos funcionan en una misma transaccion

	/*
	 * Si el metodo externo tiene REQUIRED y el interno REQUIRES_NEW, el interno
	 * abre su propia transaccion a pesar de la que existe externamente.
	 */

}
