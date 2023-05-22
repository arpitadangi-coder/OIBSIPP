package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Chronometer chronometer;
    private boolean running = false;
    Button startBtn,pauseBtn,restartBtn;
    private long pauseOffset = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chronometer = findViewById(R.id.chronometer);
        startBtn = findViewById(R.id.startBtn);
        pauseBtn = findViewById(R.id.pauseBtn);
        restartBtn = findViewById(R.id.restartBtn);

        chronometer.setBase(SystemClock.elapsedRealtime());



        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!running) {
                    Toast.makeText(MainActivity.this, String.valueOf(chronometer.getBase()), Toast.LENGTH_SHORT).show();
                    chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffset);
                    chronometer.start();
                    running = true;
                }
            }
        });
        pauseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, String.valueOf(chronometer.getBase()), Toast.LENGTH_SHORT).show();
                if (running) {
                    chronometer.stop();
                    pauseOffset = SystemClock.elapsedRealtime() - chronometer.getBase();
                    running = false;
                }
            }
        });
        restartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.setBase(SystemClock.elapsedRealtime());
                pauseOffset = 0;
            }
        });
//        chronometer.setFormat("Time: %s");
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//            chronometer.setCountDown(true);
//            chronometer.setBase(SystemClock.elapsedRealtime());
//
//            chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
//                @Override
//                public void onChronometerTick(Chronometer chronometer) {
//                    if((SystemClock.elapsedRealtime() - chronometer.getBase()) >= 10000) {
//                        chronometer.setBase(SystemClock.elapsedRealtime());
//                        Toast.makeText(MainActivity.this, "Bing!", Toast.LENGTH_SHORT).show();
//                    }
//                }
//            });
//        }
    }

    /*public void startChronometer(View v){
        if(!running) {
            long pauseOffset = 0;
            chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffset);
            chronometer.start();
            running = true;
    }*/
}

//    public void PauseChronometer(View v) {
//        if (running) {
//            chronometer.stop();
//            pauseofset = SystemClock.elapsedRealtime() - chronometer.getBase();
//            running = false;
//        }
//    }

//    public void ResetChronometer(View v) {
//            chronometer.setBase(SystemClock.elapsedRealtime());
//            pauseOffset = 0;
//        }
//    }