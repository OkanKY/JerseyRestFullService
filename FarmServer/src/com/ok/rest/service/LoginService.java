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

	@POST
	@Path("login")
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(@Context HttpHeaders httpHeaders,
			@FormParam("user_name") String user_name, @FormParam("password") String password) {
		// TODO Auto-generated method stub

		DataBaseController controller = new DataBaseController();
		controller.connectDataBase();
		return controller.checkUserLogin(user_name, password);
	}

	@POST
	@Path("create")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createUser(@Context HttpHeaders httpHeaders,
			@FormParam("user_name") String username,
			@FormParam("password") String password) {
		// TODO Auto-generated method stub

		DataBaseController controller = new DataBaseController();
		controller.connectDataBase();
		return controller.createUser(username, password);
	}

	@POST
	@Path("logout")
	public Response logout() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@POST
	@Path("getFieldInformation")
	public Response getFieldInformationList(@WebParam(name = "FieldID") Integer FieldID ){
		// TODO Auto-generated method stub
		DataBaseController controller = new DataBaseController();
		controller.connectDataBase();
		return null;
	}
}
