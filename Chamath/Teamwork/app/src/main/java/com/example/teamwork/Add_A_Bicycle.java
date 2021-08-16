package com.example.teamwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Add_A_Bicycle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_abicycle);

        Button addBtn8 = (Button) findViewById(R.id.img_bott2);
        addBtn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Add_A_Bicycle.this,Bike_Info.class);
                startActivity(intent);
            }
        });
    }


}