package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class GridMenu extends AppCompatActivity {

    ImageButton buttonG1;
    ImageButton buttonG2;
    ImageButton buttonG3;
    ImageButton buttonG4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_menu);

        ImageButton buttonG1 = (ImageButton) findViewById(R.id.imageButton10);
        buttonG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity();
            }
        });

        ImageButton buttonG2 = (ImageButton) findViewById(R.id.imageButton8);
        buttonG2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                openNewActivity1();
            }
        });

        ImageButton buttonG3 = (ImageButton) findViewById(R.id.imageButton9);
        buttonG3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {
                openNewActivity2();
            }
        });

        ImageButton buttonG4 = (ImageButton) findViewById(R.id.imageButton6);
        buttonG4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v3) {
                openNewActivity3();
            }
        });

    }

    public void openNewActivity(){
        Intent intent = new Intent(this, UserProfileActivity.class);
        startActivity(intent);
    }
    public void openNewActivity1(){
        Intent intent = new Intent(this, BicycleMainMenuActivity.class);
        startActivity(intent);
    }
    public void openNewActivity2(){
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }
    public void openNewActivity3(){
        Intent intent = new Intent(this, EventsMainActivity.class);
        startActivity(intent);
    }
}