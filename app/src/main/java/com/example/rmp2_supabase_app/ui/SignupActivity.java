package com.example.rmp2_supabase_app.ui;

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
import com.example.rmp2_supabase_app.sevice.SignupService;

public class SignupActivity extends AppCompatActivity {

    EditText emailField, pswrdField;
    Button signupBtn;
    SignupService signupService = new SignupService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);

        emailField = findViewById(R.id.signupEmailField);
        pswrdField = findViewById(R.id.signupPswrdField);
        signupBtn = findViewById(R.id.signupBtn);

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!emailField.getText().toString().isEmpty()
                        && !pswrdField.getText().toString().isEmpty()) {
                    User user = new User(emailField.getText().toString(), pswrdField.getText().toString());
                    signupService.signupUser(user, new DataCallback<String>() {
                        @Override
                        public void onLoad(String data) {
                            Toast.makeText(SignupActivity.this, data, Toast.LENGTH_SHORT).show();
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