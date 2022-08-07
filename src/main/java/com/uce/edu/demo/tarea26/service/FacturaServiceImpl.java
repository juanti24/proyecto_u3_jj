package com.uce.edu.demo.tarea26.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.tarea26.repository.IFacturaRepository;
import com.uce.edu.demo.tarea26.repository.modelo.Factura;

@Service
public class FacturaServiceImpl implements IFacturaService {

	@Autowired
	private IFacturaRepository iFacturaRepository;

	@Override
	public List<Factura> buscarFacturaInnerJoin(BigDecimal subtotal) {
		return this.iFacturaRepository.buscarFacturaInnerJoin(subtotal);
	}

	@Override
	public List<Factura> buscarFacturaInnerJoin2(BigDecimal subtotal) {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.buscarFacturaInnerJoin2(subtotal);
	}

	@Override
	public List<Factura> buscarFacturaInnerJoin() {
		return this.iFacturaRepository.buscarFacturaInnerJoin();
	}

	@Override
	public List<Factura> buscarFacturaOuterLeftJoin(BigDecimal subtotal) {
		return this.iFacturaRepository.buscarFacturaOuterLeftJoin(subtotal);
	}

	@Override
	public List<Factura> buscarFacturaOuterLeftJoin() {
		return this.iFacturaRepository.buscarFacturaOuterLeftJoin();
	}

	@Override
	public List<Factura> buscarFacturaOuterRightJoin(BigDecimal subtotal) {
		return this.iFacturaRepository.buscarFacturaOuterRightJoin(subtotal);
	}

	@Override
	public List<Factura> buscarFacturaWhereJoin(BigDecimal subtotal) {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.buscarFacturaWhereJoin(subtotal);
	}

	@Override
	public List<Factura> buscarFacturaJoinFetch(BigDecimal subtotal) {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.buscarFacturaJoinFetch(subtotal);
	}

}