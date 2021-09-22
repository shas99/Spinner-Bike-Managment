package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class Dashboard extends AppCompatActivity {

    private RelativeLayout myprof;
    private RelativeLayout rent;
    private RelativeLayout ride;
    private RelativeLayout events;
    private RelativeLayout feedback;
    private RelativeLayout review;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        //Hooks

        myprof= (RelativeLayout) findViewById(R.id.myProfile);

        rent=(RelativeLayout) findViewById(R.id.rentBike);

        ride=(RelativeLayout) findViewById(R.id.ride);

        events=(RelativeLayout) findViewById(R.id.Events);

       feedback=(RelativeLayout) findViewById(R.id.provideFeedback);





        myprof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Dashboard.this,UserProfileActivity.class);
                startActivity(intent);
            }
        });

        rent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Dashboard.this,BicycleMainMenuActivity.class);
                startActivity(intent);
            }
        });
        ride.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Dashboard.this, Home.class);
                startActivity(intent);
            }
        });
        events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Dashboard.this,EventsMainActivity.class);
                startActivity(intent);
            }
        });

        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Dashboard.this,UserFeedback.class);
                startActivity(intent);
            }
        });








    }




}