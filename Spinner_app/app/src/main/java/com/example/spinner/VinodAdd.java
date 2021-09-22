package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.ArrayMap;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import android.os.Bundle;
import android.widget.Spinner;
import android.widget.Toast;

public class VinodAdd extends AppCompatActivity implements AdapterView.OnItemClickListener {
    FirebaseDatabase rootNode;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vinod_add);

        Button addBtn = (Button) findViewById(R.id.button_05Vinod);

        addBtn.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View view) {


                EditText Brand = findViewById(R.id.id_1Vinod);


                String test1 = Brand.getText().toString();




                EditText Name = findViewById(R.id.ID_2Vinod);


                String test2 = Name.getText().toString();



                EditText Origin = findViewById(R.id.id_3Vinod);


                String test3 = Origin.getText().toString();




                EditText Review = findViewById(R.id.id_4Vinod);


                String test4 = Review.getText().toString();




                EditText id5 = findViewById(R.id.id_9999Vinod);


                String test5 = id5.getText().toString();



                EditText link = findViewById(R.id.id_4Vinod122);


                String test6 = link.getText().toString();

                EditText status = findViewById(R.id.status123);

                String test7 = status.getText().toString();


                Toast.makeText(VinodAdd.this, "Event has been created", Toast.LENGTH_SHORT).show();






                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("Event Management");

                Event_Model obj = new Event_Model(test1,test2,test3,test4,test6,test7);

                reference.child(test5).setValue(obj);













            }
        });
    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        System.out.print("tupe"+text);
    }
}