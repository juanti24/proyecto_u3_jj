package com.uce.edu.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.tarea31.repository.IClienteRepo;
import com.uce.edu.demo.tarea31.repository.IProductoRepo;
import com.uce.edu.demo.tarea31.repository.modelo.Cliente;
import com.uce.edu.demo.tarea31.repository.modelo.Producto;
import com.uce.edu.demo.tarea31.service.IGestorComprasService;

@SpringBootApplication
public class ProyectoU3JjApplication implements CommandLineRunner {

	@Autowired
	private IGestorComprasService comprasService;
	
	@Autowired
	private IClienteRepo clienteRepository;
	
	@Autowired
	private IProductoRepo iProductoRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3JjApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		
		Cliente cliente=new Cliente();
		cliente.setCedula("1720223031");
		cliente.setNumeroTarjeta("1234567");
		//this.clienteRepository.insertar(cliente);
		
		Producto producto=new Producto();
		producto.setNombre("Arroz");
		producto.setNumero("45");
		producto.setPrecio(new BigDecimal(1.50));
		producto.setStock(50);
		//this.iProductoRepository.insertar(producto);
		
		Producto producto2=new Producto();
		producto2.setNombre("Chicles");
		producto2.setNumero("05");
		producto2.setPrecio(new BigDecimal(5.00));
		producto2.setStock(75);
		//this.iProductoRepository.insertar(producto2);
		
		Producto producto3=new Producto();
		producto3.setNombre("Chocolate");
		producto3.setNumero("01");
		producto3.setPrecio(new BigDecimal(0.50));
		producto3.setStock(100);
		//this.iProductoRepository.insertar(producto3);
		
		List<String>detalles=new ArrayList<>();
		detalles.add(producto.getNumero());
		detalles.add(producto2.getNumero());
		detalles.add(producto3.getNumero());
		
		this.comprasService.registrarCompraProducto("1720223031", "6543214", detalles);
	}

}