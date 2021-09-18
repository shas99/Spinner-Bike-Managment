package com.example.spinner;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Weekly_target extends AppCompatActivity {
    private Button button666;
    private Button button555;
    static String y = "05";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly_target);

        String x = UserDetails.getTarget();
        button666 = (Button) findViewById(R.id.startbtn);
        button555 = (Button) findViewById(R.id.fg);


        button555.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Weekly_target.this,Target.class);
                startActivity(intent);
            }
        });

        TextView targetLeft = (TextView) findViewById(R.id.time_remaining);
        targetLeft.setText(x);

        int timeInmillis = Integer.parseInt(x) * 60 * 1000;
        System.out.println("Target is: " + timeInmillis);





        button666.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                //timer


                TextView secret = (TextView) findViewById(R.id.secretText);
                String num = secret.getText().toString();
                System.out.println("Labadaba" + num+num);
                int j = Integer.parseInt(num);


                if(j == 0){
                    secret.setText("1");
                    System.out.println("0");
                    j = 1;
                    System.out.println("Dubdub 0");

                    Button button = (Button)findViewById(R.id.startbtn);
                    button.setText("END");

                }else if(j == 1){
                    secret.setText("0");
                    System.out.println("Dubdub 1");
                    j = 0;

                    Button button = (Button)findViewById(R.id.startbtn);
                    button.setText("START");
                }else{
                    System.out.println("Dubdub " + num);
                }

                new CountDownTimer(timeInmillis, 1000) {
                    TextView bro = (TextView) findViewById(R.id.DDDD);

                    public void onTick(long millisUntilFinished) {

                        bro.setText("Seconds Remaining:" + millisUntilFinished / 1000);

                    }




                    public void onFinish() {
                        bro.setText("Done!");
                    }

                }.start();
            }//timer ends

        });
    }



}