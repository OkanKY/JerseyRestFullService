package com.ok.rest.client;

import com.ok.item.FileListItem;
import com.ok.item.LoginItem;

import java.util.List;

import retrofit.Call;
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
}
