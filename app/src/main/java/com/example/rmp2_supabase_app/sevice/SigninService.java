package com.example.rmp2_supabase_app.sevice;

import com.example.rmp2_supabase_app.callbacks.DataCallback;
import com.example.rmp2_supabase_app.models.User;
import com.example.rmp2_supabase_app.network.Api;
import com.example.rmp2_supabase_app.network.SigninUserResponse;
import com.example.rmp2_supabase_app.network.Utils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SigninService {
    private final Api api;

    public SigninService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Utils.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(Api.class);
    }

    public void signinUser(User user, DataCallback<String> callback) {
        Call<SigninUserResponse> response = api.signinUser("password", user);
        response.enqueue(new Callback<SigninUserResponse>() {
            @Override
            public void onResponse(Call<SigninUserResponse> call, Response<SigninUserResponse> response) {
                if (response.isSuccessful()){
                    callback.onLoad(response.body().getAccess_token());
                }
            }

            @Override
            public void onFailure(Call<SigninUserResponse> call, Throwable t) {

            }
        });
    }
}
