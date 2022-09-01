package com.uce.edu.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.service.IHotelService;
import com.uce.edu.demo.service.ITransferenciaService;

@SpringBootApplication
public class ProyectoU3JjApplication implements CommandLineRunner {

	@Autowired
	private IHotelService hotelService;

	@Autowired
	private ITransferenciaService transferenciaService;



	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3JjApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		

	}

}
