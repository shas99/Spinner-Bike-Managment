package com.example.spinner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class OrderBikeActivity extends AppCompatActivity {

    private EditText cyclerID,mobileNo,NIC;
    private EditText bicycleType;
    private FirebaseDatabase database;
    private Button orderBikeBtn;
    BikeOrder order1;
    private TextView collections,promoCalculate;

    private DatabaseReference myRef;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderbike);




        promoCalculate=(TextView)findViewById(R.id.promoCalc);
        collections=(TextView)findViewById(R.id.collections);
            cyclerID =(EditText)findViewById(R.id.cyclerIDInput);
            mobileNo =(EditText) findViewById(R.id.editTextPhone);
            bicycleType= (EditText) findViewById(R.id.bikesDropDown);
            NIC =(EditText)findViewById(R.id.nicInput);
            orderBikeBtn=(Button)findViewById(R.id.myTasks);
            order1 =new BikeOrder();
            myRef=FirebaseDatabase.getInstance().getReference().child("Bike Order Details");

            orderBikeBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String cyclerid = cyclerID.getText().toString().trim();
                    String mobilenumber=mobileNo.getText().toString().trim();
                    String nic =NIC.getText().toString().trim();
                    String bicycleRef = bicycleType.getText().toString().trim();

                    order1.setCyclerID(cyclerid);
                    order1.setMobileNo(mobilenumber);
                    order1.setNIC(nic);
                    order1.setBicycleType(bicycleRef);

                    myRef.push().setValue(order1);
                    Toast.makeText(OrderBikeActivity.this, "Successfully Ordered", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(OrderBikeActivity.this, UserProfileActivity.class);
                    startActivity(intent);






                }
            });
        collections.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(OrderBikeActivity.this, Add_A_Bicycle.class);
                startActivity(intent);






            }
        });

        promoCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(OrderBikeActivity.this,CalculatePrice.class);
                startActivity(intent);






            }
        });






        

        
    }



}