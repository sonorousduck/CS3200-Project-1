package com.sonorousduck.Project1;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class gameplay_fragment extends Fragment {

    public gameplay_fragment() {
        super(R.layout.fragment_gameplay_fragment);
    }

    protected void randomizeColors(TextView gameObject) {
        String[] colorNames = {"Red", "Green", "Black", "Blue", "Yellow", "Orange", "Pink", "Purple"};
        String[] colorInXML = {"#FF0000", "#008000", "#000000", "#0000FF", "#FFFF00", "#ff5500", "#FFC0CB", "#800080"};

        Random random = new Random();
        int random1 = random.nextInt(colorNames.length);
        int random2 = random.nextInt(colorInXML.length);


        gameObject.setText(colorNames[random1]);
        gameObject.setTextColor(Color.parseColor(colorInXML[random2]));
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView timerText = view.findViewById(R.id.timer);
        TextView gameObject = view.findViewById(R.id.gameObject);
        randomizeColors(gameObject);

        // Every time user says something. Check to see if it is correct. If correct, add one to score
        // If they get it wrong add to incorrect. Then generate new color, and keep going.





        new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long l) {
                timerText.setText("" + l / 1000 + " seconds remaining");
            }

            @Override
            public void onFinish() {
                timerText.setText("Time is up.");



                //Send them to a new finish screen fragment.

            }
        }.start();

    }
}