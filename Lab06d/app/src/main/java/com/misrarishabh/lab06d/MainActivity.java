package com.misrarishabh.lab06d;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Calendar;

import com.google.gson.Gson;

class WordDayObjects {
    ArrayList<String> words;
    Calendar c;
    public WordDayObjects() {
        words = new ArrayList<String>();
        c = Calendar.getInstance();
    }
}

public class MainActivity extends AppCompatActivity {
    EditText input;
    TextView output, totalcalls;
    Button translatebutton;
    Gson gson;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.wordenter);
        output = findViewById(R.id.translated);
        translatebutton = findViewById(R.id.button);
        totalcalls = findViewById(R.id.totalcalls);

        sharedPreferences = getSharedPreferences("numtranslate", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        translatebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tochange = input.getText().toString();
                String newword = translateWord(tochange);
                output.setText(newword);
                int numtranslates = sharedPreferences.getInt("translates", 0);
                numtranslates +=1;
                editor.putInt("translates", numtranslates);
                editor.apply();
                totalcalls.setText("Total Translates: " + numtranslates);
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
