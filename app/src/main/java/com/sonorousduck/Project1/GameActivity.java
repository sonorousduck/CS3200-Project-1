package com.sonorousduck.Project1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

import java.util.Random;

public class GameActivity extends ActivityWithUser {


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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        TextView timerText = findViewById(R.id.timer);
        TextView gameObject = findViewById(R.id.gameObject);
        randomizeColors(gameObject);

        // Every time user says something. Check to see if it is correct. If correct, add one to score
        // If they get it wrong add to incorrect. Then generate new color, and keep going.

        new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long l) {
                timerText.setText("" + l / 1000);
            }

            @Override
            public void onFinish() {
                timerText.setText("Time is up.");



                //Send them to a new finish screen fragment.

            }
        }.start();


    }
}