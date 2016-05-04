package com.ok.jpa.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.ok.datamining.BaseFactoryDataMining;
import com.ok.datamining.item.BestPlant;
import com.ok.irragation.model.Field;
import com.ok.irragation.model.User;

public class JpaController {
	private EntityManagerFactory emfactory;
	private EntityManager entitymanager;
	private final String jpaName = "irragation.system";
	private Gson gson;

	public JpaController() {
		// TODO Auto-generated constructor stub
		emfactory = Persistence.createEntityManagerFactory(jpaName);
		entitymanager = emfactory.createEntityManager();
		gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
				.create();
	}

	@SuppressWarnings("unchecked")
	public Response checkUserLogin(String userName, String password) {
		JsonObject innerObject = new JsonObject();
		try {

			List<User> results = userCheck(userName, password);
			if (!results.isEmpty() && results.get(0).getUserID() > 0) {
				innerObject.addProperty("result", results.get(0).getUserID());
				return getNoCacheResponseBuilder(Response.Status.CREATED)
						.entity(innerObject.toString()).build();

			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception : " + e.getMessage());
		}
		innerObject.addProperty("result", -1);
		return getNoCacheResponseBuilder(Response.Status.FORBIDDEN).entity(
				innerObject.toString()).build();
	}

	@SuppressWarnings("unchecked")
	public Response getUserFieldList(String userName, String password) {
		JsonObject innerObject = new JsonObject();
		try {
			List<Field> list = (List<Field>) entitymanager
					.createQuery(
							"SELECT f FROM Field AS f WHERE f.userID IN "
									+ "( SELECT u.userID FROM User AS u WHERE u.userName = :userName "
									+ "AND u.password = :password  )")
					.setParameter("userName", userName)
					.setParameter("password", password).getResultList();
			String resultJson = gson.toJson(list);
			return getNoCacheResponseBuilder(Response.Status.CREATED).entity(
					resultJson.toString()).build();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		innerObject.addProperty("result", "not found");
		return getNoCacheResponseBuilder(Response.Status.FORBIDDEN).entity(
				innerObject.toString()).build();
	}

	@SuppressWarnings("unchecked")
	public Response getBestPlant(String userName, String password,
			BestPlant bestPlant) {
		// TODO Auto-generated method stub
		JsonObject innerObject = new JsonObject();
		Double result = null;
		try {
			List<User> results = userCheck(userName, password);
			if (!results.isEmpty() && results.get(0).getUserID() > 0) {
				result = getbestPlant(bestPlant);
				innerObject.addProperty("result", result);
				return getNoCacheResponseBuilder(Response.Status.CREATED)
						.entity(innerObject.toString()).build();

			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception : " + e.getMessage());
		}
		innerObject.addProperty("result", -1);
		return getNoCacheResponseBuilder(Response.Status.FORBIDDEN).entity(
				innerObject.toString()).build();
	}

	@SuppressWarnings("unchecked")
	private List<User> userCheck(String userName, String password) {
		List<User> results = null;
		try {

			results = (List<User>) entitymanager
					.createQuery(
							"SELECT u FROM User AS u WHERE u.userName = :userName "
									+ "AND u.password = :password ")
					.setParameter("userName", userName)
					.setParameter("password", password).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return results;
	}

	private Double getbestPlant(BestPlant bestPlant) {
		Double result = null;
		BaseFactoryDataMining baseFactoryDataMining = new BaseFactoryDataMining();
		result = baseFactoryDataMining.getBestPlant(bestPlant);
		return result;
	}

	private Response.ResponseBuilder getNoCacheResponseBuilder(
			Response.Status status) {
		CacheControl cc = new CacheControl();
		cc.setNoCache(true);
		cc.setMaxAge(-1);
		cc.setMustRevalidate(true);

		return Response.status(status).cacheControl(cc);
	}

}
