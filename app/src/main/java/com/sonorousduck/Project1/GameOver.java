package com.sonorousduck.Project1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class GameOver extends ActivityWithUser {
    int score;
    int failures;
    Boolean isSpy = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        Intent pastIntent = getIntent();
        score = pastIntent.getIntExtra("score", 0);
        failures = pastIntent.getIntExtra("failures", 0);


        TextView numberCorrect = findViewById(R.id.numberCorrect);
        TextView numberIncorrect = findViewById(R.id.numberIncorrect);
        TextView spy = findViewById(R.id.spy);

        numberCorrect.setText("Correct: " + score);
        numberIncorrect.setText("Incorrect: " + failures);


        if (score > 20) {
            spy.setText("PATRIOT!");
            isSpy = false;
        }



    viewModel.getUser().observe(this, (user) -> {
        if (user != null) {
            viewModel.storeUserSpecificData(score, failures, isSpy);
        }
    });



        findViewById(R.id.goHome).setOnClickListener(v -> {
            Intent intent = new Intent(this, home_activity.class);
            startActivity(intent);
            finish();
        });

    }
}