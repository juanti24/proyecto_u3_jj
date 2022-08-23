package com.uce.edu.demo.service.funcional;

import org.jboss.logging.Logger;

public class MainInterfacesFuncionales {

	
	private static Logger LOG = Logger.getLogger(MainInterfacesFuncionales.class);
	
	
	public static void main(String[] args) {
	
	//SUPPLIER
	//Clases
	IPersonaSupplier<String> supplier = new PersonaSupplierImpl();
	LOG.info("Supplier Clase: " + supplier.getNombre());
	
	IPersonaSupplier<String> supplierTE = new PersonaSupplierImpl();
	LOG.info("Supplier Clase: " + supplierTE.getNombre());
	
	//Lambdas
	IPersonaSupplier<String> supplierLambda = () -> "Edison2";
	LOG.info("Supplier Lambdas: " + supplierLambda.getNombre());
	
	IPersonaSupplier<String> supplierLambdaTE = () -> "Daniel TE2";
	LOG.info("Supplier Lambdas: " + supplierLambdaTE.getNombre());
	
	
	//CONSUMER
	//Clases
	IPersonaConsumer<String> consumerClase = new PersonaConsumerImpl();
	consumerClase.accep("Prueba Consumer");
	
	//Lambdas
	IPersonaConsumer<String> consumerLambda = cadena -> System.out.println(cadena);
	consumerLambda.accep("Prueba Consumer Lambda");
	
	
	//PREDICATE
	//Clases
	
	//Lambdas
	
	//FUNCTION
	//Clases
	
	//Lambdas
	
	//UNARY OPERATOR(FUNCTION)
	//Clases
	
	//Lambdas
}
	
}
