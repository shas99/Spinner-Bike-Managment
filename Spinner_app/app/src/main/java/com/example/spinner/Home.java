package com.example.spinner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //user details
        String name = UserDetails.getName();
        String email = UserDetails.getEmail();
        String phone = UserDetails.getMobileNo();
        String sex = UserDetails.getSex();
        String points = UserDetails.getPoints();

        System.out.println("Details are : " + "Name:" + name + " Email:" + email + " Mobile Number:" + phone + " Sex:" + sex + " Points:" + points);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button b1=(Button)findViewById(R.id.btnRent);
        Button b2=(Button)findViewById(R.id.btnDonate);

        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(Home.this,Rent2.class);
                startActivity(i);
        }

        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Home.this,Donate.class);
                startActivity(i);
            }
        });
    }

    }
