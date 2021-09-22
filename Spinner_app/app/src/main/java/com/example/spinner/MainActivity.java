package com.example.spinner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


private TextView register,forgotpassword;
private EditText emailLogin,passwordLogin;
private Button loginBtn;


private FirebaseAuth mAuth;
private ProgressBar progressBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
register=(TextView) findViewById(R.id.register);
register.setOnClickListener(this);

forgotpassword=(TextView)findViewById(R.id.forgotPassword);
forgotpassword.setOnClickListener(this);



loginBtn=(Button) findViewById(R.id.btnLogin);
        loginBtn.setOnClickListener(this);
        emailLogin=(EditText)findViewById(R.id.emailLogin);
        passwordLogin=(EditText) findViewById(R.id.passwordLogin);

        mAuth= FirebaseAuth.getInstance();


    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.register:
                startActivity(new Intent(this,CreateProfileActivity.class));
                break;
            case R.id.btnLogin:
                userLogin();
                break;
            case R.id.forgotPassword:
                startActivity(new Intent(this,ForgotPasswordActivity.class));

        }
    }

    private void userLogin() {

        String emailLoginInput = emailLogin.getText().toString().trim();
        String passwordLoginInput = passwordLogin.getText().toString().trim();

            if(emailLoginInput.isEmpty()){
                emailLogin.setError("Email is required");
                emailLogin.requestFocus();
                return;
            }
        if(passwordLoginInput.isEmpty()){
            passwordLogin.setError("Email is required");
            passwordLogin.requestFocus();
            return;
        }

        mAuth.signInWithEmailAndPassword(emailLoginInput,passwordLoginInput)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){

                            FirebaseUser user =FirebaseAuth.getInstance().getCurrentUser();
                            if(user.isEmailVerified()){
                                startActivity(new Intent(MainActivity.this,Dashboard.class));
                            }else{
                                user.sendEmailVerification();
                                Toast.makeText(MainActivity.this, "Check your email to confirm account", Toast.LENGTH_SHORT).show();
                            }



                        }else{
                            Toast.makeText(MainActivity.this, "Failed to login ", Toast.LENGTH_SHORT).show();
                        }
                    }
                });




    }
}