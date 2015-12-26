package com.ok.attiribute;

import org.json.simple.JSONObject;

public class UserField {
	private String FieldName =null;
	private Integer FieldID =null;
	public String getFieldName() {
		return FieldName;
	}
	public void setFieldName(String fieldName) {
		FieldName = fieldName;
	}
	public Integer getFieldID() {
		return FieldID;
	}
	public void setFieldID(Integer fieldID) {
		FieldID = fieldID;
	}
	public String toJSONString() {
		StringBuffer sb = new StringBuffer();

		sb.append("{");

		sb.append(JSONObject.escape("FieldName"));
		sb.append(":");
        sb.append("\"" + JSONObject.escape(FieldName) + "\"");
		sb.append(",");

		sb.append(JSONObject.escape("FieldID"));
		sb.append(":");
        sb.append(FieldID);

		sb.append("}");

		return sb.toString();
	}
	
}
