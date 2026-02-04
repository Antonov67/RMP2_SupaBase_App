package com.example.rmp2_supabase_app.ui;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.rmp2_supabase_app.R;
import com.example.rmp2_supabase_app.callbacks.DataCallback;
import com.example.rmp2_supabase_app.models.Order;
import com.example.rmp2_supabase_app.network.AuthUserData;
import com.example.rmp2_supabase_app.sevice.RestApiService;

import java.util.ArrayList;
import java.util.List;

public class OrdersActivity extends AppCompatActivity {

    private final RestApiService restApiService = new RestApiService();
    private ListView ordersList;
    private ArrayAdapter<String> adapter;
    private List<String> orders = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_orders);

        ordersList = findViewById(R.id.ordersList);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, orders);


        restApiService.getOrders(AuthUserData.id, new DataCallback<List<Order>>() {
            @Override
            public void onLoad(List<Order> data) {
                for (Order order : data){
                    orders.add(order.toString());
                }
                ordersList.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}