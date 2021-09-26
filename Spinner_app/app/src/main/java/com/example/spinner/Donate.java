package com.example.spinner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Donate extends AppCompatActivity {

    DatabaseReference reference;

    public String ID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);

        reference = FirebaseDatabase.getInstance().getReference("UsersProfile");


        String points = UserDetails.getPoints();

        System.out.println(points);
        TextView Donation = (TextView) findViewById(R.id.pointsView);
        Donation.setText(points);
        ID = UserDetails.ID();
        System.out.println("ID is " + ID);
    }


   public void update_1(View view){
        if(Integer.parseInt(UserDetails.getPoints()) < 100){
            Toast.makeText(this, "You don't have enough points to donate :(", Toast.LENGTH_SHORT).show();
        }
       else if(isChaged()){
           Toast.makeText(this, "Thank you for donating :)", Toast.LENGTH_SHORT).show();
        }


    }
    private boolean isChaged(){
        String updated = UserDetails.getPoints();
        System.out.println("xxxbefore editing updated" + updated);
        int temp = Integer.parseInt(updated);
        System.out.println("xxxTemp is " + temp);
        if(true){

            temp -= 100;
            System.out.println("xxxafter editing temp" + temp);
            updated = Integer.toString(temp);
            System.out.println("xxxbefore editing updated" + updated);
            reference.child(ID).child("Points").setValue(updated);
            TextView Donation = (TextView) findViewById(R.id.pointsView);
            Donation.setText(updated);
            UserDetails.setPoints(updated);
            return true;
        }
        else{
            return false;
        }

   }


}