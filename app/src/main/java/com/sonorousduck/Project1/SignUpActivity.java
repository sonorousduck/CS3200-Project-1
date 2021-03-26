package com.sonorousduck.Project1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.sonorousduck.api.viewmodels.UserViewModel;

public class SignUpActivity extends AppCompatActivity {

    UserViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        viewModel = new ViewModelProvider(this).get(UserViewModel.class);

        EditText name = findViewById(R.id.name);
        EditText email = findViewById(R.id.emailAddress);
        EditText password = findViewById(R.id.passwordField);
        EditText confirmPassword = findViewById(R.id.confirmPassword);

        Button signUp = findViewById(R.id.createAccount);

        signUp.setOnClickListener(view -> {
            if (password.getText().toString().equals(confirmPassword.getText().toString())) {
                viewModel.signUp(
                        name.getText().toString(),
                        email.getText().toString(),
                        password.getText().toString());
            }
        });




    }

    @Override
    protected void onStart() {
        super.onStart();
        viewModel.getUser().observe(this, (user) -> {
            if (user != null) {
                Intent intent = new Intent(this, home_activity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}