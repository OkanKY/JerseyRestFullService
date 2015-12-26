package com.ok.attiribute;

import org.json.simple.JSONObject;

public class Information {
	private Integer Humidity = null;
	private Integer Temperature = null;

	public Integer getHumidity() {
		return Humidity;
	}

	public void setHumidity(Integer humidity) {
		Humidity = humidity;
	}

	public Integer getTemperature() {
		return Temperature;
	}

	public void setTemperature(Integer temperature) {
		this.Temperature = temperature;
	}

	@Override
	public String toString() {
		return "Humidity " + this.Humidity + " temperature" + this.Temperature;
	}

	public String toJSONString() {
		StringBuffer sb = new StringBuffer();

		sb.append("{");

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
