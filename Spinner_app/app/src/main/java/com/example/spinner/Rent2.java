package com.example.spinner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Rent2 extends AppCompatActivity {
private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent2);

        button = (Button) findViewById(R.id.btnChoose);
        button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });


        }
    public void openActivity2(){
        Intent intent = new Intent(this,Confirm.class);
        startActivity(intent);
    }



}