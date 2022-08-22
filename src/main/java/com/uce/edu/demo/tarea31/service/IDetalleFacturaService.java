package com.uce.edu.demo.tarea31.service;

import com.uce.edu.demo.tarea31.repository.modelo.DetalleFactura;

public interface IDetalleFacturaService {
	
	public void insertar(DetalleFactura detalle);

	public void actualizar(DetalleFactura detalle);

	public void eliminar(Integer id);

	public DetalleFactura buscar(Integer id);

}
