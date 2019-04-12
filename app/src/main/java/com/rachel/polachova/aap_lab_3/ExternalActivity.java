package com.rachel.polachova.aap_lab_3;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ExternalActivity extends AppCompatActivity {

    int REQUEST_PHONE_CALL = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external);
        setupButtons();
    }

    private void setupButtons() {
        setupOpenMapButton();
        setupCallButton();
        setupOpenWebsiteButton();
    }

    private void setupOpenMapButton() {
        Button mapBtn = findViewById(R.id.open_map);
        mapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMap();
            }
        });
    }

    private void openMap() {
        Double lat = 64.9996576;
        Double lon = 25.5107027;
        Uri location = Uri.parse("geo:" + lat + "," + lon);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
        startActivity(mapIntent);
    }

    private void setupCallButton() {
        Button callButton = findViewById(R.id.call);
        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeCall();
            }
        });
    }

    private void makeCall() {
        Uri number = Uri.parse("tel:+3582061102000");
        Intent callIntent = new Intent(Intent.ACTION_DIAL, number);

        startActivity(callIntent);


    }

    private void setupOpenWebsiteButton() {
        final Button openWebsiteButton = findViewById(R.id.go);
        openWebsiteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebsite();
            }
        });
    }

    private void openWebsite() {
        TextView textView = findViewById(R.id.website_url);
        if (textView.length() > 0 && textView.getText().toString().contains("http")) {

            Uri url = Uri.parse(textView.getText().toString());
            Intent websiteIntent = new Intent(Intent.ACTION_VIEW, url);
            startActivity(websiteIntent);

        } else {
            Toast.makeText(getApplicationContext(), "Enter url please", Toast.LENGTH_SHORT).show();
        }
    }
}
