package com.uce.edu.demo.hilos.paralelo;

import java.util.concurrent.TimeUnit;

import com.uce.edu.demo.hilos.tradicional.Cajero;

public class PCCajeroParalelo extends Thread {

	public CajeroParalelo cajero;

	public PCCajeroParalelo(CajeroParalelo cajero) {
		this.cajero = cajero;
	}

	// Disparar el método a paralelizar
	@Override
	public void run() {
		this.procesar(this.cajero);
	}

	public void procesar(CajeroParalelo cajero) {
		long tiempInicial = System.currentTimeMillis();
		
		
		System.out.println("Nombre del hilo" + Thread.currentThread().getName());
		System.out.println("Procesando cajero:" + cajero);
		for (String cliente : cajero.getClientes()) {
			this.atenderCliente(cliente);

		}

		long tiempFinal = System.currentTimeMillis();

		long tiempoTranscurrido = (tiempFinal - tiempInicial) / 1000;

		System.out.println("Terminó: " + cajero.getNombre() + " " + tiempoTranscurrido + "seg" );
	}

	private void atenderCliente(String cliente) {
		System.out.println("Atendiendo a: " + cliente);
		// Demorar el metodo 10 seg
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
