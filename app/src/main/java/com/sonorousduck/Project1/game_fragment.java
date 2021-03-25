package com.sonorousduck.Project1;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class game_fragment extends Fragment {
    public game_fragment() {
        super(R.layout.fragment_game_fragment);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);




        view.findViewById(R.id.startGame).setOnClickListener((v -> {
            Intent intent = new Intent(getContext(), GameActivity.class);
            startActivity(intent);
//            getParentFragmentManager().beginTransaction()
//                    .replace(R.id.fragment_container, gameplay_fragment.class, null)
//                    .setReorderingAllowed(true)
//                    .commit();
        }));


    }




}