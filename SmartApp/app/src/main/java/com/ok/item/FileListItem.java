package com.ok.item;

/**
 * Created by Okan on 23.3.2016.
 */

import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FileListItem {

    @SerializedName("fieldID")
    @Expose
    private Integer fieldID;
    @SerializedName("area")
    @Expose
    private String area;
    @SerializedName("centerLatitude")
    @Expose
    private String centerLatitude;
    @SerializedName("centerLongitude")
    @Expose
    private String centerLongitude;
    @SerializedName("fieldInfo")
    @Expose
    private String fieldInfo;
    @SerializedName("fieldName")
    @Expose
    private String fieldName;
    @SerializedName("fieldUrl")
    @Expose
    private String fieldUrl;

    /**
     *
     * @return
     * The fieldID
     */
    public Integer getFieldID() {
        return fieldID;
    }

    /**
     *
     * @param fieldID
     * The fieldID
     */
    public void setFieldID(Integer fieldID) {
        this.fieldID = fieldID;
    }

    /**
     *
     * @return
     * The area
     */
    public String getArea() {
        return area;
    }

    /**
     *
     * @param area
     * The area
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     *
     * @return
     * The centerLatitude
     */
    public String getCenterLatitude() {
        return centerLatitude;
    }

    /**
     *
     * @param centerLatitude
     * The centerLatitude
     */
    public void setCenterLatitude(String centerLatitude) {
        this.centerLatitude = centerLatitude;
    }

    /**
     *
     * @return
     * The centerLongitude
     */
    public String getCenterLongitude() {
        return centerLongitude;
    }

    /**
     *
     * @param centerLongitude
     * The centerLongitude
     */
    public void setCenterLongitude(String centerLongitude) {
        this.centerLongitude = centerLongitude;
    }

    /**
     *
     * @return
     * The fieldInfo
     */
    public String getFieldInfo() {
        return fieldInfo;
    }

    /**
     *
     * @param fieldInfo
     * The fieldInfo
     */
    public void setFieldInfo(String fieldInfo) {
        this.fieldInfo = fieldInfo;
    }

    /**
     *
     * @return
     * The fieldName
     */
    public String getFieldName() {
        return fieldName;
    }

    /**
     *
     * @param fieldName
     * The fieldName
     */
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    /**
     *
     * @return
     * The fieldUrl
     */
    public String getFieldUrl() {
        return fieldUrl;
    }

    /**
     *
     * @param fieldUrl
     * The fieldUrl
     */
    public void setFieldUrl(String fieldUrl) {
        this.fieldUrl = fieldUrl;
    }

}