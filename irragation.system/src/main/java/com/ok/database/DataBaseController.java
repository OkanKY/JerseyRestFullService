 package com.ok.database;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Response;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

//import com.ok.attiribute.FieldInformation;
//import com.ok.attiribute.UserField;
import com.ok.database.DataBaseManager.DatabaseType;

public class DataBaseController {
	private DataBaseManager dataManager;

	public DataBaseController() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void connectDataBase() {
		dataManager = new DataBaseManager();
		dataManager.setDatabaseType(DatabaseType.MySQL);
		dataManager.setServer("localhost");
		dataManager.setPointConnection("3306");
		dataManager.setDatabase("irrigation");
		dataManager.setUser("root");
		dataManager.setPassword("okan");
	}

	private ResultSet setQuery(String query) {
		ResultSet resultSet = null;
		try {
			resultSet = dataManager.query(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
	}

	private Boolean updateQuery(String query) {
		boolean result = false;
		try {
			if (dataManager.update(query) == 1)
				result = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			result = false;
		}
		return result;
	}

	public Response checkUserLogin(String user_name, String password) {
		String query = null;
		query = "SELECT UserID FROM USER WHERE UserName='" + user_name
				+ "' AND Password='" + password + "';";
		query ="SELECT UserID FROM USER WHERE UserName='okan' AND Password='1234'";
		ResultSet result = setQuery(query);
		String restulData = "";
		try {
			while(result.next())
			{
			restulData = result.getString("UserName");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
//		if (restulData.equals(user_name)) {
//			jsonObjBuilder.add("message", "" + user_name);
//			JsonObject jsonObj = jsonObjBuilder.build();
//
//			return getNoCacheResponseBuilder(Response.Status.ACCEPTED).entity(
//					jsonObj.toString()).build();
//		} else {
//			jsonObjBuilder.add("message", "Problem name:" + user_name
//					+ "or password:" + password);
//			JsonObject jsonObj = jsonObjBuilder.build();
//
//			return getNoCacheResponseBuilder(Response.Status.UNAUTHORIZED)
//					.entity(jsonObj.toString()).build();
//		}
		return getNoCacheResponseBuilder(Response.Status.FORBIDDEN).entity(
				"test").build();

	}

	public Response createUser(String username, String password) {
		String query = null;
		query = "INSERT INTO USER (UserName,Password) VALUES (" + "'"
				+ username + "','" + password + "');";
		// return updateQuery(query);
//		JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
//		if (updateQuery(query)) {
//			jsonObjBuilder.add("Created", "" + username);
//			JsonObject jsonObj = jsonObjBuilder.build();
//
//			return getNoCacheResponseBuilder(Response.Status.CREATED).entity(
//					jsonObj.toString()).build();
//		} else {
//			jsonObjBuilder.add("message", "Not Created:" + username + " ");
//			JsonObject jsonObj = jsonObjBuilder.build();
//
//			return getNoCacheResponseBuilder(Response.Status.FORBIDDEN).entity(
//					jsonObj.toString()).build();
//		}
		return getNoCacheResponseBuilder(Response.Status.FORBIDDEN).entity(
			"test").build();
	}

	@SuppressWarnings("unchecked")
	public Response getFieldInformationList(Integer FieldID) {

		ResultSet resultSet = null;
		JSONObject rootObject = new JSONObject();
		JSONArray fieldList = new JSONArray();
		try {

			resultSet = setQuery(" SELECT FI.DateInformation,FI.humidity,FI.temperature FROM FIELDINFORMATION AS FI WHERE FI.FieldID='"
					+ FieldID + "'; ");

			while (resultSet.next()) {

//				FieldInformation field = null;
//
//				field = new FieldInformation();
//				field.setDateInformation(resultSet.getString("DateInformation"));
//				field.setHumidity(resultSet.getInt("humidity"));
//				field.setTemperature(resultSet.getInt("temperature"));
//
//				fieldList.add(field.toJSONString());

			}
			rootObject.put("FieldInformationList", fieldList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		return getNoCacheResponseBuilder(Response.Status.GONE).entity(
				rootObject.toString()).build();

	}

	@SuppressWarnings("unchecked")
	public Response getUserFieldList(String userName, String password) {
		// TODO Auto-generated method stub
		ResultSet resultSet = null;
		JSONObject rootObject = new JSONObject();
		JSONArray fieldList = new JSONArray();
		try {

			resultSet = setQuery("SELECT F.FieldName,F.FieldID FROM FIELD AS F WHERE F.FieldID IN "
					+ " (SELECT L.FieldID FROM LOGINFIELD AS L  WHERE L.UserName IN "
					+ " ( SELECT U.UserName FROM USERLOGIN AS U WHERE U.UserName ='"
					+ userName
					+ "' AND U.Password='"
					+ password
					+ "' AND U.Status=1) ); ");

			while (resultSet.next()) {
//
//				UserField field = null;
//				
//				field = new UserField();
//				field.setFieldName(resultSet.getString("FieldName"));
//				field.setFieldID(resultSet.getInt("FieldID"));
//				fieldList.add(field.toJSONString());

			}
			rootObject.put("UserFieldList", fieldList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		return getNoCacheResponseBuilder(Response.Status.GONE).entity(
				rootObject.toString()).build();
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
