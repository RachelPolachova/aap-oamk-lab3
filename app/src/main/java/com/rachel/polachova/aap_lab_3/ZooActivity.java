package com.rachel.polachova.aap_lab_3;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupMenu;

public class ZooActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    boolean mammals = true;
    ImageButton button1;
    ImageButton button2;
    ImageButton button3;
    ImageButton button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoo);
        setupButtons();
        setAsMammals(); // init setup
    }

    private void setupButtons() {
        button1 = findViewById(R.id.button_1);
        button2 = findViewById(R.id.button_2);
        button3 = findViewById(R.id.button_3);
        button4 = findViewById(R.id.button_4);

        setupMenuButton();
        setupButton1();
        setupButton2();
        setupButton3();
        setupButton4();
    }

    private void setupMenuButton() {
        Button menuButton = findViewById(R.id.show_animal_menu);
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup(v);
            }
        });
    }

    private void setupButton1() {
        ImageButton button = findViewById(R.id.button_1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playButton1();
            }
        });
    }

    private void setupButton2() {
        ImageButton button = findViewById(R.id.button_2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playButton2();
            }
        });
    }

    private void setupButton3() {
        ImageButton button = findViewById(R.id.button_3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playButton3();
            }
        });
    }

    private void setupButton4() {
        ImageButton button = findViewById(R.id.button_4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playButton4();
            }
        });
    }

    private void showPopup(View v) {
        PopupMenu popupMenu = new PopupMenu(this, v);
        popupMenu.setOnMenuItemClickListener(this);
        MenuInflater menuInflater = popupMenu.getMenuInflater();
        menuInflater.inflate(R.menu.animals_menu, popupMenu.getMenu());
        popupMenu.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.mammals:
                setAsMammals();
                mammals = true;
                return true;
            case R.id.birds:
                setAsBirds();
                mammals = false;
                return true;
            default:
                return false;
        }
    }

    private void setAsMammals() {
        button1.setImageResource(R.drawable.bear);
        button2.setImageResource(R.drawable.wolf);
        button3.setImageResource(R.drawable.elephant);
        button4.setImageResource(R.drawable.lamb);
    }

    private void setAsBirds() {
        button1.setImageResource(R.drawable.huuhkaja);
        button2.setImageResource(R.drawable.peippo);
        button3.setImageResource(R.drawable.peukaloinen);
        button4.setImageResource(R.drawable.punatulkku);
    }


    private void playButton1() {
        MediaPlayer mediaPlayer;
        if (mammals) {
            mediaPlayer = MediaPlayer.create(this, R.raw.bear);
        } else {
            mediaPlayer = MediaPlayer.create(this, R.raw.huuhkaja_norther_eagle_owl);
        }

        mediaPlayer.start();
    }

    private void playButton2() {

        MediaPlayer mediaPlayer;
        if (mammals) {
            mediaPlayer = MediaPlayer.create(this, R.raw.wolf);
        } else {
            mediaPlayer = MediaPlayer.create(this, R.raw.peippo_chaffinch);
        }

        mediaPlayer.start();

    }

    private void playButton3() {

        MediaPlayer mediaPlayer;
        if (mammals) {
            mediaPlayer = MediaPlayer.create(this, R.raw.elephant);
        } else {
            mediaPlayer = MediaPlayer.create(this, R.raw.peukaloinen_wren);
        }

        mediaPlayer.start();

    }

    private void playButton4() {

        MediaPlayer mediaPlayer;
        if (mammals) {
            mediaPlayer = MediaPlayer.create(this, R.raw.lamb);
        } else {
            mediaPlayer = MediaPlayer.create(this, R.raw.punatulkku_northern_bullfinch);
        }

        mediaPlayer.start();

    }
}
