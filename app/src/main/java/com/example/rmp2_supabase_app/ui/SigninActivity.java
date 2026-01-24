package com.example.rmp2_supabase_app.ui;

import android.content.Intent;
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

import com.example.rmp2_supabase_app.R;
import com.example.rmp2_supabase_app.callbacks.DataCallback;
import com.example.rmp2_supabase_app.models.User;
import com.example.rmp2_supabase_app.sevice.SigninService;

public class SigninActivity extends AppCompatActivity {

    EditText emailField, pswrdField;
    Button signinBtn;
    TextView toSignupWndBtn;
    SigninService signinService = new SigninService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signin);

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
                            Toast.makeText(SigninActivity.this, data, Toast.LENGTH_SHORT).show();
                        }
                    });

                }
            }
        });

        toSignupWndBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SigninActivity.this, SignupActivity.class));
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}