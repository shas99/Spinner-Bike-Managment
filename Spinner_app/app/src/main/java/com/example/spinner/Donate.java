package com.example.spinner;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Donate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);



        String points = UserDetails.getPoints();

        System.out.println(points);
        TextView Donation = (TextView) findViewById(R.id.pointsView);
        Donation.setText(points);
    }
}