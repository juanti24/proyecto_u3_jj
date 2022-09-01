package com.uce.edu.demo.tarea35;

import java.util.concurrent.TimeUnit;

public class Deporte extends Thread {

	private Deportista deportista;

	public Deporte(Deportista deportista) {
		this.deportista = deportista;
	}

	@Override
	public void run() {
		this.iniciarSesion(this.deportista);
	}

	private void iniciarSesion(Deportista deportista) {
		System.out.println("Nombre del hilo: " + Thread.currentThread().getName());

		int tiempo = this.verificarTag(deportista.getGamerTag());

		long tiempoInicial = System.currentTimeMillis();

		try {
			TimeUnit.SECONDS.sleep(tiempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		long tiempoFinal = System.currentTimeMillis();

		long tiempoTotal = (tiempoFinal - tiempoInicial) / 1000;

		System.out.println("Tiempo " + deportista.getGamerTag() + ": " + tiempoTotal + " horas.");

	}

	private int verificarTag(String deporTag) {
		System.out.println("Bienvenido, " + deporTag);
		switch (deporTag) {
		case "Deportista 1":
			return 3;
		case "Deportista 2":
			return 10;
		case "Deportista 3":
			return 13;
		case "Deportista 4":
			return 25;
		default:
			return 5;
		}
	}

}