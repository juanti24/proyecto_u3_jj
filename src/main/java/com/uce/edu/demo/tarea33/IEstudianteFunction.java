package com.uce.edu.demo.tarea33;

@FunctionalInterface
public interface IEstudianteFunction<R,T> {
	
	public R aplicar(T arg1);

}