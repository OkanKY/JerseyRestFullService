package com.ok.jpa.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaInstanceCountController {

	private EntityManagerFactory emfactory;
	private EntityManager entitymanager;
	private final String jpaName = "irragation.system";

	public JpaInstanceCountController() {
		// TODO Auto-generated constructor stub
		emfactory = Persistence.createEntityManagerFactory(jpaName);
		entitymanager = emfactory.createEntityManager();
	}

	@SuppressWarnings("unchecked")
	public Long getPlantInstanceCount() throws Exception
	{
		Long result=null;
		try {
			List<Long> list = (List<Long>) entitymanager
					.createQuery(
							"SELECT COUNT(p.plantID) FROM Plant AS p ").getResultList();
			result=list.get(0);
		} catch (Exception e) {
			// TODO: handle exception
			throw(e);
		}
		return result;
	}
}
