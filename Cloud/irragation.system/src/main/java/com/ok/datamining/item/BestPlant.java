package com.ok.datamining.item;

public class BestPlant extends BestItem {
	private Integer plantID;
	private Integer addressID;
	private Integer area;
	private Integer climateID;
	private Integer soilID;
	private Integer profitValue;

	public BestPlant( Integer addressID, Integer area,
			Integer climateID, Integer soilID, Integer profitValue,Integer plantID) {
		this.addressID=addressID;
		this.area=area;
		this.climateID=climateID;
		this.soilID=soilID;
		this.profitValue=profitValue;
		this.plantID=plantID;
	}

	public Integer getPlantID() {
		return plantID;
	}

	public void setPlantID(Integer plantID) {
		this.plantID = plantID;
	}

	public Integer getAddressID() {
		return addressID;
	}

	public void setAddressID(Integer addressID) {
		this.addressID = addressID;
	}

	public Integer getArea() {
		return area;
	}

	public void setArea(Integer area) {
		this.area = area;
	}

	public Integer getClimateID() {
		return climateID;
	}

	public void setClimateID(Integer climateID) {
		this.climateID = climateID;
	}

	public Integer getSoilID() {
		return soilID;
	}

	public void setSoilID(Integer soilID) {
		this.soilID = soilID;
	}

	public Integer getProfitValue() {
		return profitValue;
	}

	public void setProfitValue(Integer profitValue) {
		this.profitValue = profitValue;
	}
}
