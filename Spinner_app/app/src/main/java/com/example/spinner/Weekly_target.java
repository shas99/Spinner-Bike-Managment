package com.example.spinner;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Weekly_target extends AppCompatActivity {
    private Button button666;
    private Button button555;
    static String y = "05";
    static int sec = 0;
    static int rem = 0;

    String dum = "";
    DatabaseReference reference;


    public static boolean isStart = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly_target);
        CreateNotificatoinChannel();
        reference = FirebaseDatabase.getInstance().getReference("UsersProfile");


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


        float f = Float.parseFloat(x);
        String p = String.valueOf(f/60);
        targetLeft.setText(p + " Minutes");

        int timeInmillis = Integer.parseInt(x) * 1000;
        System.out.println("Target is: " + timeInmillis);





        button666.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                //timer
                if(isStart == false){
                    isStart = true;
                }else if(isStart == true){
                    isStart = false;
                }

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
                    System.out.println("uhhh" + rem);
                    Button button = (Button)findViewById(R.id.startbtn);
                    button.setText("START");

                }else{
                    System.out.println("Dubdub " + num);
                }

                new CountDownTimer(timeInmillis, 1000) {
                    TextView bro = (TextView) findViewById(R.id.DDDD);

                    public void onTick(long millisUntilFinished) {

                        if(isStart == true) {

                            bro.setText("Seconds Remaining:" + millisUntilFinished / 1000);
                            sec++;
                            rem = (timeInmillis - sec * 1000) / 1000;
                            dum = String.valueOf(rem);
                            reference.child(UserDetails.ID()).child("Target").setValue(dum);


                        }else if(isStart == false){
                            cancel();
                        }

                    }




                    public void onFinish() {


                        NotificationCompat.Builder builder = new NotificationCompat.Builder(Weekly_target.this,"lemubitA")
                                .setSmallIcon(R.drawable.ic_message)
                                .setContentTitle("Spinner Target Completed")
                                .setContentText("You have successfully completed your target :)")
                                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(Weekly_target.this);

                        notificationManager.notify(100,builder.build());
                        bro.setText("Done!");
                    }

                }.start();
            }//timer ends

        });
    }

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