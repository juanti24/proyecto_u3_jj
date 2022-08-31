package com.uce.edu.demo.hilos.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class MainStreamParalelo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> listaNumerosAlumnos = new ArrayList<>();
		long tiempInicial = System.currentTimeMillis();

		for (int i = 1; i < 5000; i++) {
			listaNumerosAlumnos.add(i);
		}
		List<String> listaProcesada = listaNumerosAlumnos.parallelStream().map(numero -> convertirIdAlumno(numero))
				.collect(Collectors.toList());
		listaProcesada.forEach(cadena -> System.out.println(cadena));
		long tiempFinal = System.currentTimeMillis();

		long tiempoTranscurrido = (tiempFinal - tiempInicial) / 1000;

		System.out.println(tiempoTranscurrido);

	}

	private static String convertirIdAlumno(Integer id) {
		try {
			TimeUnit.MILLISECONDS.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "ID: " + id.toString();

	}
}