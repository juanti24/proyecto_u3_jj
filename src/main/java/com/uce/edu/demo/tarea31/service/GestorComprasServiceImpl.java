package com.uce.edu.demo.tarea31.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.tarea31.repository.IClienteRepo;
import com.uce.edu.demo.tarea31.repository.IDetalleFacturaRepo;
import com.uce.edu.demo.tarea31.repository.IFacturaElectronicaRepo;
import com.uce.edu.demo.tarea31.repository.IFacturaRepo;
import com.uce.edu.demo.tarea31.repository.IProductoRepo;
import com.uce.edu.demo.tarea31.repository.modelo.Cliente;
import com.uce.edu.demo.tarea31.repository.modelo.DetalleFactura;
import com.uce.edu.demo.tarea31.repository.modelo.Factura;
import com.uce.edu.demo.tarea31.repository.modelo.FacturaElectronica;
import com.uce.edu.demo.tarea31.repository.modelo.Producto;

@Service
public class GestorComprasServiceImpl implements IGestorComprasService{

	@Autowired
	private IFacturaService facturaService;
	
	@Autowired
	private IFacturaElectronicaService electronicaService;
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void registrarCompraProducto(String cedula, String numeroFactura, List<String> listaCodigo) {
		// TODO Auto-generated method stub
	
		BigDecimal totalPagar = this.facturaService.procesarFactura(cedula, numeroFactura, listaCodigo);
		
		this.electronicaService.procesarElectronica(numeroFactura, listaCodigo.size(), totalPagar);
		
	}

}