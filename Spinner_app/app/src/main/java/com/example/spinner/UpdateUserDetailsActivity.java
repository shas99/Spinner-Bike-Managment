package com.example.spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class UpdateUserDetailsActivity extends AppCompatActivity {

EditText emailEdit,nameEdit,phoneEdit;

    FirebaseDatabase db =FirebaseDatabase.getInstance();
    private DatabaseReference reference;
    private String userID;
    private Button updateBtn1;
    DatabaseReference myRef =db.getReference("UsersProfile");




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user_details);

        emailEdit=findViewById(R.id.UpdateEmailInput);
        nameEdit=findViewById(R.id.NameUpdateText);
        phoneEdit=findViewById(R.id.MobileNumberUpdate);
        updateBtn1=findViewById(R.id.updateDetailsBtn);

updateBtn1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String email = emailEdit.getText().toString().trim();
        String name =nameEdit.getText().toString().trim();
        String phone =phoneEdit.getText().toString().trim();

        HashMap hashMap =new HashMap();
        hashMap.put("Email",email);
        hashMap.put("Name",name);
        hashMap.put("MobileNo",phone );
        myRef.updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
            @Override
            public void onSuccess(Object o) {
                Toast.makeText(UpdateUserDetailsActivity.this, "Data Updated", Toast.LENGTH_SHORT).show();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(UpdateUserDetailsActivity.this, "Error in updating", Toast.LENGTH_SHORT).show();

            }

        });
    }
});







    }



}