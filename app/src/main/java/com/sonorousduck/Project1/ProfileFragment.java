package com.sonorousduck.Project1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sonorousduck.api.viewmodels.UserViewModel;

import java.util.Objects;

public class ProfileFragment extends Fragment {
    public ProfileFragment() {
        super(R.layout.fragment_profile);

    }
    UserViewModel viewModel;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        viewModel = new ViewModelProvider(this).get(UserViewModel.class);


//        TextView profileEmail = view.findViewById(R.id.profile);
//        profileEmail.setText(viewModel.getUser().getValue().email);


    }
}