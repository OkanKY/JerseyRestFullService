package com.ok.rest.service;

import javax.ejb.Local;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ok.database.DataBaseController;
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
//	@POST
//	@Path("login")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response login(@Context HttpHeaders httpHeaders,
//			@FormParam("user_name") String user_name,
//			@FormParam("password") String password) {
//		// TODO Auto-generated method stub
//		controller.connectDataBase();
//		return controller.checkUserLogin(user_name, password);
//	}
//
//	@POST
//	@Path("create")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response createUser(@Context HttpHeaders httpHeaders,
//			@FormParam("user_name") String username,
//			@FormParam("password") String password) {
//		// TODO Auto-generated method stub
//		controller.connectDataBase();
//		return controller.createUser(username, password);
//	}
//
//	@POST
//	@Path("getFieldInformationList")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response getFieldInformationList(
//			@FormParam("FieldID") Integer fieldID) {
//		controller.connectDataBase();
//		return controller.getFieldInformationList(fieldID);
//	}
//
//	@POST
//	@Path("getUserFieldList")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response getUserFieldList(@FormParam("UserName") String UserName,@FormParam("Password")String Password ) {
//		DataBaseController controller = new DataBaseController();
//		controller.connectDataBase();
//		return controller.getUserFieldList(UserName,Password);
//	}
//	@POST
//	@Path("setWatering")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response setWatering(@FormParam("FieldID") Integer FieldID,@FormParam("Time") Integer Time)
//	{
//		
//		return null;
//	}
//	@POST
//	@Path("getCurrentInformation")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response getCurrentInformation(@FormParam("FieldID") Integer FieldID ){
//		return null;
//	}

	@POST
	@Path("logout")
	public Response logout() {
		// TODO Auto-generated method stub
		return null;
	}

}
