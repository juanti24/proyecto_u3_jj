package com.uce.edu.demo;

import java.math.BigDecimal;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.service.ITransferenciaService;

@SpringBootApplication
public class ProyectoU3JjApplication implements CommandLineRunner {

	@Autowired
	private ITransferenciaService ITransferenciaService;

	private static Logger LOG = Logger.getLogger(ProyectoU3JjApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3JjApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		 this.ITransferenciaService.realizarTransferenciaFachada("101011", "101012", new BigDecimal(1));

	}

}