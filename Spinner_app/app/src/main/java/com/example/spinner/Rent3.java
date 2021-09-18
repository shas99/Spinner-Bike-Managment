package com.example.spinner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Rent3 extends AppCompatActivity {

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent3);

        Button b1=(Button)findViewById(R.id.StartRidingbtn);

        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("LiveBike");


                Help helperHelp = new Help(UserDetails.ID(),"Test Success 5th attempt! :)");

                reference.child("labadaba dub dub").setValue(helperHelp);


                Intent i = new Intent(Rent3.this, End_target.class);
                startActivity(i);




            }

        });
    }
}