package com.uce.edu.demo.tarea34;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.jboss.logging.Logger;


public class MainTareaStream {
	
	private static Logger LOG = Logger.getLogger(MainTareaStream.class);

	public static void main(String[] args) {

		// Supplier
		LOG.info("SUPPLIER: genera un arreglo de 5 elementos con el mismo string.");
		Stream<String> listaJuegos = Stream.generate(() -> "MMA").limit(5);

		// Consumer
		LOG.info("CONSUMER: imprime el arreglo creado anteriormente.");
		listaJuegos.forEach(str -> LOG.info("Deporte: " + str));

		// Predicate
		LOG.info("PREDICATE: filtra unicamente los deportes que en su nombre contenga la letra 's'");
		List<String> listaJ = Arrays.asList("Tennis", "Futbol", "MMA", "Beisbol");
		Stream<String> listaFiltro = listaJ.stream().filter(str -> str.contains("s"));
		listaFiltro.forEach(juego -> LOG.info("Filtro: " + juego));

		// Function
		LOG.info("FUNCTION: mapea los nombres de los deportes a un String pero con mayusculas");
		listaJ.stream().map(juego -> juego.toUpperCase()).forEach(juego -> LOG.info("Mapeo: " + juego));

	}

}