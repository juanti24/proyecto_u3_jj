package com.uce.edu.demo.service.funcional;

@FunctionalInterface
public interface IPersonaSupplier<T> {
	
	//T es un dato generico
	public  T getNombre();
}
