package com.ok.rest.service;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ejb.Local;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.jws.WebParam;
import javax.security.auth.login.LoginException;

import com.ok.database.DataBaseController;

@Local
@Path("user")
public class LoginService {

	private DataBaseController controller = null;

	public LoginService() {
		controller = new DataBaseController();
		controller.connectDataBase();
	}

	@POST
	@Path("login")
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(@Context HttpHeaders httpHeaders,
			@FormParam("user_name") String user_name,
			@FormParam("password") String password) {
		// TODO Auto-generated method stub

		return controller.checkUserLogin(user_name, password);
	}

	@POST
	@Path("create")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createUser(@Context HttpHeaders httpHeaders,
			@FormParam("user_name") String username,
			@FormParam("password") String password) {
		// TODO Auto-generated method stub

		return controller.createUser(username, password);
	}

	@POST
	@Path("getFieldInformationList")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getFieldInformationList(
			@FormParam("FieldID") Integer fieldID) {
		return controller.getFieldInformationList(fieldID);
	}

	@POST
	@Path("getUserFieldList")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserFieldList(@FormParam("UserName") String UserName,@FormParam("Password")String Password ) {
		return controller.getUserFieldList(UserName,Password);
	}
	@POST
	@Path("setWatering")
	@Produces(MediaType.APPLICATION_JSON)
	public Boolean setWatering(@WebParam(name = "FieldID") Integer FieldID,@WebParam(name = "Time") Integer Time)
	{
		
		return false;
	}
	@POST
	@Path("getCurrentInformation")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCurrentInformation(@WebParam(name = "FieldID") Integer FieldID ){
		return null;
	}

	@POST
	@Path("logout")
	public Response logout() {
		// TODO Auto-generated method stub
		return null;
	}

}
