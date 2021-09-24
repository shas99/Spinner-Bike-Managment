package com.example.spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;



import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class GridMenu extends AppCompatActivity {

    ImageButton buttonG1;
    ImageButton buttonG2;
    ImageButton buttonG3;
    ImageButton buttonG4;
    Button buttonM1;
    Button buttonM2;
    Button buttonM3;
    Button buttonM4;
    DatabaseReference referenceret;

    private FirebaseUser user;

    private String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_menu);

        //to retreive information
        referenceret= FirebaseDatabase.getInstance().getReference("UsersProfile");
        user = FirebaseAuth.getInstance().getCurrentUser();
        userID =user.getUid();
        referenceret.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userProfile =snapshot.getValue(User.class);

                if(userProfile !=null){
                    String name =userProfile.name;
                    String email=userProfile.email;
                    String sex =userProfile.sex;
                    String mobile =userProfile.mobileNo;
                    String points = userProfile.Points;
                    String ID = user.getUid();
                    String Target5 = userProfile.Target;
                    //saving userDetails
                    UserDetails U1 = new UserDetails(name,email,sex,mobile,points,ID,Target5);






                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(GridMenu.this, "Something went wrong", Toast.LENGTH_SHORT).show();

            }
        });




        ImageButton buttonG1 = (ImageButton) findViewById(R.id.imageButton10);
        buttonG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity();
            }
        });

        ImageButton buttonG2 = (ImageButton) findViewById(R.id.imageButton8);
        buttonG2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                openNewActivity1();
            }
        });

        ImageButton buttonG3 = (ImageButton) findViewById(R.id.imageButton9);
        buttonG3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {
                openNewActivity2();
            }
        });

        ImageButton buttonG4 = (ImageButton) findViewById(R.id.imageButton6);
        buttonG4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v3) {
                openNewActivity3();
            }
        });


        buttonM1 = (Button) findViewById(R.id.button9);
        buttonM1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity();
            }
        });

        buttonM2 = (Button) findViewById(R.id.button10);
        buttonM2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                openNewActivity1();
            }
        });

        buttonM3 = (Button) findViewById(R.id.button12);
        buttonM3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {
                openNewActivity2();
            }
        });

        buttonM4 = (Button) findViewById(R.id.button11);
        buttonM4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v3) {
                openNewActivity3();
            }
        });

    }

    public void openNewActivity(){
        Intent intent = new Intent(this, UserProfileActivity.class);
        startActivity(intent);
    }
    public void openNewActivity1(){
        Intent intent = new Intent(this, BicycleMainMenuActivity.class);
        startActivity(intent);
    }
    public void openNewActivity2(){
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }
    public void openNewActivity3(){
        Intent intent = new Intent(this, Event_List.class);
        startActivity(intent);
    }
}