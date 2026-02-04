package com.example.rmp2_supabase_app.network;

import com.example.rmp2_supabase_app.models.Order;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface RestApi {

    @GET("orders")
    @Headers({
            "Content-Type: application/json",
            "apikey: eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImFmeWx2cXluc2t5amh0ZG5lZXBhIiwicm9sZSI6InNlcnZpY2Vfcm9sZSIsImlhdCI6MTc2NjgxMzY3MSwiZXhwIjoyMDgyMzg5NjcxfQ.Hv9kfHDV5h0uVVF1K4KISl1sXOvpSgA1wS6LXExkJP4",
            "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImFmeWx2cXluc2t5amh0ZG5lZXBhIiwicm9sZSI6InNlcnZpY2Vfcm9sZSIsImlhdCI6MTc2NjgxMzY3MSwiZXhwIjoyMDgyMzg5NjcxfQ.Hv9kfHDV5h0uVVF1K4KISl1sXOvpSgA1wS6LXExkJP4"
    })
    Call<List<Order>> getOrders(@Query("select") String select, @Query("user_id") String userId);
}
