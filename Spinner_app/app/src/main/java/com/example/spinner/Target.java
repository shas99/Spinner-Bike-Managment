package com.example.spinner;

import android.content.Intent;
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
            //recreate Weekly_target
            Weekly_target.self_intent.recreate();
            Intent i = new Intent(Target.this,Weekly_target.class);
            startActivity(i);
        }
    }


    private boolean isChaged(){
        EditText txtname = findViewById(R.id.emailInput);
        String name = txtname.getText().toString();
        if (txtname.length() == 0) {
            txtname.setError("This field is required");
            reference.child(UserDetails.ID()).child("Target").setValue("0");
        return false;
        }else if(!UserDetails.getTarget().equals(z)){






            reference.child(UserDetails.ID()).child("Target").setValue(name);
            return true;
        }
        else{
            return false;
        }


    }
}