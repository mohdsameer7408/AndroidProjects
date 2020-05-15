package com.example.snackbarexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayPopup(View view) {

//        to display a snackbar with a button on it.
//        Snackbar snackbar = Snackbar.make(findViewById(R.id.rootLayout), R.string.offline_message, Snackbar.LENGTH_LONG);
//        snackbar.setAction(R.string.undo_string, this);
//        snackbar.show();

        new FireMissileFragment().show(getSupportFragmentManager(), "missile dialog");

    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "Undo operation selected", Toast.LENGTH_SHORT).show();
    }
}
