package com.uce.edu.demo.tarea26.service;

import java.math.BigDecimal;
import java.util.List;

import com.uce.edu.demo.tarea26.repository.modelo.Factura;

public interface IFacturaService {
	
	public List<Factura> buscarFacturaInnerJoin(BigDecimal subtotal);

	public List<Factura> buscarFacturaInnerJoin2(BigDecimal subtotal);

	public List<Factura> buscarFacturaInnerJoin();

	public List<Factura> buscarFacturaOuterLeftJoin(BigDecimal subtotal);

	public List<Factura> buscarFacturaOuterLeftJoin();

	public List<Factura> buscarFacturaOuterRightJoin(BigDecimal subtotal);

	public List<Factura> buscarFacturaWhereJoin(BigDecimal subtotal);

	public List<Factura> buscarFacturaJoinFetch(BigDecimal subtotal);

}