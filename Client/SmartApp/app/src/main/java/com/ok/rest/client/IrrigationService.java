package com.ok.rest.client;

import com.ok.datamining.item.BestPlant;
import com.ok.item.BestPlantItem;
import com.ok.item.FileListItem;
import com.ok.item.LoginItem;

import java.util.List;

import retrofit.Call;
import retrofit.http.Field;
import retrofit.http.Header;
import retrofit.http.POST;
import retrofit.http.FormUrlEncoded;

/**
 * Created by Okan on 23.3.2016.
 */
public interface IrrigationService {
    @FormUrlEncoded
    @POST("getUserFieldList")
    Call<List<FileListItem>> getUserFieldList(@retrofit.http.Field("userName") String userName,
                            @retrofit.http.Field("password") String password);
    @FormUrlEncoded
    @POST("login")
    Call<LoginItem> login(@retrofit.http.Field("userName") String userName,
                                              @retrofit.http.Field("password") String password);
    @FormUrlEncoded
    @POST("getBestPlant")
    Call<BestPlantItem> getBestPlant(@Field("userName") String userName,
                              @Field("password") String password,@Field("addressID") Integer addressID,
                              @Field("area") Integer area,@Field("climateID") Integer climateID,
                              @Field("soilID") Integer soilID,@Field("profitValue") Integer profitValue,
                              @Field("plantID") Integer plantID);
}
