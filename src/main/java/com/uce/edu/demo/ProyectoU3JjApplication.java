package com.uce.edu.demo;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.tarea31.repository.modelo.Cliente;
import com.uce.edu.demo.tarea31.repository.modelo.Producto;
import com.uce.edu.demo.tarea31.service.IClienteService;
import com.uce.edu.demo.tarea31.service.IFacturaService;
import com.uce.edu.demo.tarea31.service.IProductoService;

@SpringBootApplication
public class ProyectoU3JjApplication implements CommandLineRunner {

	@Autowired
	private IClienteService iClienteService;

	@Autowired
	private IFacturaService facturaService;

	@Autowired
	private IProductoService productoService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3JjApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Cliente c1 = new Cliente();
		c1.setCedula("1723920979");
		c1.setNombre("Juan");
		c1.setApellido("Lopez");
		c1.setNumeroTarjeta("1659-0000-1111");

		//this.iClienteService.insertar(c1);

		Producto p1 = new Producto();
		p1.setCodigoBarras("0001");
		p1.setNombre("Monster");
		p1.setPrecio(new BigDecimal(3.50));
		p1.setStock(50);

		Producto p2 = new Producto();
		p2.setCodigoBarras("0002");
		p2.setNombre("Sal");
		p2.setPrecio(new BigDecimal(1.00));
		p2.setStock(80);

		//this.productoService.insertar(p1);
		//this.productoService.insertar(p2);

		this.facturaService.crearFactura("001-001-003", "1723920979", "0001", "0001", "0001");

	}

}