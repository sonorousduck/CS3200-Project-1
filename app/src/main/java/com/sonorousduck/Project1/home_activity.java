package com.sonorousduck.Project1;


import android.content.Intent;
import android.os.Bundle;

import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;
import com.sonorousduck.api.viewmodels.UserViewModel;

public class home_activity extends ActivityWithUser {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_activity);


        // This sets the main fragment to be the game_fragment
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, game_fragment.class, null)
                    .setReorderingAllowed(true)
                    .commit();
        }


        viewModel.getUser().observe(this, (user) -> {
            if (user != null) {
                viewModel.storeUserSpecificData();
            }
        });


//        findViewById(R.id.logOut).setOnClickListener((view -> {
//            viewModel.signOut();
//        }));


        MaterialToolbar toolbar = findViewById(R.id.topAppBar);
        DrawerLayout drawerLayout = findViewById(R.id.drawer);
        toolbar.setNavigationOnClickListener(view -> {
            drawerLayout.open();
        });

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(menuItem -> {
            menuItem.setChecked(true);

            if (menuItem.getItemId() == R.id.home_item) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, game_fragment.class, null)
                        .setReorderingAllowed(true)
                        .commit();
            }

            if (menuItem.getItemId() == R.id.settings) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, Settings.class, null)
                        .setReorderingAllowed(true)
                        .commit();
            }

            if (menuItem.getItemId() == R.id.profile) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, ProfileFragment.class, null)
                        .setReorderingAllowed(true)
                        .commit();
            }
            drawerLayout.close();
            return true;
        });

    }

}