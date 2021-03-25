package com.sonorousduck.Project1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.sonorousduck.api.viewmodels.UserViewModel;

public class Settings extends Fragment {
    UserViewModel viewModel;
    public Settings() {
        super(R.layout.fragment_settings);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.logOut).setOnClickListener(view1 -> {
            viewModel = new ViewModelProvider(this).get(UserViewModel.class);
            viewModel.signOut();
        });
    }
}