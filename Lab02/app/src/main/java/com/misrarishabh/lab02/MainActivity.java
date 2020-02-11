package com.misrarishabh.lab02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;


import android.content.res.Resources;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.graphics.Color;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button submitButton;
    EditText responseText;
    TextView displayText;
    TextView fruitText;
    Button colorButton;
    ConstraintLayout currentLayout;
    Resources res;
    String[] fruits;
    int fruitcounter;
    int fruitlength;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submitButton = findViewById(R.id.clickButton);
        responseText = findViewById(R.id.responseEditText);
        displayText = findViewById(R.id.textBox);
        colorButton = findViewById(R.id.colorButton);
        currentLayout = findViewById(R.id.background);
        fruitText = findViewById(R.id.fruitviewer);
        res = getResources();
        fruits = res.getStringArray(R.array.fruits);
        fruitlength = fruits.length;
        fruitcounter = 0;

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayText.setText(responseText.getText().toString());
            }
        });
        colorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fruitText.setText(fruits[fruitcounter]);
                fruitcounter++;
                if(fruitcounter == fruitlength) {
                    fruitcounter = 0;
                }
            }
        });
    }
}

