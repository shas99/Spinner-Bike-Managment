package com.mad.spinner_bike_customer_service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;


public class FifthActivity extends AppCompatActivity {
    private RadioButton rButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);

        Button button1,button2;
        Spinner mySpinner = (Spinner)findViewById(R.id.bikesdropdown);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(FifthActivity.this , android.R.layout.simple_list_item_1 , getResources().getStringArray(R.array.bikes));

        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);


        button1 = (Button) findViewById(R.id.creditCardBtn);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity();
            }
        });

        button2 = (Button) findViewById(R.id.submitBtn5);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity2();
            }
        });




    }
    public void openNewActivity(){
        Intent intent = new Intent(this, SixthActivity.class);
        startActivity(intent);
    }
    public void openNewActivity2(){
        Intent intent = new Intent(this, SeventhActivity.class);
        startActivity(intent);
    }





}