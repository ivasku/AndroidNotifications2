package com.tms.notification01;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class App extends Application {

    public static final String CHANNEL_1_ID = "channel1";
    public static final String CHANNEL_2_ID = "channel2";
    public static final String CHANNEL_3_ID = "channel3";
    public static final String CHANNEL_4_ID = "channel4";
    public static final String CHANNEL_5_ID = "channel5";
    public static final String CHANNEL_6_ID = "channel6";

    @Override
    public void onCreate() {
        super.onCreate();

        //setup our channels once in our app
        createNotificationChannels();

    }

    private void createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_1_ID,
                    "Channel 1",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel.enableLights(true);
            channel.setDescription("This is channel 1");

            NotificationChannel channe2 = new NotificationChannel(
                    CHANNEL_2_ID,
                    "Channel 2",
                    NotificationManager.IMPORTANCE_LOW
            );
            channe2.setDescription("This is channel 2");

            NotificationChannel channe3 = new NotificationChannel(
                    CHANNEL_3_ID,
                    "Channel 3",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            channe3.setDescription("This is channel 3");

            NotificationChannel channe4 = new NotificationChannel(
                    CHANNEL_4_ID,
                    "Channel 4",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            channe4.setDescription("This is channel 4");

            NotificationChannel channe5 = new NotificationChannel(
                    CHANNEL_5_ID,
                    "Channel 5",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            channe5.setDescription("This is channel 5");

            NotificationChannel channe6 = new NotificationChannel(
                    CHANNEL_6_ID,
                    "Channel 6",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            channe6.setDescription("This is channel 6");

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
            manager.createNotificationChannel(channe2);
            manager.createNotificationChannel(channe3);
            manager.createNotificationChannel(channe4);
            manager.createNotificationChannel(channe5);
            manager.createNotificationChannel(channe6);
        }
    }
}
