package com.uce.edu.demo.tarea33;

import org.jboss.logging.Logger;

public class MainInterfacesFuncionales {

	private static Logger LOG = Logger.getLogger(MainInterfacesFuncionales.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MetodosHighOrder metodosHO = new MetodosHighOrder();

		// SUPPLIER
		// Clases

		IEstudianteSupplier<String> supplierClase = new EstudianteSupplierImpl();
		LOG.info("Supplier Clase Tarea: " + supplierClase.getNombre());

		// Lambdas

		IEstudianteSupplier<String> supplierLambdas = () -> "Juan Andres";
		LOG.info("Supplier Lambda Tarea: " + supplierLambdas.getNombre());

		// Metodos High Order
		String valorHO = metodosHO.consumirSupplier(() -> "Probando Lambas");
		LOG.info("High Order Supplier Tarea" + valorHO);

		String valorHO1 = metodosHO.consumirSupplier(() -> {
			String valorConsultado = "32";
			String valorFinal = valorConsultado.concat("concatenando...");
			return valorFinal;
		});
		LOG.info("High Order Supplier Tarea" + valorHO1);

		// CONSUMER
		// Clases

		IEstudianteConsumer<String> consumerClase = new EstudianteConsumerImpl();
		consumerClase.accept("Consumer para la tarea");

		// Lambdas

		IEstudianteConsumer<String> consumerLamba = cadena -> System.out.println(cadena);
		consumerLamba.accept("Consumer para la tarea con Lambdas");

		// Metodos High Order
		metodosHO.consumirConsumer(valor -> System.out.println(valor), 23);

		// PREDICATE
		// Clases
		IEstudiantePredicate<String> predicateClase = new EstudiantePredicateImpl();
		boolean valorImprimir = predicateClase.evaluar("Juan");
		LOG.info("predicate Clase Tarea: " + valorImprimir);
		
		// Lambdas

		IEstudiantePredicate<String> predicateLamba = cadena -> cadena.contains("P");
		LOG.info("predicate Lamba Tarea: " + predicateLamba.evaluar("Juan"));

		// Metodos High Order
		boolean respuesta = metodosHO.consumirPredicate(cadena -> cadena.contains("P"), "Pedro");
		LOG.info("High Order predicate " + respuesta);
		
		// FUNCTION
		// Clases
		
		IEstudianteFunction<String, Integer> functionPredicate = new EstudianteFunctionImpl<>();
		String funcionImprimir = functionPredicate.aplicar(23);
		LOG.info("Function clase: el numero es: " + funcionImprimir);

		// Lambdas

		IEstudianteFunction<Integer, String> functionLambda = cadena -> {
			Integer valor = Integer.parseInt(cadena);
			Integer valorFinal = valor - 2;
			if (valorFinal < 23) {
				LOG.info("Function: Si cumple con la condicion");
				return valorFinal;
			} else {
				LOG.info("Function: No cumple con la condicion");
				return valorFinal + 30;
			}

		};

		LOG.info("Function Lamba: " + functionLambda.aplicar("7"));

		// Metodos High Order
		
		String valorFinalHO = metodosHO.consumirFunction(valor -> {
			String retorno = valor.toString() + "Ingresando datos en Function";
			return retorno;
		}, 1);
		LOG.info("High Order Function " + valorFinalHO);

		// UNARY OPERATOR
		
		// Clases
		
		IEstudianteFunctionUnaryOperator<String> functionUnaryOperator = new EstudianteFunctionUnaryOperatorImpl();
		String ValorPrueba = functionUnaryOperator.aplicar("Probando Unary Operator");
		LOG.info(ValorPrueba);

		// Lambdas

		IEstudianteFunctionUnaryOperator<String> unaryLambda = cadena -> {
			String valorFinal = cadena.concat("Pruebas de los lambdas");
			return valorFinal;
		};
		LOG.info("Unary Lamba: " + unaryLambda.aplicar("Juan"));

		// Metodos High Order
		String valorFinalHO1 = metodosHO.consumirFunction(valor -> {
			String retorno = valor.toString() + "Ingresando para Unary Operator";
			return retorno;
		}, 1);
		LOG.info("High Order function " + valorFinalHO1);
	}

}