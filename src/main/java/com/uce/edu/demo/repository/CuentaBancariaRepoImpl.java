package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.CuentaBancaria;

@Repository
@Transactional
public class CuentaBancariaRepoImpl implements ICuentaBancariaRepo{

	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public void actualizar(CuentaBancaria cta) {
		this.entityManager.merge(cta);
		
	}


	@Override
	public CuentaBancaria buscarPorNumero(String numero) {
		TypedQuery<CuentaBancaria> miTypedQuery = this.entityManager
				.createQuery("SELECT c FROM CuentaBancaria c WHERE c.numero = :datoNumero", CuentaBancaria.class);
		miTypedQuery.setParameter("datoNumero", numero);
		return miTypedQuery.getSingleResult();
	}

}
