package com.example.eventadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.content.Intent;

import android.os.Bundle;
import android.widget.ImageButton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class EventAdminMain extends AppCompatActivity {

    ImageButton button1;
    ImageButton imageButton15;
    FloatingActionButton buttonF;
    Button buttonE22;
    Button buttonD1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_admin_main);
        FloatingActionButton buttonF  = (FloatingActionButton) findViewById(R.id.floatingActionButton2);
        buttonF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity();
            }
        });
        Button buttonD1  = (Button) findViewById(R.id.buttonD20);
        buttonD1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {
                openNewActivity1();
            }
        });
    }
    public void openNewActivity(){
        Intent intent = new Intent(this, Create.class);
        startActivity(intent);
    }
    public void openNewActivity1(){
        Intent intent1 = new Intent(this, Delete_Event.class);
        startActivity(intent1);
    }
}