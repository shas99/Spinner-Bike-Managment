package com.example.spinner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

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




                EditText Image = findViewById(R.id.id_chamzz);


                String test6 = Image.getText().toString();



                EditText Lease = findViewById(R.id.id_lease);


                String test7 = Lease.getText().toString();



                EditText id5 = findViewById(R.id.id_9999);


                String test5 = id5.getText().toString();

                String[] date = Calendar.getInstance().getTime().toString().split(" ");
                String Day = date[2];
                String Year = date[5];



                if(test1.isEmpty()){
                    Brand.setError("Brand Name Is Required!!!");
                    Brand.requestFocus();
                    return;
                }

                if(test2.isEmpty()){
                    Name.setError("Bicycle Name Is Required!!!");
                    Name.requestFocus();
                    return;
                }

                if(test3.isEmpty()){
                    Origin.setError("Bicycle Origin Country Is Required!!!");
                    Origin.requestFocus();
                    return;
                }

                if(test4.isEmpty()){
                    Review.setError("Bicycle Review Is Required!!!");
                    Review.requestFocus();
                    return;
                }

                if(test6.isEmpty()){
                    Image.setError("Bicycle Image Is Required!!!");
                    Image.requestFocus();
                    return;
                }

                if(test5.isEmpty()){
                    id5.setError("A Bicycle Key Should Be Given Of Your Choice!!!");
                    id5.requestFocus();
                    return;
                }

                if(Integer.parseInt(test7) > 12){
                    Lease.setError("The Number Of Months Cannot Exceed 12!");
                    Lease.requestFocus();
                    return;
                }


                Toast.makeText(Bicycle_List.this, "A New Bicycle Has Been Added To The Inventory!", Toast.LENGTH_SHORT).show();




                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("Bicycle Management");

                CreateTest obj = new CreateTest(test1,test2,test3,test4,test5,test6,test7,Day,Year);

                reference.child(test5).setValue(obj);










                Intent intent = new Intent(Bicycle_List.this, BicycleMainMenuActivity.class);

                startActivity(intent);
            }
        });




    }
}