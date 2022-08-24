package com.uce.edu.demo.service.funcional;

public class ConsumoMetodosHighOrder {

	public String consumirSupplier(IPersonaSupplier<String> funcion) {
		// String valor = funcion.getNombre();
		// Calcular/sumar/consultar base
		// Integer numero = Integer.parseInt(valor);
		// return numero;
		return funcion.getNombre() + " Se proceso el dato";
	}

	public void consumirComsummer(IPersonaConsumer<Integer> funcion, Integer valor) {
		funcion.accep(valor);
	}

	public boolean consumirPredicate(IPersonaPredicate<String> funcion, String valor) {
		return funcion.evaluar(valor);
	}

	public String consumirFunction(IPersonaFunction<String, Integer> funcion, Integer valor) {

		return funcion.aplicar(valor);
	}

}
