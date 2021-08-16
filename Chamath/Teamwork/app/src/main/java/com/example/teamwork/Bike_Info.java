package com.example.teamwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Bike_Info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bike_info);

        Button addBtn7 = (Button) findViewById(R.id.ok_button);
        addBtn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Bike_Info.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}