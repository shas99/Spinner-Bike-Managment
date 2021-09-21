package com.example.spinner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Rent2 extends AppCompatActivity {

    private Button button;
    RadioGroup radioGroup;
    RadioButton radioButton;
    public int clicked = 0;
    public Boolean is = false;
    public String radio = "radioButton";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent2);


        String points = UserDetails.getPoints();
        TextView point = (TextView) findViewById(R.id.points55);
        point.setText(points);

        radioGroup = findViewById(R.id.radioGroup2);



        Switch onOffSwitch = (Switch) findViewById(R.id.switch1);
        onOffSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                is = isChecked;
            }
        });





        button = (Button) findViewById(R.id.btnChoose5);
        button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                System.out.println("Bruhhh " + is + " " + radio);
                if(clicked == 0) {
                    BikeType L = new BikeType(is, "Small");
                }
                else if(clicked == 1){
                    BikeType L = new BikeType(is, radio);
                }

                int radioId = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(radioId);



                openActivity2();

            }
        });


        }
    public void openActivity2(){


        Intent intent = new Intent(Rent2.this,Rent3.class);
        startActivity(intent);


    }
    public void checkButton1(View v){
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);
        System.out.println("aaa***" + radioButton + "***");
        Toast.makeText(this, "Selected Radio Button: " + radioButton.getText(), Toast.LENGTH_SHORT).show();
        clicked = 1;
        radio = radioButton.getText().toString();
    }





}