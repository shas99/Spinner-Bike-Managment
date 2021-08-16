package com.example.spinner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Bicycle_List extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bicycle_list);

        Button addBtn = (Button) findViewById(R.id.button_05);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Bicycle_List.this, BicycleMainMenuActivity.class);
                startActivity(intent);
            }
        });
    }
}