package com.rachel.polachova.aap_lab_3;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class CountdownActivity extends AppCompatActivity {

    final static String TAG = "CountdownActivity";

    int seconds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countdown);
        seconds = getIntent().getIntExtra("seconds",0);
        startCountdown();
    }

    private void startCountdown() {

        final TextView secondsTextView = findViewById(R.id.seconds_countdown);

        new CountDownTimer(seconds * 1000,1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                Log.d(TAG, "onTick: milis until finished: " + millisUntilFinished / 1000);
                secondsTextView.setText(String.valueOf(millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                playSound();
            }
        }.start();
    }

    private void playSound() {
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.elephant);
        mediaPlayer.start();
    }
}
