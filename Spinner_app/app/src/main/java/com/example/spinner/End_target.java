package com.example.spinner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class End_target extends AppCompatActivity {
    DatabaseReference referenceTest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_target);

        referenceTest = FirebaseDatabase.getInstance().getReference("LiveBike");

        String ID = UserDetails.ID();




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
                referenceTest.child(UserDetails.ID()).removeValue();
            }

        });

    }
}