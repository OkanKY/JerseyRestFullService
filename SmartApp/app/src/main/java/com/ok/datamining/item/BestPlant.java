package com.ok.datamining.item;

/**
 * Created by Okan on 31.3.2016.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.ok.item.Item;

public class BestPlant extends Item{

    @SerializedName("plantID")
    @Expose
    private Integer plantID;
    @SerializedName("addressID")
    @Expose
    private Integer addressID;
    @SerializedName("area")
    @Expose
    private Integer area;
    @SerializedName("climateID")
    @Expose
    private Integer climateID;
    @SerializedName("soilID")
    @Expose
    private Integer soilID;
    @SerializedName("profitValue")
    @Expose
    private Integer profitValue;

    /**
     *
     * @return
     * The plantID
     */
    public Integer getPlantID() {
        return plantID;
    }

    /**
     *
     * @param plantID
     * The plantID
     */
    public void setPlantID(Integer plantID) {
        this.plantID = plantID;
    }

    /**
     *
     * @return
     * The addressID
     */
    public Integer getAddressID() {
        return addressID;
    }

    /**
     *
     * @param addressID
     * The addressID
     */
    public void setAddressID(Integer addressID) {
        this.addressID = addressID;
    }

    /**
     *
     * @return
     * The area
     */
    public Integer getArea() {
        return area;
    }

    /**
     *
     * @param area
     * The area
     */
    public void setArea(Integer area) {
        this.area = area;
    }

    /**
     *
     * @return
     * The climateID
     */
    public Integer getClimateID() {
        return climateID;
    }

    /**
     *
     * @param climateID
     * The climateID
     */
    public void setClimateID(Integer climateID) {
        this.climateID = climateID;
    }

    /**
     *
     * @return
     * The soilID
     */
    public Integer getSoilID() {
        return soilID;
    }

    /**
     *
     * @param soilID
     * The soilID
     */
    public void setSoilID(Integer soilID) {
        this.soilID = soilID;
    }

    /**
     *
     * @return
     * The profitValue
     */
    public Integer getProfitValue() {
        return profitValue;
    }

    /**
     *
     * @param profitValue
     * The profitValue
     */
    public void setProfitValue(Integer profitValue) {
        this.profitValue = profitValue;
    }

}