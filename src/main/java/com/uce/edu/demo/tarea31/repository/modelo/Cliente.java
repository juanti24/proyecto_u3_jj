package com.uce.edu.demo.tarea31.repository.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clie_seq_id")
	@SequenceGenerator(name = "clie_seq_id", sequenceName = "clie_seq_id", allocationSize = 1)
	@Column(name = "clie_id")
	private Integer id;

	@Column(name = "clie_cedula")
	private String cedula;

	@Column(name = "clie_numero_tarjeta")
	private String numeroTarjeta;

	@OneToMany(mappedBy = "cliente")
	private List<Factura> facturas;

	// SET Y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public List<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", numeroTarjeta=" + numeroTarjeta /* + ", ciudadano=" + ciudadano */ + "]";
	}

}