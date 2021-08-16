package com.example.spinner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class UserProfileActivity extends AppCompatActivity {
    Button button;
    Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userprofile);


        button = (Button) findViewById(R.id.updatebtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity();
            }
        });

        button2 = (Button) findViewById(R.id.deletebtn);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity2();
            }
        });
    }
    public void openNewActivity(){
        Intent intent = new Intent(this, CreateProfileActivity.class);
        startActivity(intent);
    }
    public void openNewActivity2(){
        Intent intent = new Intent(this, OrderBikeActivity.class);
        startActivity(intent);
    }
}