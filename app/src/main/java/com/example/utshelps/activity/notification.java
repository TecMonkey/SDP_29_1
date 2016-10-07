package com.example.utshelps.activity;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

import com.example.utshelps.R;

public class Notification extends AppCompatActivity {
private Button mButton1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        mButton1 = (Button)findViewById(R.id.noti);


    }

    public void getNotification(View view){

        NotificationManager notificationMgr = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        //the ResultActivity.class is to direct the notification to the session booked/confirm page
        Intent intent = new Intent(this, ResultActivity.class);

        PendingIntent p1 = PendingIntent.getActivities(this,(int) System.currentTimeMillis(),intent,0);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
                mBuilder.setSmallIcon(R.drawable.abcd);
                mBuilder.setContentTitle("Session booked");
                mBuilder.setContentText("Your session booked for");
                mBuilder.setContentIntent(p1);
                mBuilder.build();

        notificationMgr.notify(0,mBuilder.build());


        }







}
