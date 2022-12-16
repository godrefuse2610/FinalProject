package com.example.myapplication.model;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.myapplication.R;

public class VipNotification extends BroadcastReceiver{


    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("11111111111111", "onReceive: ");
        NotificationCompat.Builder notification = new NotificationCompat.Builder(context, "123")
                .setSmallIcon(R.drawable.wheelchair)
                .setContentTitle("Hope you enjoy!")
                .setContentText("That's a great movie");
        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(context);
        managerCompat.notify(200, notification.build());
        Log.d("111111", "onReceive: ");
    }
}
