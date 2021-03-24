package com.sonorousduck.Project1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.sonorousduck.api.viewmodels.UserViewModel;

public class MainActivity extends AppCompatActivity {

    UserViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
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

//
//        signOut.setOnClickListener(view -> {
//            viewModel.signOut();
//            System.out.println("Signed Out");
//        });



    }

    @Override
    protected void onStart() {
        super.onStart();
        viewModel.getUser().observe(this, (user) -> {
            System.out.println("MY USER!");
            System.out.println(user);
            if (user != null) {
                Intent intent = new Intent(this, home_activity.class);
                startActivity(intent);
                finish();
            }
        });
    }

}
