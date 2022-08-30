package com.uce.edu.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.jboss.logging.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProyectoU3JjApplication implements CommandLineRunner {

	private static Logger Log = Logger.getLogger(ProyectoU3JjApplication.class);
	
	public static boolean prueba(Integer numero) {
		return numero >=3;
		
	}
	
	public static void imprimir(String cadena) {
		Log.info(("Impresion" + cadena));
		
	}
	
	public static void guardar(String elemento) {
		
		
	}
	

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3JjApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Log.info("JAVA SUPPLIER");
		//SUPPLIER
		//JAVA
		Stream<String> test =Stream.generate(() -> "Juan 3").limit(2);
		
		//Pilas este recibe un consummer
		test.forEach(cadena -> System.out.println(cadena));
		
		Log.info("JAVA CONSUMMER");
		//CONSUMMER
		//JAVA
		List<Integer> listNumeros = Arrays.asList(1,2,3,4,5);
		
		listNumeros.forEach(numero -> System.out.println(numero));
		
		//Cuando queramos evaluar una condición 
		Log.info("JAVA PREDICATE");
		//PREDICATE
		//JAVA
		Stream<Integer>nuevaLista=listNumeros.stream().filter(numero -> prueba(numero));
		//Se puede utilizar con cualquier metodo de tipo void
		nuevaLista.forEach(numero -> System.out.println(numero));
	
		//Function y Consummer mas utrilizadas
		
		
		//Conversiones / cast Empleado -> EmpleadoDTO (Ligero)
		Log.info("JAVA FUNCTION");
		//FUNCTION
		//JAVA
			Stream<String> listaCambiada = listNumeros.stream().map(numeroList -> {
			Integer valor = numeroList + 1;
			String cadena = "num" + valor.toString();
			return cadena;
		});
			listaCambiada.forEach(valor -> imprimir(valor));
	
		
			//List<String> lista1 = new ArrayList<>();
			//Map<String,String> mpa1 = new HashMap<String,String>();
			
			
			//Imperativa: pasa a paso
			//for(String valor:) {
			//	imprimir(valor);
			//}
			
			
			
	}
}