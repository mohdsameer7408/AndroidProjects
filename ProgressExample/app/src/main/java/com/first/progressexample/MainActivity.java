package com.first.progressexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.RemoteInput;

import android.annotation.TargetApi;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public final String CHANNEL_ID = "personal_notifications";
    public static final int NOTIFICATION_ID = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayNotification(View view) {

        createNotificationChannel();

        Intent landingIntent = new Intent(this, LandingActivity.class);
        landingIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

        PendingIntent landingPendingIntent = PendingIntent.getActivity(this, 0, landingIntent, PendingIntent.FLAG_ONE_SHOT);

        final NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID);
        builder.setSmallIcon(R.drawable.ic_download);
        builder.setContentTitle("Image Download");
        builder.setContentText("Downloading in progress");
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
        builder.setContentIntent(landingPendingIntent);
        builder.setAutoCancel(true);

        final NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);

        final int max_progress = 100;
        int current_progress = 0;
        builder.setProgress(0, 0, true);

        notificationManagerCompat.notify(NOTIFICATION_ID, builder.build());

        Thread thread = new Thread() {
            @Override
            public void run() {
                int count = 0;
                try {
                    while (count <= 100) {
                        count += 10;
                        sleep(1000);
                        // builder.setProgress(max_progress, count, false);
                        // notificationManagerCompat.notify(NOTIFICATION_ID, builder.build());
                    }
                    builder.setContentText("Download successful");
                    builder.setProgress(0, 0, false);
                    notificationManagerCompat.notify(NOTIFICATION_ID, builder.build());

                } catch (InterruptedException e) {
                }
            }
        };

        thread.start();

    }

    @TargetApi(26)
    private void createNotificationChannel()
    {

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            CharSequence name = "Personal Notifications";
            String description = "Include all the personal notifications";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, name, importance);
            notificationChannel.setDescription(description);

            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);

        }

    }

}
