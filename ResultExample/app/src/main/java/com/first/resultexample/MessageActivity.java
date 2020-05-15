package com.first.resultexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MessageActivity extends AppCompatActivity {

    EditText Message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        Message = findViewById(R.id.txt_message);
    }

    public void sendMessage(View view) {

        String message = Message.getText().toString();
        Intent returnIntent = new Intent();
        returnIntent.putExtra("message", message);
        setResult(RESULT_OK, returnIntent);
        finish();

    }
}
