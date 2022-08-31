package com.uce.edu.demo.hilos.paralelo;

import java.util.Arrays;

public class MianParalelo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		long tiempInicial = System.currentTimeMillis();
		

		System.out.println("Nombre Hilo:" + Thread.currentThread().getName());
		
		CajeroParalelo cajero = new CajeroParalelo("Edison", Arrays.asList("Pepito"));
		CajeroParalelo cajero1 = new CajeroParalelo("Juan", Arrays.asList("Juan1"));
		CajeroParalelo cajero2 = new CajeroParalelo("Carlos", Arrays.asList("Pepito2"));
		
		CajeroParalelo cajero3 = new CajeroParalelo("Edison", Arrays.asList("Juan"));
		CajeroParalelo cajero4 = new CajeroParalelo("Juan", Arrays.asList("Pepito1"));
		CajeroParalelo cajero5 = new CajeroParalelo("Carlos", Arrays.asList("Juan2"));
		
		
		PCCajeroParalelo gestorAtrncion = new PCCajeroParalelo(cajero);
		gestorAtrncion.start();
		
		PCCajeroParalelo gestorAtrncion1 = new PCCajeroParalelo(cajero1);
		gestorAtrncion1.start();
		
		PCCajeroParalelo gestorAtrncion2 = new PCCajeroParalelo(cajero2);
		gestorAtrncion2.start();
		
		
		PCCajeroParalelo gestorAtrncion3 = new PCCajeroParalelo(cajero3);
		gestorAtrncion3.start();
		
		PCCajeroParalelo gestorAtrncion4 = new PCCajeroParalelo(cajero4);
		gestorAtrncion4.start();
		
		PCCajeroParalelo gestorAtrncion5 = new PCCajeroParalelo(cajero5);
		gestorAtrncion5.start();
		
		
		long tiempFinal = System.currentTimeMillis();
		
		long tiempoTranscurrido = (tiempFinal - tiempInicial)/1000;
		
		System.out.println(tiempoTranscurrido);
		
		
	}

}
