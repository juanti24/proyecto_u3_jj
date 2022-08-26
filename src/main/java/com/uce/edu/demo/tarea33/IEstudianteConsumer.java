package com.uce.edu.demo.tarea33;

@FunctionalInterface
public interface IEstudianteConsumer<T> {
	
	public void accept(T arg1);

}