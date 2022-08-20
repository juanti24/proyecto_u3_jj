package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Hotel;

public interface IHotelRepo {

	public List<Hotel> buscarHotelInnerJoin(String tipoHabitacion);

	public List<Hotel> buscarHotelInnerJoin();

	public List<Hotel> buscarHotelOuterJoinRight(String tipoHabitacion);
	
	public List<Hotel> buscarHotelOuterJoinRight();

	public List<Hotel> buscarHotelOuterJoinLeft(String tipoHabitacion);

	public List<Hotel> buscarHotelOuterJoinLeft();

	public List<Hotel> buscarHotelJoinWhere(String tipoHabitacion);

	public List<Hotel> buscarHotelJoinFetch(String tipoHabitacion);
	
	public Hotel buscar(Integer id);

    public List<Hotel> buscarTodos();

    public void eliminar(Integer id);

    public Hotel insertar(Hotel hotel);

    public Hotel actualizar(Hotel hotel);

}
