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
public class ProyectoU3JjApplication implements CommandLineRunner {

	private static final Logger LOG = Logger.getLogger(ProyectoU3JjApplication.class);

	@Autowired
	private IHotelService ihotelService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3JjApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		LOG.info("Relacionamiento WHERE");
		List<Hotel> listaHoteles = this.ihotelService.buscarHotelJoinWhere("Familiar");
		for (Hotel h : listaHoteles) {
			LOG.info("Hotel:" + h.getNombre() + " " + h.getDireccion());
		}

		LOG.info("INNER JOIN EAGER/LAZY");
		List<Hotel> listaHoteles1 = this.ihotelService.buscarHotelInnerJoin("Familiar");
		for (Hotel h : listaHoteles1) {
			LOG.info("Hotel2: " + h.getNombre() + " " + h.getDireccion() );
			LOG.info("Hotel2Habitaciones: " + h.getHabitaciones());
		}
		
		LOG.info("JOIN FETCH");
		List<Hotel> listaHoteles3 = this.ihotelService.buscarHotelJoinFetch("Familiar");
		for (Hotel h : listaHoteles3) {
			LOG.info("Hotel3: " + h.getNombre() + " " + h.getDireccion() );
			LOG.info("Hotel3Habitaciones: " + h.getHabitaciones());
		}
	}

}
