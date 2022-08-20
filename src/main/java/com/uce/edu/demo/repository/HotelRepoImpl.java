package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.reactive.TransactionSynchronizationManager;

import com.uce.edu.demo.repository.modelo.Hotel;

@Repository
@Transactional
public class HotelRepoImpl implements IHotelRepo {

	private static Logger LOG = Logger.getLogger(HotelRepoImpl.class);

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
	// @Transactional(value = TxType.MANDATORY)
	public List<Hotel> buscarHotelJoinFetch(String tipoHabitacion) {
		LOG.info("Transaccion activa repository: "
				+ org.springframework.transaction.support.TransactionSynchronizationManager
						.isActualTransactionActive());
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

	@Override
	public List<Hotel> buscarHotelOuterJoinRight() {
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h RIGHT JOIN h.habitaciones ha",
				Hotel.class);
		return myQuery.getResultList();

	}

	@Override
	public Hotel buscar(Integer id) {
		return this.entityManager.find(Hotel.class, id);
	}

	@Override
	public List<Hotel> buscarTodos() {
		TypedQuery<Hotel> myTypedQuery = (TypedQuery<Hotel>) this.entityManager.createQuery("SELECT f FROM Hotel f    ",
				Hotel.class);
		return myTypedQuery.getResultList();

	}

	@Override
	public Hotel actualizar(Hotel hote) {
		this.entityManager.merge(hote);
		return hote;

	}

	@Override
	public void eliminar(Integer id) {
		Hotel gBorrar = this.buscar(id);
		this.entityManager.remove(gBorrar);

	}

	@Override
	public Hotel insertar(Hotel hote) {
		this.entityManager.persist(hote);
		return hote;
	}

}
