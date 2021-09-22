package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculatePrice extends AppCompatActivity {

    TextView esitmatedCost;
    EditText priceInput,discountInput,pointsInput;
    Button calculate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_price);

        //Hooks

        esitmatedCost=(TextView) findViewById(R.id.esitimatedCost);
        priceInput=(EditText) findViewById(R.id.priceInput);
        discountInput=(EditText) findViewById(R.id.discountInput);
        pointsInput=(EditText) findViewById(R.id.pointsInput);
        calculate=(Button) findViewById(R.id.calculate);


        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float price=Float.parseFloat(priceInput.getText().toString());
                float discount =Float.parseFloat(discountInput.getText().toString());
                float points =Float.parseFloat(pointsInput.getText().toString());

               float totalCost = price -(discount/100f) -points + 500;
               esitmatedCost.setText(Float.toString(totalCost));

            }
        });


    }
}