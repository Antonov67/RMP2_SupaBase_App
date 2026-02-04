package com.example.rmp2_supabase_app.network;

import com.example.rmp2_supabase_app.models.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface AuthApi {



    @POST("token")
    @Headers({
            "Content-Type: application/json",
            "apikey: eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImFmeWx2cXluc2t5amh0ZG5lZXBhIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NjY4MTM2NzEsImV4cCI6MjA4MjM4OTY3MX0.S7VIMz4E9BL_LKCt7TzS_bJYXnbNRFIBy8NYCipmigk"
    })
    Call<AuthUserResponse> signinUser(@Query("grant_type") String grant_type,
                                      @Body User user);


    @POST("signup")
    @Headers({
            "Content-Type: application/json",
            "apikey: eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImFmeWx2cXluc2t5amh0ZG5lZXBhIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NjY4MTM2NzEsImV4cCI6MjA4MjM4OTY3MX0.S7VIMz4E9BL_LKCt7TzS_bJYXnbNRFIBy8NYCipmigk"
    })
    Call<AuthUserResponse> signupUser(@Body User user);
}
