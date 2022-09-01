package com.uce.edu.demo.tarea35;

public class MainTareaParalelo {

	public static void main(String[] args) {

		Deportista d1 = new Deportista("Juan M.", "Deportista 1");
		Deportista d2 = new Deportista("Diego M.", "Deportista 2");
		Deportista d3 = new Deportista("Iván V.", "Deportista 3");
		Deportista d4 = new Deportista("Luis T.", "Deportista 4");
		Deportista d5 = new Deportista("Javier D.", "Deportista 5");

		Deporte c1 = new Deporte(d1);
		c1.start();

		Deporte c2 = new Deporte(d2);
		c2.start();

		Deporte c3 = new Deporte(d3);
		c3.start();

		Deporte c4 = new Deporte(d4);
		c4.start();

		Deporte c5 = new Deporte(d5);
		c5.start();
	}
}