package com.ok.jpa.controller;

import java.util.Collection;
import java.util.List;

import javax.json.Json;
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
import com.ok.model.Field;
import com.ok.model.User;

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
			CriteriaBuilder cb = entitymanager.getCriteriaBuilder();
			CriteriaQuery cq = cb.createQuery();
			Root e = cq.from(User.class);
			cq.where(cb.equal(e.get("userName"), userName),
					cb.equal(e.get("password"), password));
			Query query = entitymanager.createQuery(cq);
			List<User> results = query.getResultList();
			System.out.println("Request Name: " + userName);
			System.out.println("Request Password: " + password);
			if (!results.isEmpty() && results.get(0).getUserID() > 0) {
				innerObject.addProperty("Result", results.get(0).getUserID());
				return getNoCacheResponseBuilder(Response.Status.CREATED)
						.entity(innerObject.toString()).build();

			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception : " + e.getMessage());
		}
		innerObject.addProperty("result", "not found");
		return getNoCacheResponseBuilder(Response.Status.FORBIDDEN).entity(
				innerObject.toString()).build();
	}

	@SuppressWarnings("unchecked")
	public Response getUserFieldList(String userName, String password)  {
		JsonObject innerObject = new JsonObject();
		try {
			List<Field> list = (List<Field>) entitymanager
					.createQuery(
							"SELECT f FROM Field AS f WHERE f.fieldID IN "
									+ "(SELECT uf.id.fieldID FROM Userfield AS uf, uf.id AS ufpk WHERE ufpk.userID IN "
									+ "( SELECT u.userID FROM User AS u WHERE u.userName = :userName "
									+ "AND u.password = :password  ))")
					.setParameter("userName", userName)
					.setParameter("password", password).getResultList();
			String resultJson = gson.toJson(list);
			return getNoCacheResponseBuilder(Response.Status.CREATED).entity(
					resultJson.toString()).build();

		} catch (Exception e) {
			// TODO: handle exception
		}
		innerObject.addProperty("result", "not found");
		return getNoCacheResponseBuilder(Response.Status.FORBIDDEN).entity(
				innerObject.toString()).build();
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
