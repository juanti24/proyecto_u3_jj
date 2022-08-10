package com.uce.edu.demo.service;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.HotelRepoImpl;
import com.uce.edu.demo.repository.IHotelRepo;
import com.uce.edu.demo.repository.modelo.Hotel;

@Service
public class HotelServiceImpl implements IHotelService{

	
	private static Logger LOG = Logger.getLogger(HotelServiceImpl.class);
	
	@Autowired
	private IHotelRepo iHotelRepo;
	
	@Override
	public List<Hotel> buscarHotelInnerJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return this.iHotelRepo.buscarHotelInnerJoin(tipoHabitacion);
	}

	@Override
	public List<Hotel> buscarHotelOuterJoinRight(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return this.iHotelRepo.buscarHotelOuterJoinRight(tipoHabitacion);
	}

	@Override
	public List<Hotel> buscarHotelOuterJoinLeft(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return this.iHotelRepo.buscarHotelOuterJoinLeft(tipoHabitacion);
	}

	@Override
	public List<Hotel> buscarHotelJoinWhere(String tipoHabitacion) {
		return  this.iHotelRepo.buscarHotelJoinWhere(tipoHabitacion);
		
	}

	@Override
	public List<Hotel> buscarHotelJoinFetch(String tipoHabitacion) {
		 LOG.info("Transaccion service: "+org.springframework.transaction.support.TransactionSynchronizationManager.isActualTransactionActive() );
		return this.iHotelRepo.buscarHotelJoinFetch(tipoHabitacion);
	}

	@Override
	public List<Hotel> buscarHotelInnerJoin() {
		// TODO Auto-generated method stub
		return this.iHotelRepo.buscarHotelInnerJoin();
	}

	@Override
	public List<Hotel> buscarHotelOuterJoinLeft() {
		// TODO Auto-generated method stub
		return this.iHotelRepo.buscarHotelOuterJoinLeft();
	}

	@Override
	public List<Hotel> buscarHotelOuterJoinRight() {
		// TODO Auto-generated method stub
		return this.iHotelRepo.buscarHotelOuterJoinRight();
	}

}
