package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class GridMenu extends AppCompatActivity {

    ImageButton buttonG1;
    ImageButton buttonG2;
    ImageButton buttonG3;
    ImageButton buttonG4;
    Button buttonM1;
    Button buttonM2;
    Button buttonM3;
    Button buttonM4;


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


        buttonM1 = (Button) findViewById(R.id.button9);
        buttonM1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity();
            }
        });

        buttonM2 = (Button) findViewById(R.id.button10);
        buttonM2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                openNewActivity1();
            }
        });

        buttonM3 = (Button) findViewById(R.id.button12);
        buttonM3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {
                openNewActivity2();
            }
        });

        buttonM4 = (Button) findViewById(R.id.button11);
        buttonM4.setOnClickListener(new View.OnClickListener() {
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
        Intent intent = new Intent(this, Event_List.class);
        startActivity(intent);
    }
}