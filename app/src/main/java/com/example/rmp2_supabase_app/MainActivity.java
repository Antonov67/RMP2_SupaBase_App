package com.example.rmp2_supabase_app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.rmp2_supabase_app.callbacks.DataCallback;
import com.example.rmp2_supabase_app.models.User;
import com.example.rmp2_supabase_app.network.Api;
import com.example.rmp2_supabase_app.network.SigninUserResponse;
import com.example.rmp2_supabase_app.sevice.SigninService;

import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    EditText emailField, pswrdField;
    Button signinBtn;
    TextView toSignupWndBtn;
    SigninService signinService = new SigninService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        emailField = findViewById(R.id.signinEmailField);
        pswrdField = findViewById(R.id.signinPswrdField);
        signinBtn = findViewById(R.id.signinBtn);
        toSignupWndBtn = findViewById(R.id.toSignupWnd);

        signinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!emailField.getText().toString().isEmpty()
                        && !pswrdField.getText().toString().isEmpty()) {
                    User user = new User(emailField.getText().toString(), pswrdField.getText().toString());
                    signinService.signinUser(user, new DataCallback<String>() {
                        @Override
                        public void onLoad(String data) {
                            Toast.makeText(MainActivity.this, data, Toast.LENGTH_SHORT).show();
                        }
                    });

                }
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}