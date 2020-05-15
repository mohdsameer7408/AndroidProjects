package com.example.dialogexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MyDialog.ToppingsSelectionListener{

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text_toppings);

    }

    public void displayDialog(View view) {

        new MyDialog().show(getSupportFragmentManager(), "my dialog");

    }

    @Override
    public void onToppingsSelected(List<String> toppings)
    {

        String selection = "Selected items are :";
        for (String topic : toppings)
        {
            selection += "\n"+topic;
        }
        textView.setText(selection);

    }
}
