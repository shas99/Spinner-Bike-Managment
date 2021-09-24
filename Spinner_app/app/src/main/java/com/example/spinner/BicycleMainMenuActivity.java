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



    }


}