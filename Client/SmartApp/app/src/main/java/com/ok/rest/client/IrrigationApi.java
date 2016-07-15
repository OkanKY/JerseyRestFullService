package com.ok.rest.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ok.item.BestPlantItem;
import com.ok.item.FileListItem;
import com.ok.item.LoginItem;

import java.util.List;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import retrofit.http.Field;

/**
 * Created by Okan on 23.3.2016.
 */
public class IrrigationApi {
    private final static String BASE_URL="http://192.168.56.1:8080/irragation.system/rest/user/";
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
    public void getUserFieldList(String userName, String password, final FieldListCallback callback) {
        Call<List<FileListItem>> call = irrigationService.getUserFieldList(userName, password);
        callback(callback, call);
    }
    public void checkLogin(String userName, String password, final LoginCallback loginCallback) {
        Call<LoginItem> call = irrigationService.login(userName, password);
        callback(loginCallback, call);
    }
    public void getBestPlant(String userName,
                             String password,Integer addressID,
                             Integer area,Integer climateID,
                             Integer soilID,Integer profitValue,
                             Integer plantID,BestItemCallback bestItemCallback) {
        Call<BestPlantItem> call = irrigationService.getBestPlant(userName, password, addressID,
                area, climateID, soilID, profitValue, plantID);
        callback(bestItemCallback, call);
    }
    private void callback(final FieldListCallback callback, Call<List<FileListItem>> call) {
        call.enqueue(new retrofit.Callback<List<FileListItem>>() {
            public void onResponse(Response<List<FileListItem>> response, Retrofit retrofit) {
                callback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Throwable t) {
                callback.onFailure(t);
            }
        });
    }
    private void callback(final LoginCallback loginCallback, Call<LoginItem> call) {
        call.enqueue(new retrofit.Callback<LoginItem>() {
            public void onResponse(Response<LoginItem> response, Retrofit retrofit) {
                try {
               if(response.body()!=null&&response.body().getResult()!=-1)
                loginCallback.onSuccess(response.body());
                else
                   loginCallback.onFailure(new Throwable("User Not Found"));

                } catch (Exception e)
                {
                    loginCallback.onFailure(e);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                loginCallback.onFailure(t);
            }
        });
    }
    private void callback(final BestItemCallback bestItemCallback, Call<BestPlantItem> call) {
        call.enqueue(new retrofit.Callback<BestPlantItem>() {
            public void onResponse(Response<BestPlantItem> response, Retrofit retrofit) {
                try {
                    bestItemCallback.onSuccess(response.body());
                } catch (Exception e)
                {
                    bestItemCallback.onFailure(e);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                bestItemCallback.onFailure(t);
            }
        });
    }
}
