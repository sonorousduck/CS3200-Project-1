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

import java.util.Random;

public class GameActivity extends ActivityWithUser {

    private Boolean isTalking = false;


    protected void randomizeColors(TextView gameObject) {
        String[] colorNames = {"Red", "Green", "Black", "Blue", "Yellow", "Orange", "Pink", "Purple"};
        String[] colorInXML = {"#FF0000", "#008000", "#000000", "#0000FF", "#FFFF00", "#ff5500", "#FFC0CB", "#800080"};

        Random random = new Random();
        int random1 = random.nextInt(colorNames.length);
        int random2 = random.nextInt(colorInXML.length);


        gameObject.setText(colorNames[random1]);
        gameObject.setTextColor(Color.parseColor(colorInXML[random2]));
    }


    private void endGame() {
        Intent intent = new Intent(this, GameOver.class);
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

                System.out.println(results);

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
        recognizer.startListening(recognizerIntent);


        findViewById(R.id.microphone).setOnClickListener((view -> {
            if (!isTalking) {
                recognizer.startListening(recognizerIntent);
                isTalking = true;
            } else {
                isTalking = false;
                recognizer.stopListening();
            }
        }));

        new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long l) {
                timerText.setText("" + l / 1000);
            }

            @Override
            public void onFinish() {
                timerText.setText("Time is up.");
                endGame();



                //Send them to a new finish screen fragment.

            }
        }.start();


    }
}