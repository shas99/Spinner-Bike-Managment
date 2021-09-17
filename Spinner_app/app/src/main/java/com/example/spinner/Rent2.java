package com.example.spinner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Rent2 extends AppCompatActivity {
private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent2);


        String points = UserDetails.getPoints();
        TextView point = (TextView) findViewById(R.id.points55);
        point.setText(points);




        button = (Button) findViewById(R.id.btnChoose5);
        button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });


        }
    public void openActivity2(){
        Intent intent = new Intent(Rent2.this,Rent3.class);
        startActivity(intent);
    }



}