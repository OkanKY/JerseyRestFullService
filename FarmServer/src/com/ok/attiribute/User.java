package com.ok.attiribute;

import org.json.simple.JSONObject;

public class User {
	private String UserName = null;
	private String Password = null;

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	public String toJSONString() {
		StringBuffer sb = new StringBuffer();

		sb.append("{");

		sb.append(JSONObject.escape("UserName"));
		sb.append(":");
        sb.append("\"" + JSONObject.escape(UserName) + "\"");
		sb.append(",");

		sb.append(JSONObject.escape("Password"));
		sb.append(":");
        sb.append("\"" + JSONObject.escape(Password) + "\"");

		sb.append("}");

		return sb.toString();
	}
}
