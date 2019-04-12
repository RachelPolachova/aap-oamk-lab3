package com.rachel.polachova.aap_lab_3;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

public class MenusActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menus);
        setupMenuButton();
    }


    private void setupMenuButton() {
        Button button = findViewById(R.id.menu_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup(v);
            }
        });
    }

    private void showPopup(View v) {
        PopupMenu popupMenu = new PopupMenu(this, v);
        popupMenu.setOnMenuItemClickListener(this);
        MenuInflater menuInflater = popupMenu.getMenuInflater();
        menuInflater.inflate(R.menu.colors_menu, popupMenu.getMenu());
        popupMenu.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.red:
                setBackgroundRed();
                return true;
            case R.id.green:
                setBackgroundGreen();
                return true;
            case R.id.blue:
                setBackgroundBlue();
                return true;
            case R.id.yellow:
                setBackgroundYellow();
                return true;
                default:
                    return false;
        }
    }

    private void setBackgroundRed() {
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(Color.RED);
    }

    private void setBackgroundGreen() {
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(Color.GREEN);
    }

    private void setBackgroundBlue() {
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(Color.BLUE);
    }

    private void setBackgroundYellow() {
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(Color.YELLOW);
    }
}
