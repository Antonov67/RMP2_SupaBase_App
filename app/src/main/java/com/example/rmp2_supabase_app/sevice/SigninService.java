package com.example.rmp2_supabase_app.sevice;

import com.example.rmp2_supabase_app.callbacks.DataCallback;
import com.example.rmp2_supabase_app.models.User;
import com.example.rmp2_supabase_app.network.AuthApi;
import com.example.rmp2_supabase_app.network.AuthUserData;
import com.example.rmp2_supabase_app.network.AuthUserResponse;
import com.example.rmp2_supabase_app.network.Utils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SigninService {
    private final AuthApi authApi;

    public SigninService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Utils.AUTH_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        authApi = retrofit.create(AuthApi.class);
    }

    public void signinUser(User user, DataCallback<String> callback) {
        Call<AuthUserResponse> response = authApi.signinUser("password", user);
        response.enqueue(new Callback<AuthUserResponse>() {
            @Override
            public void onResponse(Call<AuthUserResponse> call, Response<AuthUserResponse> response) {
                if (response.isSuccessful()){
                    callback.onLoad(response.body().getAccess_token());
                    AuthUserData.id = response.body().getUserId();
                }
            }

            @Override
            public void onFailure(Call<AuthUserResponse> call, Throwable t) {

            }
        });
    }
}
