package com.example.spinner;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Target extends AppCompatActivity {
    DatabaseReference reference;

    EditText text;
    public static String z = "5454";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target);

        reference = FirebaseDatabase.getInstance().getReference("UsersProfile");



    }

    public void update55(View view){
        if(isChaged()){
            Toast.makeText(this, "Data has been updated", Toast.LENGTH_SHORT).show();
        }
    }


    private boolean isChaged(){

        if(!UserDetails.getTarget().equals(z)){
            EditText txtname = findViewById(R.id.emailInput);
            String name = txtname.getText().toString();

            System.out.println("Hello " + name);

            reference.child(UserDetails.ID()).child("Target").setValue(name);
            return true;
        }
        else{
            return false;
        }

    }
}