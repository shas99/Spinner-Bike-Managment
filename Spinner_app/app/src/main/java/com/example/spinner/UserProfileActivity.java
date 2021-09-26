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
          //Init Assets
        private Button logout;
        private Button orderAbikebtn,updateBtn,deleteBtn,myTaskBtn;
        private FirebaseUser user;
        private DatabaseReference reference;
        private String userID;

    DatabaseReference referenceTest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userprofile);
        referenceTest = FirebaseDatabase.getInstance().getReference("UsersProfile");

        //Layouts hooks
        logout = (Button) findViewById(R.id.LogoutBtn);
        orderAbikebtn =(Button)findViewById(R.id.orderABikeBtn);
        myTaskBtn =(Button)findViewById(R.id.myTasks);
        deleteBtn=(Button)findViewById(R.id.deletebtn555);
        updateBtn=(Button)findViewById(R.id.updatebtn);


        //Handle button logout()
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseAuth.getInstance().signOut();
                Toast.makeText(UserProfileActivity.this, "Hope To See You Again , Bye !", Toast.LENGTH_LONG).show();
                startActivity(new Intent(UserProfileActivity.this,MainActivity.class));


            }



        });
        //Handle button OrderABike()
        orderAbikebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserProfileActivity.this, OrderBikeActivity.class);
                startActivity(intent);



            }
        });
        //MyTask button handle
        myTaskBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserProfileActivity.this, UserFeedback.class);
                startActivity(intent);
            }
        });

      //Handle button deletAxcc()
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                referenceTest.child(UserDetails.ID()).removeValue();
                Toast.makeText(UserProfileActivity.this, "Hope To See You Again , Bye !", Toast.LENGTH_LONG).show();
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(UserProfileActivity.this,MainActivity.class));

            }
        });

      //Update button handling
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserProfileActivity.this, UpdateUserDetailsActivity.class);
                startActivity(intent);

            }
        });







        user =FirebaseAuth.getInstance().getCurrentUser();
        reference= FirebaseDatabase.getInstance().getReference("UsersProfile");
        userID =user.getUid();

         TextView greetTextView= (TextView) findViewById(R.id.emailDisplay);
         TextView nameTextView = (TextView) findViewById(R.id.nameDisplay);
         TextView gender = (TextView) findViewById(R.id.sexDisplay);
         TextView mobileNumber =(TextView) findViewById(R.id.mobileNumberDisplay);


        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
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
                    String Target = userProfile.Target;
                    //saving userDetails
                    UserDetails U1 = new UserDetails(name,email,sex,mobile,points,ID,Target);

                    nameTextView.setText("   Welcome " +name+ "  !  ");
                    greetTextView.setText(email);
                    gender.setText(sex);
                    mobileNumber.setText(mobile);




                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(UserProfileActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();

            }
        });


    }


    }
