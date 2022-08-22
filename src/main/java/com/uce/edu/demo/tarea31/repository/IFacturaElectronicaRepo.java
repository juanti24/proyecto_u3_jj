package com.uce.edu.demo.tarea31.repository;

import com.uce.edu.demo.tarea31.repository.modelo.FacturaElectronica;

public interface IFacturaElectronicaRepo {

	
	public void insertar(FacturaElectronica facturaElectronica);

	public void actualizar(FacturaElectronica facturaElectronica);

	public void eliminar(Integer id);

	public FacturaElectronica buscar(Integer id);

	public FacturaElectronica buscarPorNumero(String numero);

}
	

