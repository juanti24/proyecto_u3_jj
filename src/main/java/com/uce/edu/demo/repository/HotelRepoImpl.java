package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Hotel;

@Repository
@Transactional
public class HotelRepoImpl implements IHotelRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Hotel> buscarHotelInnerJoin(String tipoHabitacion) {
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery(
				"SELECT h FROM Hotel h JOIN h.habitaciones ha WHERE ha.tipo = :datoTipoHabitacion", Hotel.class);
		myQuery.setParameter("datoTipoHabitacion", tipoHabitacion);
		List<Hotel> hoteles = myQuery.getResultList();
		for (Hotel h : hoteles) {
			h.getHabitaciones().size();
		}
		return myQuery.getResultList();
	}

	public List<Hotel> buscarHotelInnerJoin2(String tipoHabitacion) {
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery(
				"SELECT h FROM Hotel h JOIN h.habitaciones ha WHERE ha.tipo = :datoTipoHabitacion", Hotel.class);
		myQuery.setParameter("datoTipoHabitacion", tipoHabitacion);

		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> buscarHotelOuterJoinRight(String tipoHabitacion) {
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery(
				"SELECT h FROM Hotel h RIGHT JOIN h.habitaciones ha WHERE ha.tipo = :datoTipoHabitacion", Hotel.class);
		myQuery.setParameter("datoTipoHabitacion", tipoHabitacion);

		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> buscarHotelOuterJoinLeft(String tipoHabitacion) {
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery(
				"SELECT h FROM Hotel h LEFT JOIN h.habitaciones ha WHERE ha.tipo = :datoTipoHabitacion", Hotel.class);
		myQuery.setParameter("datoTipoHabitacion", tipoHabitacion);

		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> buscarHotelJoinWhere(String tipoHabitacion) {
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery(
				"SELECT h FROM Hotel h, Habitacion ha WHERE h = ha.hotel  AND ha.tipo =:datoTipoHabitacion",
				Hotel.class);
		myQuery.setParameter("datoTipoHabitacion", tipoHabitacion);
		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> buscarHotelJoinFetch(String tipoHabitacion) {
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery(
				"SELECT h FROM Hotel h JOIN FETCH h.habitaciones ha WHERE ha.tipo = :datoTipoHabitacion", Hotel.class);
		myQuery.setParameter("datoTipoHabitacion", tipoHabitacion);

		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> buscarHotelInnerJoin() {
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h JOIN h.habitaciones ha ",
				Hotel.class);

		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> buscarHotelOuterJoinLeft() {
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h LEFT JOIN h.habitaciones ha ",
				Hotel.class);

		return myQuery.getResultList();
	}

}
