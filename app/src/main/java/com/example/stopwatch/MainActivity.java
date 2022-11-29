package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.UFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private int miliseconds = 0;
    private boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startTimer();
    }
    public void onClickStart(View view) {
        running=true;
        Toast.makeText(MainActivity.this, "Timer Started", Toast.LENGTH_SHORT).show();
    }
    public void onClickStop(View view) {
        running=false;
        Toast.makeText(MainActivity.this, "Timer Stopped", Toast.LENGTH_SHORT).show();
    }
    public void onClickReset(View view) {
        running=false;
        Toast.makeText(MainActivity.this, "Timer Reset", Toast.LENGTH_SHORT).show();
        miliseconds=0;
    }
    private  void startTimer(){
        final TextView textView = findViewById(R.id.textView);
        Handler handler= new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int ml = miliseconds%100;
                int sec = (miliseconds/60)%60;
                int m = (miliseconds/3600);
                String time = String.format("  %02d : %02d : %02d  ",m,sec,ml);
                textView.setText(time);
                if(running){
                    miliseconds++;
                }
                handler.postDelayed(this, 10);
            }
        });
    };
}
