package com.example.spinner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Upgrades_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upgrades1);

        Button addBtn13 = (Button) findViewById(R.id.button_upgrade);
        addBtn13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Upgrades_1.this, com.example.spinner.Upgrades_2.class);
                startActivity(intent);
            }
        });
    }
}