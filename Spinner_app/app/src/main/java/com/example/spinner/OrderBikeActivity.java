package com.example.spinner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;


public class OrderBikeActivity extends AppCompatActivity {

    private EditText cyclerID,mobileNo,NIC;
    private EditText bicycleType;
    private FirebaseDatabase database;
    private Button orderBikeBtn;
    BikeOrder order1;

    private DatabaseReference myRef;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderbike);






            cyclerID =(EditText)findViewById(R.id.cyclerIDInput);
            mobileNo =(EditText) findViewById(R.id.editTextPhone);
            bicycleType= (EditText) findViewById(R.id.bikesDropDown);
            NIC =(EditText)findViewById(R.id.nicInput);
            orderBikeBtn=(Button)findViewById(R.id.orderABikeBtn);
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
                    Toast.makeText(OrderBikeActivity.this, "Successfully Data inserted", Toast.LENGTH_SHORT).show();






                }
            });






        insertOrderData();
        

        
    }

    private void insertOrderData() {
    }


}