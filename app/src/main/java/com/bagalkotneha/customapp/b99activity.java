package com.bagalkotneha.customapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class b99activity extends AppCompatActivity {

    TextView question;
    Chronometer chronometer;
    int count = 0;
    EditText responseText;
    String[] questions;
    String[] answers;
    int score = 0;
    TextView scoreText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.b99layout);
        question = findViewById(R.id.question);
        responseText = findViewById(R.id.responseEditText);
        scoreText = findViewById(R.id.score);

        chronometer = (Chronometer) findViewById(R.id.simpleChronometer); // initiate a chronometer
        chronometer.setBase(SystemClock.elapsedRealtime());
        chronometer.start(); // start a chronometer

        Resources res = getResources();
        questions = res.getStringArray(R.array.b99questions);
        answers = res.getStringArray(R.array.b99answers);
        question.setText(questions[count]);
    }
    public void onClick2(View view) {
        String ans = responseText.getText().toString();
        Log.i("testMessage", ans);
        Log.i("2message", answers[count]);
        if (ans.equalsIgnoreCase(answers[count])) {
            score++;
        }
        if (count < (questions.length-1)) {
            scoreText.setText("Score: " + score);
            count++;
            question.setText(questions[count]);
        }
        else {
            chronometer.stop();
            long time = Long.valueOf(SystemClock.elapsedRealtime() - chronometer.getBase()) / Long.valueOf(1000);
            Intent intent = new Intent(getApplicationContext(), finalactivity.class);
            intent.putExtra("time", time);
            intent.putExtra("score", score);
            startActivity(intent);
        }
    }
}