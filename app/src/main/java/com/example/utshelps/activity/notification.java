package com.example.razerblade.myapplication;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class Notification extends AppCompatActivity {
Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        b1 = (Button)findViewById(R.id.noti);


    }

    public void getNotification(View view){

        NotificationManager notificationmgr = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        //the resultactivity.class is to direct the notification to the session booked/confirm page
        Intent intent = new Intent(this, resultactivity.class);

        PendingIntent p1 = PendingIntent.getActivities(this,(int) System.currentTimeMillis(),intent,0);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)
                mBuilder.setSmallIcon(R.drawable.abcd)
                mBuilder.setContentTitle("Session booked")
                mBuilder.setContentText("Your session booked for")
                mBuilder.setContentIntent(p1)
                mBuilder.build();

        notificationmgr.notify(0,mBuilder.build());


        }







}
