package com.example.spinner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;


public class OrderBikeActivity extends AppCompatActivity {
    private RadioButton rButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderbike);

        Button button1,button2;
        Spinner mySpinner = (Spinner)findViewById(R.id.bikesdropdown);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(OrderBikeActivity.this , android.R.layout.simple_list_item_1 , getResources().getStringArray(R.array.bikes));

        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);




        button2 = (Button) findViewById(R.id.submitBtn5);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity2();
            }
        });




    }

    public void openNewActivity2(){
        Intent intent = new Intent(this, ShipBikeActivity.class);
        startActivity(intent);
    }





}