package com.misrarishabh.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;


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
    Button colorButton;
    ConstraintLayout currentLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submitButton = findViewById(R.id.clickButton);
        responseText = findViewById(R.id.responseEditText);
        displayText = findViewById(R.id.textBox);
        colorButton = findViewById(R.id.colorButton);
        currentLayout = findViewById(R.id.background);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //System.out.println("Hello mom!");
                int currnum = Integer.parseInt(displayText.getText().toString());
                currnum += 1;
                Log.i("testButton", responseText.getText().toString());
                displayText.setText(currnum + "");
            }
        });
        colorButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                Random rand = new Random();
                int r = rand.nextInt(256);
                int g = rand.nextInt(256);
                int b = rand.nextInt(256);
                currentLayout.setBackgroundColor(Color.rgb(r, g, b));
            }
        });
//        responseText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//                if(!hasFocus) {
//                    if(responseText.getText().toString().equals("TJ")) {
//                        displayText.setText("TJ Rocks!");
//                        responseText.setText("");
//                        responseText.setHint("That's a good name");
//                    }
//                }
//            }
//        });
    }
}
