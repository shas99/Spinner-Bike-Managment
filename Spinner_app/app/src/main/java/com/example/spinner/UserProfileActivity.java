package com.example.spinner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

public class UserProfileActivity extends AppCompatActivity {

private Button logout;

private FirebaseUser user;
private DatabaseReference reference;
private String userID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userprofile);

        logout = (Button) findViewById(R.id.LogoutBtn);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(UserProfileActivity.this,MainActivity.class));


            }
        });

        user =FirebaseAuth.getInstance().getCurrentUser();
        reference= FirebaseDatabase.getInstance().getReference("UsersProfile");
        userID =user.getUid();

        final TextView greetTextView= (TextView) findViewById(R.id.emailDisplay);
        final TextView nameTextView = (TextView) findViewById(R.id.nameDisplay);
        final TextView gender = (TextView) findViewById(R.id.sexDisplay);


        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userProfile =snapshot.getValue(User.class);

                if(userProfile !=null){
                    String name =userProfile.name;
                    String email=userProfile.email;
                    String sex =userProfile.sex;

                    nameTextView.setText("Welcome " +name+ "!");
                    greetTextView.setText(email);
                    gender.setText(sex);




                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(UserProfileActivity.this, "Something wne wrong", Toast.LENGTH_SHORT).show();
                
            }
        });


    }

    }
