package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class VinodMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vinod_menu);



        Button buttonG4 = (Button) findViewById(R.id.buttonVinod50);
        buttonG4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v3) {
                openNewActivity3();
            }
        });


    }

    public void openNewActivity3(){
        Intent intent = new Intent(this, VinodAdd.class);
        startActivity(intent);
    }

}