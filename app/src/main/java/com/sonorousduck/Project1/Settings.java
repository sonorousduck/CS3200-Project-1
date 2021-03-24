package com.sonorousduck.Project1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;

import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.sonorousduck.api.viewmodels.UserViewModel;

public class Settings extends Fragment {
    public Settings() {
        super(R.layout.fragment_settings);
    }
}