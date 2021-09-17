package com.example.spinner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class End_target extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_target);

        Button b1=(Button)findViewById(R.id.Weekly_target10);
        Button b2=(Button)findViewById(R.id.Endridebtn);

        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(End_target.this, Weekly_target.class);
                startActivity(i);
            }

        });
        b2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(End_target.this, UserProfileActivity.class);
                startActivity(i);
            }

        });

    }
}