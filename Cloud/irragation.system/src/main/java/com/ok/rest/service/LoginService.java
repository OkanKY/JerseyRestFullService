package com.ok.rest.service;

import javax.ejb.Local;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
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

	private JpaController controller;
	public LoginService() {
		controller= new JpaController();
	}
	@GET 
	@Path("test")
	@Produces(MediaType.APPLICATION_JSON)
	public String test()
	{
		return "Test";
	}
//	
	@POST
	@Path("login")
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(@Context HttpHeaders httpHeaders,@FormParam("userName") String userName,
		@FormParam("password") String password) {
		// TODO Auto-generated method stub
		return controller.checkUserLogin(userName,password);
	}
	//getUserFieldList
	@POST
	@Path("getUserFieldList")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserFieldList(@Context HttpHeaders httpHeaders,@FormParam("userName") String userName,
		@FormParam("password") String password) {
		// TODO Auto-generated method stub
		return controller.getUserFieldList(userName,password);
	}
	//getBestPlant
	@POST
	@Path("getBestPlant")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBestPlant(@Context HttpHeaders httpHeaders,@FormParam("userName") String userName,
		@FormParam("password") String password,@FormParam("addressID") Integer addressID,@FormParam("area") Integer area,
		@FormParam("climateID") Integer climateID, @FormParam("soilID") Integer soilID,
		@FormParam("profitValue") Integer profitValue,@FormParam("plantID") Integer plantID) {
		// TODO Auto-generated method stub
		
		BestPlant bestPlant= new BestPlant(addressID, area, climateID, soilID, profitValue, plantID);;
		return controller.getBestPlant(userName,password,bestPlant);

	}
	//getFieldData
	@POST
	@Path("getFieldData")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserFieldList(@Context HttpHeaders httpHeaders,@FormParam("userName") String userName,
		@FormParam("password") String password,@FormParam("plantID") Integer plantID) {
		// TODO Auto-generated method stub
		return controller.getUserFieldList(userName,password);
	}

	@POST
	@Path("logout")
	public Response logout() {
		// TODO Auto-generated method stub
		return null;
	}

}
