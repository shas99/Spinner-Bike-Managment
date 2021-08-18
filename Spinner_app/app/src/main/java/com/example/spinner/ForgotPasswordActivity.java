package com.example.spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPasswordActivity extends AppCompatActivity {

private EditText emailResetText;
private Button resetBtn;

FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        emailResetText =(EditText) findViewById(R.id.resetPasswordEmailInput);
        resetBtn=(Button) findViewById(R.id.resetPasswordBtn);

        auth =FirebaseAuth.getInstance();

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetPassword();
            }
        });

    }

    private void resetPassword() {

        String email =emailResetText.getText().toString().trim();
        if(email.isEmpty()){
            emailResetText.setError("Email is required");
            emailResetText.requestFocus();
            return;
        }
        auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
           if(task.isSuccessful()){
               Toast.makeText(ForgotPasswordActivity.this, "Check your email to reset", Toast.LENGTH_LONG).show();

           }   else{
               Toast.makeText(ForgotPasswordActivity.this, "Try again !", Toast.LENGTH_LONG).show();
           }
            }
        });

    }
}