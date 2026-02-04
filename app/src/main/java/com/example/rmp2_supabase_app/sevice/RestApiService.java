package com.example.rmp2_supabase_app.sevice;

import com.example.rmp2_supabase_app.callbacks.DataCallback;
import com.example.rmp2_supabase_app.models.Order;
import com.example.rmp2_supabase_app.network.RestApi;
import com.example.rmp2_supabase_app.network.Utils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApiService {
    private final RestApi restApi;

    public RestApiService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Utils.REST_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        restApi = retrofit.create(RestApi.class);
    }

    public void getOrders(String userId, DataCallback<List<Order>> callback) {
        Call<List<Order>> response = restApi.getOrders("*", "eq." + userId);
        response.enqueue(new Callback<List<Order>>() {
            @Override
            public void onResponse(Call<List<Order>> call, Response<List<Order>> response) {
                if (response.isSuccessful()){
                    callback.onLoad(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Order>> call, Throwable t) {

            }
        });
     }
}
