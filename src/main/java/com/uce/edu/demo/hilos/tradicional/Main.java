package com.uce.edu.demo.hilos.tradicional;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		long tiempInicial = System.currentTimeMillis();
		
		System.out.println("Nombre Hilo:" + Thread.currentThread().getName());
		
		Cajero cajero = new Cajero("Edison", Arrays.asList("Pepito", "Juan"));
		Cajero cajero1 = new Cajero("Juan", Arrays.asList("Pepito1", "Juan1"));
		Cajero cajero2 = new Cajero("Carlos", Arrays.asList("Pepito2", "Juan2"));

		PCCajero gestorAtrncion = new PCCajero();
		gestorAtrncion.procesar(cajero);
		PCCajero gestorAtrncion1 = new PCCajero();
		gestorAtrncion1.procesar(cajero1);
		PCCajero gestorAtrncion2 = new PCCajero();
		gestorAtrncion2.procesar(cajero2);
		
		long tiempFinal = System.currentTimeMillis();
		
		long tiempoTranscurrido = (tiempFinal - tiempInicial)/1000;
		
		System.out.println(tiempoTranscurrido);
	}

}