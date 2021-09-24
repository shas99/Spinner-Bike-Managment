package com.example.spinner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.Calendar;
public class Rent3 extends AppCompatActivity {

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    public String gg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent3);

        Button b1=(Button)findViewById(R.id.StartRidingbtn);
        //
        String[] date = Calendar.getInstance().getTime().toString().split(" ");

        AcceptRide A = new AcceptRide(BikeType.getPremium(),BikeType.getSize(),date[3],date[2] + "/" + date[1] + "/" + date[5]);

        System.out.println("gggggg BikeType:" + AcceptRide.getPremium() + " BikeSize: " + AcceptRide.getSize() + " Time: " + AcceptRide.getTime() + " Date: " + AcceptRide.getDate());

        System.out.println("This is time " + date[3] + ", this is date " + date[2] + "/" + date[1] + "/" + date[5]);

        TextView Size = (TextView) findViewById(R.id.SizetxtView);
        Size.setText(BikeType.getSize());


        String price = "100";
        float temp = 0;

        System.out.println("***" + AcceptRide.getSize() + "***");
        String d = AcceptRide.getSize();
        String m = "Medium";
        String l = "Large";

        System.out.println("qqqqqqq" + d +m);

        System.out.println("789" + d);


        switch(d) {
            case "Small":
                price = "100";
                break;
            case "Medium":
                // code block
                price = "150";
                break;
            case "Large":
                price = "200";
                break;

        }



        System.out.println("***" + AcceptRide.getPremium() + "***");


        if(AcceptRide.getPremium() == true){

            temp = Integer.parseInt(price);
            temp *= 1.2;

        }else{
            temp = Integer.parseInt(price);

        }
        price = String.valueOf(temp);
        gg = price;

        TextView Price = (TextView) findViewById(R.id.PriceTxtview);
        Price.setText(price);

        TextView D = (TextView) findViewById(R.id.DatetxtView);
        D.setText(date[2] + "/" + date[1] + "/" + date[5]);

        TextView T = (TextView) findViewById(R.id.TimetxtView);
        T.setText(date[3]);


        TextView Premium = (TextView) findViewById(R.id.PremiumtxtView) ;
        String ret = "";
        if(BikeType.getPremium() == true){
            Premium.setText("Y");
        }else{
            Premium.setText("N");
        }






        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("LiveBike");
//
                Help helperHelp = new Help(UserDetails.ID(),BikeType.getPremium(),BikeType.getSize(),date[3],date[2] + "/" + date[1] + "/" + date[5],gg);

                reference.child(UserDetails.ID()).setValue(helperHelp);


                Intent i = new Intent(Rent3.this, End_target.class);
                startActivity(i);





            }

        });
        System.out.println("goooooya" + " " + BikeType.getSize() + " " + BikeType.getPremium());
    }
}