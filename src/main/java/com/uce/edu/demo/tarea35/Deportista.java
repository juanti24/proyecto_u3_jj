package com.uce.edu.demo.tarea35;

public class Deportista {
	
	private String nombre;
	private String gamerTag;

	public Deportista(String nombre, String gamerTag) {
		this.nombre = nombre;
		this.gamerTag = gamerTag;
	}

	// GET & SET
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGamerTag() {
		return gamerTag;
	}

	public void setGamerTag(String gamerTag) {
		this.gamerTag = gamerTag;
	}

}


