package com.example.spinner;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class End_target extends AppCompatActivity {
    DatabaseReference referenceTest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_target);

        referenceTest = FirebaseDatabase.getInstance().getReference("LiveBike");

        String ID = UserDetails.ID();

        CreateNotificatoinChannel();



        Button b1=(Button)findViewById(R.id.Weekly_target10);
        Button b2=(Button)findViewById(R.id.Endridebtn);

        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(End_target.this, Weekly_target.class);
                startActivity(i);
            }

        });

        b2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){



                String[] time = Help.getTime().split(":");
                String[] date = Calendar.getInstance().getTime().toString().split(" ");
                System.out.println("++++" + time[0] + "lll" + time[1]+ "kkkk" + time[2]);
                String[] currentTime = date[3].split(":");
                System.out.println("++++" + currentTime[0] + "lll" + currentTime[1]+ "kkkk" + currentTime[2]);
                if(Integer.parseInt(time[0]) == Integer.parseInt(currentTime[0])){
                    int timeinfloat = Integer.parseInt(currentTime[1]) - Integer.parseInt(time[1]);
                    double min = timeinfloat / 60.0;
                    String toast = "Your total charge is " + String.valueOf(Double.parseDouble(Help.getPrice())*min)  + "rs, Please go to the counter to pay the fee";
                    System.out.println("++++" + currentTime[0] + "lll" + currentTime[1]+ "kkkk" + currentTime[2] + "1111");
                    Toast.makeText(getApplicationContext(),toast,Toast.LENGTH_LONG).show();
                }
                System.out.println("+++" + date[3]);

                referenceTest.child(UserDetails.ID()).removeValue();
                //notification start
                NotificationCompat.Builder builder = new NotificationCompat.Builder(End_target.this,"lemubitA")
                        .setSmallIcon(R.drawable.ic_message)
                        .setContentTitle("Thank you for riding with Spinner")
                        .setContentText("Please go to the counter and pay the fee")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                NotificationManagerCompat notificationManager = NotificationManagerCompat.from(End_target.this);

                notificationManager.notify(100,builder.build());
                //notification end
            }

        });

    }

    //channel creation
    private void CreateNotificatoinChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){//try changing to zero if it didn't work
            CharSequence name = "stuentChannel";
            String description = "Channel for student notification";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("lemubitA",name,importance);
            channel.setDescription(description);



            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}