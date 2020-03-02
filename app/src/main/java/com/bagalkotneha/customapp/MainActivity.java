package com.bagalkotneha.customapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button submitButton;
    EditText responseText;
    EditText response2Text;
    TextView displayText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submitButton = findViewById(R.id.clickButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Hello mom!");
                // Log.i("firstButton", "Hi mom!");
                Log.i("testButton","Hi dad!");
                Log.i("testButton", responseText.getText().toString());
                displayText.setText(displayText.getText()+" "+responseText.getText());
            }
        });
        response2Text.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus) {
                    if (response2Text.getText().toString().equals("TJ")) {
                        displayText.setText("TJ Rocks!");
                        response2Text.setText("");
                        response2Text.setHint("That's a good name.");
                    }
                }
            }
        });
    }

    public void onClick(View view) {
        Intent intentTour = new Intent(getApplicationContext(), b99activity.class);
        startActivity(intentTour);
    }
}
