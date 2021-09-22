package com.example.spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Dashboard extends AppCompatActivity {

    private RelativeLayout myprof;
    private RelativeLayout rent;
    private RelativeLayout ride;
    private RelativeLayout events;
    private RelativeLayout feedback;
    private RelativeLayout review;

    DatabaseReference referenceret;

    private FirebaseUser user;

    private String userID;






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

                Intent intent = new Intent(Dashboard.this,Event_List.class);
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

                Toast.makeText(Dashboard.this, "Something went wrong", Toast.LENGTH_SHORT).show();

            }
        });




    }




}