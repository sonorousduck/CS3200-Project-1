package com.sonorousduck.Project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class GameOver extends ActivityWithUser {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);


        findViewById(R.id.goHome).setOnClickListener(v -> {
            Intent intent = new Intent(this, home_activity.class);
            startActivity(intent);
            finish();
        });

    }
}