package com.uce.edu.demo.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "transferencia")
public class Transferencia {

	@Id
	@Column(name = "trans_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tran_id_seq")
	@SequenceGenerator(name = "tran_id_seq", sequenceName = "tran_id_seq", allocationSize = 1)
	private Integer id;

	@Column(name = "tran_fecha")
	private LocalDateTime fechaTransferencia;

	@Column(name = "tran_monto")
	private BigDecimal monto;

	@ManyToOne
	@JoinColumn(name = "tran_cta_origen")
	private CuentaBancaria ctaOrigin;

	@ManyToOne
	@JoinColumn(name = "tran_cta_destino")
	private CuentaBancaria ctaDestino;

	// SET Y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getFechaTransferencia() {
		return fechaTransferencia;
	}

	public void setFechaTransferencia(LocalDateTime fechaTransferencia) {
		this.fechaTransferencia = fechaTransferencia;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public CuentaBancaria getCtaDestino() {
		return ctaDestino;
	}

	public void setCtaDestino(CuentaBancaria ctaDestino) {
		this.ctaDestino = ctaDestino;
	}

	public CuentaBancaria getCtaOrigin() {
		return ctaOrigin;
	}

	public void setCtaOrigin(CuentaBancaria ctaOrigin) {
		this.ctaOrigin = ctaOrigin;
	}

}
