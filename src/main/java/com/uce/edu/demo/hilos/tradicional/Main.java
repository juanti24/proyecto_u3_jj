package com.uce.edu.demo.hilos.tradicional;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		long tiempInicial = System.currentTimeMillis();
		
		
		Cajero cajero = new Cajero("Edison", Arrays.asList("Pepito", "Juan"));
		Cajero cajero1 = new Cajero("Juan", Arrays.asList("Pepito1", "Juan1", "Pedro1"));
		Cajero cajero2 = new Cajero("Carlos", Arrays.asList("Pepito2"));

		PCCajero gestorAtrncion = new PCCajero();
		gestorAtrncion.procesar(cajero);
		gestorAtrncion.procesar(cajero1);
		gestorAtrncion.procesar(cajero2);
		
		long tiempFinal = System.currentTimeMillis();
		
		long tiempoTranscurrido = (tiempFinal - tiempInicial)/1000;
		
		System.out.println(tiempoTranscurrido);
	}

}