package com.uce.edu.demo.tarea33;

public class EstudianteFunctionUnaryOperatorImpl implements IEstudianteFunctionUnaryOperator<String>{

	@Override
	public String aplicar(String arg1) {
		// TODO Auto-generated method stub
		String cadenaFinal= arg1.concat(" Prueba completada");
		
		return cadenaFinal;
	}

}