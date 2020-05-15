package com.example.popupmenuexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showPopUp(View view) {

        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.setOnMenuItemClickListener(this);
        MenuInflater inflater = popupMenu.getMenuInflater();
        inflater.inflate(R.menu.popup_menu, popupMenu.getMenu());
        popupMenu.show();

    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {

        switch (item.getItemId())
        {

            case R.id.action_move:
                displayMessage("Move To Option Selected");
                return true;

            case R.id.action_label:
                displayMessage("Change Label Option Selected");
                return true;

            case R.id.action_important:
                displayMessage("Mark as important Option Selected");
                return true;

            case R.id.action_mute:
                displayMessage("Mute Option Selected");
                return true;

            case R.id.action_print:
                displayMessage("Print Option Selected");
                return true;

            case R.id.action_spam:
                displayMessage("Spam Option Selected");
                return true;
                
            default:
                return false;
        }

    }

    private void displayMessage(String message)
    {
        Snackbar.make(findViewById(R.id.rootView), message, Snackbar.LENGTH_SHORT).show();
    }

}
