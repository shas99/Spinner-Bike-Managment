package com.example.spinner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class BicycleMainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bicyclemainmenu);

        Button addBtn = (Button) findViewById(R.id.CREATE);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BicycleMainMenuActivity.this,Bicycle_List.class);
                startActivity(intent);
            }
        });


        Button addBtn2 = (Button) findViewById(R.id.Search_Retreive);
        addBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BicycleMainMenuActivity.this,Add_A_Bicycle.class);
                startActivity(intent);
            }
        });

        Button addBtn3 = (Button) findViewById(R.id.UPDATE);
        addBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BicycleMainMenuActivity.this,Review_Page.class);
                startActivity(intent);
            }
        });

        Button addBtn4 = (Button) findViewById(R.id.DELETE);
        addBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BicycleMainMenuActivity.this,My_Delete.class);
                startActivity(intent);
            }
        });

        Button addBtn5 = (Button) findViewById(R.id.SELECT);
        addBtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BicycleMainMenuActivity.this,Upgrades_1.class);
                startActivity(intent);
            }
        });


    }


}