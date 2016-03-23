package com.ok.rest.client;

import com.ok.item.Field;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.FormUrlEncoded;

/**
 * Created by Okan on 23.3.2016.
 */
public interface IrrigationService {
    @FormUrlEncoded
    @POST("/rest/user/getUserFieldList")
    Call<com.ok.item.Field> getUserFieldList(@retrofit.http.Field("userName") String userName,
                            @retrofit.http.Field("password") String password);
}
