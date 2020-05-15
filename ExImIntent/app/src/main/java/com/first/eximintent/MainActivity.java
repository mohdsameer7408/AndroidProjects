package com.first.eximintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sharePost(View view)
    {

        Intent intent = new Intent(this, SharePost.class);
        startActivity(intent);

    }

    public void sendMail(View view)
    {

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra("message", "This is a simple message");
        startActivity(intent);

    }
}
