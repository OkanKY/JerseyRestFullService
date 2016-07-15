package com.ok.item;

/**
 * Created by Okan on 23.3.2016.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginItem {


    @SerializedName("result")
    @Expose
    private Integer result;

    /**
     *
     * @return
     * The result
     */
    public Integer getResult() {
        return result;
    }

    /**
     *
     * @param result
     * The result
     */
    public void setResult(Integer result) {
        this.result = result;
    }

}