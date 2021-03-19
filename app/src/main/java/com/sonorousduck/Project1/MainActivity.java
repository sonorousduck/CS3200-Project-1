package com.sonorousduck.Project1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;


public class MainActivity extends AppCompatActivity {

    UserViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_signup);
        viewModel = new ViewModelProvider(this).get(UserViewModel.class);

        EditText email = findViewById(R.id.email);
        EditText password = findViewById(R.id.password);
        Button signIn = findViewById(R.id.signIn);
        Button signUp = findViewById(R.id.signUp);

        signIn.setOnClickListener((view -> {
            viewModel.signIn(
                    email.getText().toString(),
                    password.getText().toString());
        }));

        signUp.setOnClickListener((view -> {
            viewModel.signUp(
                    email.getText().toString(),
                    password.getText().toString());
        }));

    }

}
