package com.ok.rest.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ok.item.Field;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by Okan on 23.3.2016.
 */
public class IrrigationApi {
    private final static String BASE_URL="http://localhost:8080/irragation.system/";
    private IrrigationService irrigationService;
    public IrrigationApi(IrrigationService irrigationService)
    {
    this.irrigationService=irrigationService;
    }
    public static IrrigationApi create() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        IrrigationService service = retrofit.create(IrrigationService.class);

        return new IrrigationApi(service);
    }
    public void getUserFieldList(String userName, String password, final ResultCallback callback) {
        Call<Field> call = irrigationService.getUserFieldList(userName,password);
        callback(callback, call);
    }
    private void callback(final ResultCallback callback, Call<Field> call) {
        call.enqueue(new retrofit.Callback<Field>() {
            @Override
            public void onResponse(Response<Field> response, Retrofit retrofit) {
                callback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Throwable t) {
                callback.onFailure(t);
            }
        });
    }
}
