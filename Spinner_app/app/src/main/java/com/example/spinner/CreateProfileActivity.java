package com.example.spinner;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;

public class CreateProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView emailBanner;
    private Button registerUser;

    private EditText emailInput,nameInput,passwordInput,sexInput,mobileNumberInput;

    private static final int CAMERA_REQUEST =1888;
    ImageView imageView;


    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createprofile);
        mAuth = FirebaseAuth.getInstance();

emailBanner =(TextView) findViewById(R.id.emailBanner);
emailBanner.setOnClickListener(this);


registerUser =(Button)findViewById(R.id.registerUser);
registerUser.setOnClickListener(this);

emailInput =(EditText) findViewById(R.id.emailInput);
nameInput=(EditText) findViewById(R.id.nameInput);
passwordInput=(EditText) findViewById(R.id.passwordInput);
sexInput=(EditText) findViewById(R.id.sexInput);
mobileNumberInput=(EditText)findViewById(R.id.mobileNumberInput);

imageView =(ImageView) findViewById(R.id.camerPic);
Button photoButton =(Button) findViewById(R.id.uploadBtn);

photoButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent cameraIntent =new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent,CAMERA_REQUEST);
    }
});




    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==CAMERA_REQUEST){
            Bitmap photo = (Bitmap) data.getExtras().get("Data");
            imageView.setImageBitmap(photo);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.registerUser:
                registerUser();
                break;
        }

    }

    private void registerUser() {
        String email =emailInput.getText().toString().trim();
        String name =nameInput.getText().toString().trim();
        String password =passwordInput.getText().toString().trim();
        String sex =sexInput.getText().toString().trim();
        String mobileNo =mobileNumberInput.getText().toString().trim();


        if(name.isEmpty()){
            nameInput.setError("Name is required");
            nameInput.requestFocus();
            return;
        }
        if(email.isEmpty()){
            emailInput.setError("email is required");
            emailInput.requestFocus();
            return;
        } if(password.isEmpty()){
            passwordInput.setError("Password is required");
            passwordInput.requestFocus();
            return;
        } if(sex.isEmpty()){
            sexInput.setError("sex is required");
            sexInput.requestFocus();
            return;
        }
        if(mobileNo.isEmpty()){
            mobileNumberInput.setError("Phone number is required");
            mobileNumberInput.requestFocus();
            return;
        }


        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                    public void onComplete(@NonNull Task<AuthResult> task){
        if(task.isSuccessful()){
                  User user =new User(name,email,sex,mobileNo,"100","120");

                             FirebaseDatabase.getInstance().getReference("UsersProfile")
                                     .child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                 @Override
                                 public void onComplete(@NonNull Task<Void> task) {
                                     if(task.isSuccessful()){
                                         Toast.makeText(CreateProfileActivity.this,"User is registered" ,Toast.LENGTH_LONG).show();

                                     }else{
                                         Toast.makeText(CreateProfileActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                     }
                                 }
                             });


                        }else{
                      Toast.makeText(CreateProfileActivity.this,task.getException().getMessage(), Toast.LENGTH_SHORT).show();

        }
                    }

                });



    }
}