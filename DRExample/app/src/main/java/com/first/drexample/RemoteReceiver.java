package com.first.drexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.RemoteInput;

import android.app.NotificationManager;
import android.os.Bundle;
import android.widget.TextView;

public class RemoteReceiver extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remote_receiver);

        textView = findViewById(R.id.txt_display);

        Bundle remoteReply = RemoteInput.getResultsFromIntent(getIntent());

        if(remoteReply != null)
        {
            String message = remoteReply.getCharSequence(MainActivity.TXT_REPLY).toString();
            textView.setText(message);
        }

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.cancel(MainActivity.NOTIFICATION_ID);

    }
}
