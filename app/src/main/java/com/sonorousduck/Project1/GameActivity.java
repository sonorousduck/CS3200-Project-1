package com.sonorousduck.Project1;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class GameActivity extends ActivityWithUser {

    private Boolean isTalking = false;
    protected int score = 0;
    protected int failures = 0;


    protected void randomizeColors(TextView gameObject) {
        String[] colorNames = {"Red", "Green", "Black", "Blue", "Yellow", "Orange", "Pink", "Purple"};
        String[] colorInXML = {"#FF0000", "#008000", "#000000", "#0000FF", "#FFFF00", "#ff5500", "#FFC0CB", "#800080"};

        Random random = new Random();
        int random1 = random.nextInt(colorNames.length);
        int random2 = random.nextInt(colorInXML.length);


        gameObject.setText(colorNames[random1]);
        gameObject.setTextColor(Color.parseColor(colorInXML[random2]));
        gameObject.setHint(colorNames[random2]);
    }


    private void endGame(int score, int failures) {
        Intent intent = new Intent(this, GameOver.class);
        intent.putExtra("score", score);
        intent.putExtra("failures", failures);
        startActivity(intent);
        finish();
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

        SpeechRecognizer recognizer = SpeechRecognizer.createSpeechRecognizer(this);

        recognizer.setRecognitionListener(new RecognitionListener() {
            @Override
            public void onReadyForSpeech(Bundle params) {

            }

            @Override
            public void onBeginningOfSpeech() {

            }

            @Override
            public void onRmsChanged(float rmsdB) {

            }

            @Override
            public void onBufferReceived(byte[] buffer) {

            }

            @Override
            public void onEndOfSpeech() {

            }

            @Override
            public void onError(int error) {
                System.out.println("Error " + error);
            }

            @Override
            public void onResults(Bundle results) {
                // This is where the results will go
                ArrayList<String> result = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);

                System.out.println(result.get(0).toLowerCase());
                System.out.println(gameObject.getHint().toString().toLowerCase());

                if (result.get(0).equals(gameObject.getHint().toString().toLowerCase())) {
                    score++;
                } else {
                    failures++;
                }

                randomizeColors(gameObject);


            }

            @Override
            public void onPartialResults(Bundle partialResults) {

            }

            @Override
            public void onEvent(int eventType, Bundle params) {

            }
        });

        Intent recognizerIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

        findViewById(R.id.microphone).setOnClickListener((view -> {
            if (!isTalking) {
                recognizer.startListening(recognizerIntent);
                isTalking = true;
            } else {
                isTalking = false;
                recognizer.stopListening();
            }
        }));

        new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long l) {
                timerText.setText("" + l / 1000);
            }

            @Override
            public void onFinish() {
                timerText.setText("Time is up.");
                endGame(score, failures);
            }
        }.start();


    }
}