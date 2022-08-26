package com.uce.edu.demo.tarea33;

@FunctionalInterface
public interface IEstudiantePredicate<T> {
	
	public boolean evaluar(T arg1);

}