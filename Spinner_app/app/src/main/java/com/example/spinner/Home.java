package com.example.spinner;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //retreive user details
        String name = UserDetails.getName();
        String email = UserDetails.getEmail();
        String phone = UserDetails.getMobileNo();
        String sex = UserDetails.getSex();
        String points = UserDetails.getPoints();

        System.out.println("Details are : " + "Name:" + name + " Email:" + email + " Mobile Number:" + phone + " Sex:" + sex + " Points:" + points);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button b1=(Button)findViewById(R.id.btnRent);
        Button b2=(Button)findViewById(R.id.btnDonate);

        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent g = new Intent(Home.this,Rent2.class);
                startActivity(g);
        }

        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Home.this,Donate.class);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu,menu);
        return true;
    }
//code for menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(this, "Item 1 selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item2:
                Toast.makeText(this, "Item 2 selected", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Home.this,Donate.class);
                startActivity(intent);
                return true;
            case R.id.item3:
                Toast.makeText(this, "Item 3 selected", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(Home.this,Weekly_target.class);
                startActivity(intent1);
                return true;
            case R.id.item4:
                Toast.makeText(this, "Item 4 selected", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(Home.this,Target.class);
                startActivity(intent2);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
