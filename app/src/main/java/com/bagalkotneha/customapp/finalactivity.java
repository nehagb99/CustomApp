package com.bagalkotneha.customapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.lang.reflect.Array;
import java.util.ResourceBundle;


public class finalactivity extends AppCompatActivity {

    TextView scoreText;
    TextView timeText;
    TextView lowtimeText;
    TextView resultText;
    int curscore;
    long curtime;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Highscore highscore;
    Highscore defscore;
    long[] defscores;
    long[] highscores;
    long lowtime;
    Gson gson;
    String[] descs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finalpage);
        sharedPreferences = getSharedPreferences("Settings", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putString("keyName", "newValue");
        editor.apply();
        gson = new Gson();

        defscores = new long[13];
        for (int i = 0; i<13; i++) {
            defscores[i] = Long.valueOf(1000000000);
        }
        defscore = new Highscore(defscores);

        scoreText = findViewById(R.id.score);
        curscore  = getIntent().getExtras().getInt("score");
        scoreText.setText("You got " + curscore + " out of 13 questions right!");

        timeText = findViewById(R.id.time);
        curtime = getIntent().getExtras().getLong("time");
        timeText.setText("Your time: " + curtime + " seconds");

        lowtimeText = findViewById(R.id.lowtime);
        String temp = sharedPreferences.getString("times", gson.toJson(defscore));
        highscore = gson.fromJson(temp, Highscore.class);
        highscores = highscore.getTimes();
        if (curtime < highscores[curscore]) {
            lowtime = curtime;
            highscores[curscore] = lowtime;
            Highscore newhigh = new Highscore(highscores);
            editor.putString("times", gson.toJson(newhigh));
            editor.apply();
        }
        else {
            lowtime = highscores[curscore];
        }
        lowtimeText.setText("Lowest time for your score: " + lowtime + " seconds");

        resultText = findViewById(R.id.result);
        descs = getResources().getStringArray(R.array.b99results);
        resultText.setText(descs[curscore]);
    }
    public void clickBack(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}