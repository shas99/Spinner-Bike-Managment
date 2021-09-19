package com.example.spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.*;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class UpdateUserDetailsActivity extends AppCompatActivity {

    DatabaseReference reference;
    public String ID;

    EditText  nameEdit, phoneEdit, gmail;

    FirebaseDatabase db = FirebaseDatabase.getInstance();


    private String userID;
    private Button updateBtn1;


    DatabaseReference myRef = db.getReference("UsersProfile");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        reference = FirebaseDatabase.getInstance().getReference("UsersProfile");
        ID = UserDetails.ID();


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user_details);




    }

    public void google(View view){

        if(isChaged()){
            Toast.makeText(this, "Data has been updated", Toast.LENGTH_SHORT).show();
        }


    }

    private boolean isChaged(){







            gmail = findViewById(R.id.google);
            nameEdit = findViewById(R.id.NameUpdateText500);
            phoneEdit = findViewById(R.id.MobileNumberUpdate500);
            updateBtn1 = findViewById(R.id.updateDetailsBtn);

            String email = gmail.getText().toString().trim();
            String name = nameEdit.getText().toString().trim();
            String phone = phoneEdit.getText().toString().trim();




            System.out.println("qqqq" + email + name + phone);

            reference.child(ID).child("email").setValue(email);


            reference.child(ID).child("name").setValue(name);




            reference.child(ID).child("mobileNo").setValue(phone);





            return true;



    }


}




