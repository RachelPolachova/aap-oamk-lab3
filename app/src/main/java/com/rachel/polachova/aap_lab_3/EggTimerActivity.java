package com.rachel.polachova.aap_lab_3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class EggTimerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_egg_timer);
        setupStartButton();
    }

    private void setupStartButton() {
        Button startBtn = findViewById(R.id.start_button);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView secondsTextView = findViewById(R.id.seconds_value);
                String text = secondsTextView.getText().toString();
                if (text.matches("[0-9]+")) {
                    Intent i = new Intent(EggTimerActivity.this, CountdownActivity.class);
                    i.putExtra("seconds", Integer.valueOf(text));
                    startActivity(i);
                } else {
                    Toast.makeText(getApplicationContext(), "Insert only numbers please", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
