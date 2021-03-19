package com.sonorousduck.Project1;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;




public class MainActivity extends AppCompatActivity {

    UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_signup);
        viewModel = new ViewModelProvider(this).get(UserViewModel.class);

        EditText email = findViewById(R.id.email);
        EditText password = findViewById(R.id.password);


    }
}