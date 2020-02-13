package com.misrarishabh.lab03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("NumClicks", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        final TextView topLeft = findViewById(R.id.topLeft);
        final TextView topRight = findViewById(R.id.topRight);
        final TextView bottomLeft = findViewById(R.id.bottomLeft);
        final TextView bottomRight = findViewById(R.id.bottomRight);
        topLeft.setOnClickListener(onClickListener);
        topRight.setOnClickListener(onClickListener);
        bottomLeft.setOnClickListener(onClickListener);
        bottomRight.setOnClickListener(onClickListener);

        SeekBar simpleSeekBar = findViewById(R.id.seekBar); // initiate the Seekbar
        simpleSeekBar.setMax(50); // 150 maximum value for the Seek bar
        simpleSeekBar.setProgress(32);
        simpleSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                topLeft.setTextSize(progress);
                topRight.setTextSize(progress);
                bottomLeft.setTextSize(progress);
                bottomRight.setTextSize(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            HashMap dictionary = new HashMap();
            dictionary.put("TL", "Top Left");
            dictionary.put("TR", "Top Right");
            dictionary.put("BL", "Bottom Left");
            dictionary.put("BR", "Bottom Right");
            TextView currView = findViewById(v.getId());
            String viewname = currView.getText().toString();
            int numclicks = sharedPreferences.getInt(viewname, 0);
            numclicks+=1;
            String text = dictionary.get(viewname) + " was clicked! It has been clicked " + numclicks + " times.";
            Toast t = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG);
            t.show();
            editor.putInt(viewname, numclicks);
            editor.apply();
        }
    };
}
