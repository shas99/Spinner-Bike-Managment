package com.example.spinner;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import android.os.Vibrator;

@RequiresApi(api = Build.VERSION_CODES.M)
public class OrderBikeActivity extends AppCompatActivity {

    //Init Assets
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



        //Layouts hooks
            promoCalculate=(TextView)findViewById(R.id.promoCalc);
            collections=(TextView)findViewById(R.id.collections);
            cyclerID =(EditText)findViewById(R.id.cyclerIDInput);
            mobileNo =(EditText) findViewById(R.id.editTextPhone);
            bicycleType= (EditText) findViewById(R.id.bikesDropDown);
            NIC =(EditText)findViewById(R.id.nicInput);
            orderBikeBtn=(Button)findViewById(R.id.myTasks);
            order1 =new BikeOrder();
            myRef=FirebaseDatabase.getInstance().getReference().child("Bike Order Details");

            //MediaPlay instatiate
            final MediaPlayer mp2 = MediaPlayer.create(this, R.raw.success);



        //Handle button order()
        orderBikeBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {



                    String cyclerid = cyclerID.getText().toString().trim();
                    String mobilenumber=mobileNo.getText().toString().trim();
                    String nic =NIC.getText().toString().trim();
                    String bicycleRef = bicycleType.getText().toString().trim();


                    //Validation form
                    if(cyclerid.isEmpty()){
                        cyclerID.setError("Email is required");
                        cyclerID.requestFocus();
                        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                        vibrator.vibrate(400);

                        return;
                    }
                    if(mobilenumber.isEmpty()){
                        mobileNo.setError("Mobile is required");
                        mobileNo.requestFocus();
                        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                        vibrator.vibrate(400);
                        return;
                    }
                    if(nic.isEmpty()){
                        NIC.setError("NIC is required");
                        NIC.requestFocus();
                        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                        vibrator.vibrate(400);
                        return;
                    }
                    if(bicycleRef.isEmpty()){
                        bicycleType.setError("Bicycle type is required");
                        bicycleType.requestFocus();
                        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                        vibrator.vibrate(400);
                        return;
                    }


                    //Set Values to object capsule
                    order1.setCyclerID(cyclerid);
                    order1.setMobileNo(mobilenumber);
                    order1.setNIC(nic);
                    order1.setBicycleType(bicycleRef);

                    //Push capsule to firebase
                    myRef.push().setValue(order1);
                    Toast.makeText(OrderBikeActivity.this, "Successfully Ordered", Toast.LENGTH_SHORT).show();
                    mp2.start();
                    Intent intent = new Intent(OrderBikeActivity.this, UserProfileActivity.class);
                    startActivity(intent);
                }
            });

        //Handle function -> viewCollections
        collections.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(OrderBikeActivity.this, Add_A_Bicycle.class);
                startActivity(intent);
            }
        });
        //Handle function promoCalc
        promoCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderBikeActivity.this,CalculatePrice.class);
                startActivity(intent);
            }
        });
    }



}