package com.tms.notification01;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static com.tms.notification01.App.CHANNEL_1_ID;
import static com.tms.notification01.App.CHANNEL_2_ID;
import static com.tms.notification01.App.CHANNEL_3_ID;
import static com.tms.notification01.App.CHANNEL_4_ID;
import static com.tms.notification01.App.CHANNEL_5_ID;

public class MainActivity extends AppCompatActivity {
    private NotificationManagerCompat notificationManagerCompat;
    private EditText editTextTitle;
    private EditText editTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManagerCompat = NotificationManagerCompat.from(this);

        editTextTitle = findViewById(R.id.editTextTitle);
        editTextMessage = findViewById(R.id.editTextMessage);
    }


    public void sendOnChannel1 (View view) {
        Intent activityIntent = new Intent(this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this,
                0, activityIntent, 0);

        Intent broadcastIntent = new Intent(this, NotificationReceiver.class);
        broadcastIntent.putExtra("toast", editTextMessage.getText().toString());
        PendingIntent actionIntent = PendingIntent.getBroadcast(this,
                0, broadcastIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_one)
                .setContentTitle(editTextTitle.getText().toString())
                .setContentText(editTextMessage.getText().toString())
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setContentIntent(contentIntent)
                .setAutoCancel(true)
                .setColor(Color.RED)
                .setOnlyAlertOnce(true)
                .addAction(R.mipmap.ic_launcher, "Toast" , actionIntent)
                .build();

        notificationManagerCompat.notify(1, notification);
    }

    public void sendOnChannel2 (View view) {
        Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.photo);


        Notification notification = new NotificationCompat.Builder(this, CHANNEL_2_ID)
                .setSmallIcon(R.drawable.ic_two)
                .setContentTitle(editTextTitle.getText().toString())
                .setContentText(editTextMessage.getText().toString())
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setLargeIcon(largeIcon)
                .setStyle(new NotificationCompat.BigTextStyle()
                    .bigText(getString(R.string.dummy))
                    .setBigContentTitle("Big content title")
                    .setSummaryText("Summary text"))
                .build();

        notificationManagerCompat.notify(2, notification);
    }

    public void sendOnChannel3 (View view) {
        Notification notification = new NotificationCompat.Builder(this, CHANNEL_3_ID)
                .setSmallIcon(R.drawable.ic_two)
                .setContentTitle(editTextTitle.getText().toString())
                .setContentText(editTextMessage.getText().toString())
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setStyle(new NotificationCompat.InboxStyle()
                    .addLine("this is line 1")
                    .addLine("this is line 2")
                    .addLine("this is line 3")
                    .addLine("this is line 4")
                    .addLine("this is line 5")
                    .addLine("this is line 6")
                    .addLine("this is line 7")
                    .setBigContentTitle("Big content title")
                    .setSummaryText("summary text"))
                .build();

        notificationManagerCompat.notify(3, notification);
    }

    public void sendOnChannel4 (View view) {
        Bitmap image = BitmapFactory.decodeResource(getResources(), R.drawable.photo);


        Notification notification = new NotificationCompat.Builder(this, CHANNEL_4_ID)
                .setSmallIcon(R.drawable.ic_two)
                .setContentTitle(editTextTitle.getText().toString())
                .setContentText(editTextMessage.getText().toString())
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setLargeIcon(image)
                .setStyle(new NotificationCompat.BigPictureStyle()
                        .bigPicture(image)
                        .bigLargeIcon(null))
                .build();

        notificationManagerCompat.notify(3, notification);
    }

    public void sendOnChannel5 (View view) {
        Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.photo);


        Notification notification = new NotificationCompat.Builder(this, CHANNEL_5_ID)
                .setSmallIcon(R.drawable.ic_two)
                .setContentTitle(editTextTitle.getText().toString())
                .setContentText(editTextMessage.getText().toString())
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setLargeIcon(largeIcon)
                .addAction(R.drawable.ic_v0, "action 0" , null) // pass pending intent instead of null to do some action
                .addAction(R.drawable.ic_v1, "action 1" , null)
                .addAction(R.drawable.ic_v2, "action 2" , null)
                .addAction(R.drawable.ic_v3, "action 3" , null)
                .addAction(R.drawable.ic_v4, "action 4" , null)
                .setStyle(new android.support.v4.media.app.NotificationCompat.MediaStyle()
                        .setShowActionsInCompactView(1,2,3)
                        )
                .setSubText("Sub text")
                .build();

        notificationManagerCompat.notify(4, notification);
    }

}
