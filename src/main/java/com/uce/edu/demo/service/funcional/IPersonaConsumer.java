package com.uce.edu.demo.service.funcional;

@FunctionalInterface
public interface IPersonaConsumer<T> {
	
	public void accep(T arg1);

}
