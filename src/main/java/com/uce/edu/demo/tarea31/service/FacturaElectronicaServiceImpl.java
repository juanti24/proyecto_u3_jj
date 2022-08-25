package com.uce.edu.demo.tarea31.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.tarea31.repository.IFacturaElectronicaRepo;
import com.uce.edu.demo.tarea31.repository.modelo.FacturaElectronica;

@Service
public class FacturaElectronicaServiceImpl implements IFacturaElectronicaService{

	@Autowired
	private IFacturaElectronicaRepo electronicaRepository;
	
	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void procesarElectronica(String numeroFactura, Integer cantidadItems, BigDecimal monto) {
		// TODO Auto-generated method stub
		FacturaElectronica electronica = new FacturaElectronica();
		electronica.setNumero(numeroFactura);
		electronica.setFecha(LocalDateTime.now());
		electronica.setNumeroItem(cantidadItems);
		electronica.setMonto(monto);
		
		this.electronicaRepository.insertar(electronica);
		throw new RuntimeException();
	}

}
