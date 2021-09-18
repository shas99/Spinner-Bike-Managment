package com.example.spinner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Bicycle_List extends AppCompatActivity {
FirebaseDatabase rootNode;
DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bicycle_list);

        Button addBtn = (Button) findViewById(R.id.button_05);




        addBtn.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View view) {


                EditText Brand = findViewById(R.id.id_1);


                String test1 = Brand.getText().toString();




                EditText Name = findViewById(R.id.ID_2);


                String test2 = Name.getText().toString();



                EditText Origin = findViewById(R.id.id_3);


                String test3 = Origin.getText().toString();




                EditText Review = findViewById(R.id.id_4);


                String test4 = Review.getText().toString();



                EditText id5 = findViewById(R.id.id_9999);


                String test5 = id5.getText().toString();





                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("Bicycle Management");

                CreateTest obj = new CreateTest(test1,test2,test3,test4,test5);

                reference.child(test5).setValue(obj);










                Intent intent = new Intent(Bicycle_List.this, BicycleMainMenuActivity.class);

                startActivity(intent);
            }
        });




    }
}