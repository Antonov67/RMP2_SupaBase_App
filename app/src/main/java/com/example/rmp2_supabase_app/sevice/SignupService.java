package com.example.rmp2_supabase_app.sevice;

import com.example.rmp2_supabase_app.callbacks.DataCallback;
import com.example.rmp2_supabase_app.models.User;
import com.example.rmp2_supabase_app.network.AuthApi;
import com.example.rmp2_supabase_app.network.AuthUserResponse;
import com.example.rmp2_supabase_app.network.Utils;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignupService {
    private final AuthApi authApi;

    public SignupService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Utils.AUTH_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        authApi = retrofit.create(AuthApi.class);
    }

    public void signupUser(User user, DataCallback<String> callback) {
        Call<AuthUserResponse> response = authApi.signupUser(user);
        response.enqueue(new Callback<AuthUserResponse>() {
            @Override
            public void onResponse(Call<AuthUserResponse> call, Response<AuthUserResponse> response) {
                if (response.isSuccessful()) {
                    callback.onLoad(response.body().getAccess_token());
                } else {
                    try {
                        callback.onLoad(response.errorBody().string());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(call);
                }
            }

            @Override
            public void onFailure(Call<AuthUserResponse> call, Throwable t) {

            }
        });
    }
}
