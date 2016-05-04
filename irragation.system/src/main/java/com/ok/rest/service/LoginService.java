package com.ok.rest.service;

import javax.ejb.Local;
import javax.ws.rs.FormParam;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ok.datamining.item.BestPlant;
import com.ok.jpa.controller.JpaController;

@Local
@Path("user")
public class LoginService {

	//private DataBaseController controller = null;

	public LoginService() {
//		controller = new DataBaseController();
//		controller.connectDataBase();
	}
	@POST
	@Path("login")
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(@Context HttpHeaders httpHeaders,@FormParam("userName") String userName,
		@FormParam("password") String password) {
		// TODO Auto-generated method stub
		Response res=null;
		try {

		JpaController controller = new JpaController();
		res=controller.checkUserLogin(userName,password);
		
		} catch (Exception e) {
		// TODO: handle exception
		}
		return res;
	}
	//getUserFieldList
	@POST
	@Path("getUserFieldList")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserFieldList(@Context HttpHeaders httpHeaders,@FormParam("userName") String userName,
		@FormParam("password") String password) {
		// TODO Auto-generated method stub
		Response res=null;
		try {

		JpaController controller = new JpaController();
		res=controller.getUserFieldList(userName,password);
		
		} catch (Exception e) {
		// TODO: handle exception
		}
		return res;
	}
	//getBestPlant
	@POST
	@Path("getBestPlant")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBestPlant(@Context HttpHeaders httpHeaders,@FormParam("userName") String userName,
		@FormParam("password") String password,@HeaderParam("BestPlant") final BestPlant bestPlant) {
		// TODO Auto-generated method stub
		Response res=null;
		try {
		JpaController controller = new JpaController();
		res=controller.getBestPlant(userName,password,bestPlant);
		
		} catch (Exception e) {
		// TODO: handle exception
		}
		return res;
	}

	@POST
	@Path("logout")
	public Response logout() {
		// TODO Auto-generated method stub
		return null;
	}

}
