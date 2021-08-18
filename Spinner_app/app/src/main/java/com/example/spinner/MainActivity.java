package com.example.spinner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


private TextView register;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
register=(TextView) findViewById(R.id.register);

register.setOnClickListener(this);



    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.register:
                startActivity(new Intent(this,CreateProfileActivity.class));
                break;
        }
    }
}