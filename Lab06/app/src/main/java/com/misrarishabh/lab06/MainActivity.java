package com.misrarishabh.lab06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

class Counter {
    // Variable instantiations
    public Counter() {

    }
    private int onCreateCount = 0;
    private int onStartCount = 0;
    private int onResumeCount = 0;
    private int onPauseCount = 0;
    private int onStopCount = 0;
    private int onRestartCount = 0;
    private int onDestroyCount = 0;

    // Getter methods
    public int getCreate() {
        return onCreateCount;
    }
    public int getStart() {
        return onStartCount;
    }
    public int getResume() {
        return onResumeCount;
    }
    public int getPause() {
        return onPauseCount;
    }
    public int getStop() {
        return onStopCount;
    }
    public int getRestart() {
        return onRestartCount;
    }
    public int getDestroy() {
        return onDestroyCount;
    }

    // Setter methods
    public void setCreate(int value) {
        onCreateCount = value;
    }
    public void setStart(int value) {
        onStartCount = value;
    }
    public void setResume(int value) {
        onResumeCount = value;
    }
    public void setPause(int value) {
        onPauseCount = value;
    }
    public void setStop(int value) {
        onStopCount = value;
    }
    public void setRestart(int value) {
        onRestartCount = value;
    }
    public void setDestroy(int value) {
        onDestroyCount = value;
    }
}

public class MainActivity extends AppCompatActivity {
    Counter counter;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences("NumCalls", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        counter = new Counter();
        counter.setCreate(1);
        int numcalls = sharedPreferences.getInt("create", 0);
        numcalls +=1;
        editor.putInt("create", numcalls);
        editor.apply();
    }
    protected void onStart() {
        super.onStart();
        counter.setStart(counter.getStart() + 1);
        int numcalls = sharedPreferences.getInt("start", 0);
        numcalls +=1;
        editor.putInt("start", numcalls);
        editor.apply();
    }
    protected void onResume() {
        super.onResume();
        counter.setResume(counter.getResume() + 1);
        int numcalls = sharedPreferences.getInt("resume", 0);
        numcalls +=1;
        editor.putInt("resume", numcalls);
        editor.apply();
    }
    protected void onPause() {
        super.onPause();
        counter.setPause(counter.getPause() + 1);
        int numcalls = sharedPreferences.getInt("pause", 0);
        numcalls +=1;
        editor.putInt("pause", numcalls);
        editor.apply();
    }
    protected void onStop() {
        super.onStop();
        counter.setStop(counter.getStop() + 1);
        int numcalls = sharedPreferences.getInt("stop", 0);
        numcalls +=1;
        editor.putInt("stop", numcalls);
        editor.apply();
    }
    protected void onRestart() {
        super.onRestart();
        counter.setRestart(counter.getRestart() + 1);
        int numcalls = sharedPreferences.getInt("restart", 0);
        numcalls +=1;
        editor.putInt("restart", numcalls);
        editor.apply();
    }
    protected void onDestroy() {
        super.onDestroy();
        counter.setDestroy(counter.getDestroy() + 1);
        int numcalls = sharedPreferences.getInt("destroy", 0);
        numcalls +=1;
        editor.putInt("destroy", numcalls);
        editor.apply();
    }
}
