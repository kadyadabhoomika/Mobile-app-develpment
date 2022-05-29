package com.example.notification;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button but1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        but1=(Button) findViewById(R.id.but1);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1=new Intent();
                PendingIntent pi1=PendingIntent.getActivity(MainActivity.this,0,int1,0);
                Notification not1=new Notification.Builder(MainActivity.this)
                        .setTicker("Ticker Title")
                        .setContentTitle("Bhoomika\'s Notification")
                        .setContentText("This is Notification Example")
                        .setSmallIcon(R.drawable.icon)
                        .addAction(R.drawable.red_button,"Action 1",pi1)
                        .addAction(R.drawable.green_ball,"Action 2",pi1)
                        .setContentIntent(pi1).getNotification();
                not1.flags=Notification.FLAG_AUTO_CANCEL;
                NotificationManager nm= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                nm.notify(0,not1);
            }
        });
    }
}
