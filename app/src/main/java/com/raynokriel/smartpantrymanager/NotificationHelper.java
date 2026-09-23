package com.raynokriel.smartpantrymanager;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

//creating and showing the notification for the toggle
public class NotificationHelper {
    //what i am checking to notify on (the date of expiry)
    private static final String CHANNEL_ID = "expiry_alerts";
    public static void createChannel(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,"Expiry Alerts", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = context.getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
    }

    public static void showExpiryNotification(Context context,String ingredientName,long daysRemaining) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context,CHANNEL_ID)
                .setSmallIcon(android.R.drawable.ic_dialog_alert).setContentTitle("Expiry Reminder")
                .setContentText(ingredientName+ " expires in "+ daysRemaining+ " day(s).")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManagerCompat manager =NotificationManagerCompat.from(context);
        //adding a overide method in androidmanifest for now
        manager.notify(ingredientName.hashCode(), builder.build());
    }
}