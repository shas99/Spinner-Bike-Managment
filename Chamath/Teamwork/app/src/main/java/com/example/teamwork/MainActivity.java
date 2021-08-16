package com.example.teamwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.widget.Button;

import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addBtn = (Button) findViewById(R.id.CREATE);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Bicycle_List.class);
                startActivity(intent);
            }
        });


        Button addBtn2 = (Button) findViewById(R.id.Search_Retreive);
        addBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Add_A_Bicycle.class);
                startActivity(intent);
            }
        });

        Button addBtn3 = (Button) findViewById(R.id.UPDATE);
        addBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Review_Page.class);
                startActivity(intent);
            }
        });

        Button addBtn4 = (Button) findViewById(R.id.DELETE);
        addBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,My_Delete.class);
                startActivity(intent);
            }
        });

        Button addBtn5 = (Button) findViewById(R.id.SELECT);
        addBtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Upgrades_1.class);
                startActivity(intent);
            }
        });


    }


}