package com.misrarishabh.lab06a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText input;
    TextView output;
    Button translatebutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.wordenter);
        output = findViewById(R.id.translated);
        translatebutton = findViewById(R.id.button);

        translatebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tochange = input.getText().toString();
                String newword = translateWord(tochange);
                output.setText(newword);
            }
        });

    }
    public static String translateWord(String word) {
        String lowerCaseWord = word.toLowerCase();
        int pos = -1; // Position of first vowel
        char ch;

        // This for loop finds the index of the first vowel in the word
        for (int i = 0; i < lowerCaseWord.length(); i++) {
            ch = lowerCaseWord.charAt(i);

            if (isVowel(ch)) {
                pos = i;
                break;
            }
        }

        if (pos == 0) {
            // Translating word if the first character is a vowel (Rule 3)
            return lowerCaseWord + "yay"; // Adding "yay" to the end of string (can also be "way" or just "ay")
        } else {
            // Translating word if the first character(s) are consonants (Rule 1 and 2)
            String a = lowerCaseWord.substring(pos); // Extracting all characters in the word beginning from the 1st vowel
            String b = lowerCaseWord.substring(0, pos); // Extracting all characters located before the first vowel
            return a + b + "ay"; // Adding "ay" at the end of the extracted words after joining them.
        }

    }
    public static Boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'y') {
            return true;
        }
        return false;
    }
}