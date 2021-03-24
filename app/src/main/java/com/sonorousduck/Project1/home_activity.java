package com.sonorousduck.Project1;


import android.content.Intent;
import android.os.Bundle;

import com.sonorousduck.api.viewmodels.UserViewModel;

public class home_activity extends ActivityWithUser {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_activity);


        viewModel.getUser().observe(this, (user) -> {
            if (user != null) {
                viewModel.storeUserSpecificData();
            }
        });


        findViewById(R.id.logOut).setOnClickListener((view -> {
            viewModel.signOut();
        }));
    }
}