package com.rachel.polachova.aap_lab_3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setupButtons();
	}

	private void setupButtons() {
		setupMenusButton();
	}

	private void setupMenusButton() {
		Button menusBtn = findViewById(R.id.menus);
		menusBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(MainActivity.this, MenusActivity.class);
				startActivity(i);
			}
		});
	}

}
