package com.ok.attiribute;

import org.json.simple.JSONAware;
import org.json.simple.JSONObject;

public class FieldInformation  implements JSONAware{

	private String DateInformation = null;
	private Integer Humidity = null;
	private Integer Temperature = null;

	public String getDateInformation() {
		return DateInformation;
	}

	public void setDateInformation(String DateInformation) {
		this.DateInformation = DateInformation;
	}

	public Integer getHumidity() {
		return Humidity;
	}

	public void setHumidity(Integer humidity) {
		Humidity = humidity;
	}

	public Integer getTemperature() {
		return Temperature;
	}

	public void setTemperature(Integer Temperature) {
		this.Temperature = Temperature;
	}

	public String toJSONString() {
		StringBuffer sb = new StringBuffer();

		sb.append("{");

		sb.append(JSONObject.escape("DateInformation"));
		sb.append(":");
		sb.append("\"" + JSONObject.escape(DateInformation) + "\"");

		sb.append(",");

		sb.append(JSONObject.escape("Humidity"));
		sb.append(":");
		sb.append(Humidity);
		sb.append(",");

		sb.append(JSONObject.escape("Temperature"));
		sb.append(":");
		sb.append(Temperature);

		sb.append("}");

		return sb.toString();
	}
}
