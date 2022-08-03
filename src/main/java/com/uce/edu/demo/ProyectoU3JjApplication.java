package com.uce.edu.demo;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Hotel;
import com.uce.edu.demo.service.IHotelService;

@SpringBootApplication
public class ProyectoU3JjApplication implements CommandLineRunner{
	
	@Autowired
	private IHotelService HotelService;

	private static Logger Log = Logger.getLogger(ProyectoU3JjApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3JjApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Log.info("INNER JOIN");
		List<Hotel> listaHoteles=this.HotelService.buscarHotelInnerJoin("Familiar");
		for(Hotel h: listaHoteles) {
			Log.info("Hotel:" + h.getNombre()+" "+ h.getDireccion());
		}
		
		List<Hotel> listaHotelesA=this.HotelService.buscarHotelInnerJoin();
		for(Hotel h: listaHotelesA) {
			Log.info("Hotel:" + h.getNombre()+" "+ h.getDireccion());
		}
		
		Log.info("LEFT JOIN");
		List<Hotel> listaHoteles1=this.HotelService.buscarHotelOuterJoinLeft("Familiar");
		for(Hotel h: listaHoteles1) {
			Log.info("Hotel:" + h.getNombre()+" "+ h.getDireccion());
		}
		
		List<Hotel> listaHotelesB=this.HotelService.buscarHotelOuterJoinLeft();
		for(Hotel h: listaHotelesB) {
			Log.info("Hotel:" + h.getNombre()+" "+ h.getDireccion());
		}
		
		Log.info("RIGHT JOIN");
		List<Hotel> listaHoteles2=this.HotelService.buscarHotelOuterJoinRight("Familiar");
		for(Hotel h: listaHoteles2) {
			Log.info("Hotel:" + h.getNombre()+" "+ h.getDireccion());
		}
		
		
		
	}

}
