package com.uce.edu.demo.service.funcional;

import org.jboss.logging.Logger;

public class MainInterfacesFuncionales {

	private static Logger LOG = Logger.getLogger(MainInterfacesFuncionales.class);

	public static void main(String[] args) {

		ConsumoMetodosHighOrder metodosHO = new ConsumoMetodosHighOrder();

		// SUPPLIER
		// Clases
		IPersonaSupplier<String> supplier = new PersonaSupplierImpl();
		LOG.info("Supplier Clase: " + supplier.getNombre());

		IPersonaSupplier<String> supplierTE = new PersonaSupplierImpl();
		LOG.info("Supplier Clase: " + supplierTE.getNombre());

		// Lambdas
		IPersonaSupplier<String> supplierLambda = () -> "Edison2";
		LOG.info("Supplier Lambdas: " + supplierLambda.getNombre());

		IPersonaSupplier<String> supplierLambdaTE = () -> "Daniel TE2";
		LOG.info("Supplier Lambdas: " + supplierLambdaTE.getNombre());

		// Metodos High Order
		String valorHO = metodosHO.consumirSupplier(() -> " Hola Mundo");
		LOG.info("HO Supplier" + valorHO);

		String valorHO1 = metodosHO.consumirSupplier(() -> {
			String valorConsultado = " 17128383";
			return valorConsultado;
		});
		LOG.info("HO Supplier" + valorHO1);

		// CONSUMER
		// Clases
		IPersonaConsumer<String> consumerClase = new PersonaConsumerImpl();
		consumerClase.accep("Prueba Consumer");

		// Lambdas
		IPersonaConsumer<String> consumerLambda = cadena -> System.out.println(cadena);
		consumerLambda.accep("Prueba Consumer Lambda");

		// Metodos High Order
		metodosHO.consumirComsummer(valor -> System.out.println(valor), 2);

		// PREDICATE
		// Clases

		// Lambdas
		IPersonaPredicate<String> predicateLambda = cadena -> cadena.contains("Z");
		LOG.info("Predicate Lambdas: " + predicateLambda.evaluar("Zoila"));

		// Metodos High Order
		boolean respuesta = metodosHO.consumirPredicate(cadena -> cadena.contains("Z"), "Zoila");
		LOG.info("HO Predicate" + respuesta);
		// FUNCTION
		// Clases

		// Lambdas

		IPersonaFunction<Integer, String> funtionLambda = cadena -> {
			Integer valor = Integer.parseInt(cadena);
			Integer valorFinal = valor - 2;
			return valorFinal;
		};

		// Metodos High Order
		String valorFinalHO = metodosHO.consumirFunction(valor -> {
			String retorno = valor.toString() + "A";
			return retorno;
		}, 1);
		LOG.info("HO Function: " + valorFinalHO);

		LOG.info("Predicate Lambdas: " + funtionLambda.aplicar("7"));

		// UNARY OPERATOR(FUNCTION)
		
		// Clases

		// Lambdas
		IPersonaUnaryOperator<String> unaryLambda = cadena -> {
			String valorFinal = cadena.concat("sufijo");
			return valorFinal;
		};

		LOG.info("Predicate Lambdas: " + unaryLambda.apply("Daniel"));

	}

}
