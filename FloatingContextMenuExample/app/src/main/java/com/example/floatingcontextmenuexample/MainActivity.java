package com.example.floatingcontextmenuexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.bn);
        registerForContextMenu(button);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.action_add_playlist:
                displayMessage("Add to playlist selected");
                return true;

            case R.id.action_delete:
                displayMessage("Delete selected");
                return true;

            case R.id.action_info:
                displayMessage("Info selected");
                return true;

            case R.id.action_report:
                displayMessage("Report selected");
                return true;

            case R.id.action_share:
                displayMessage("Share selected");
                return true;

            default:
                return super.onContextItemSelected(item);
        }

    }

    private void displayMessage(String message)
    {

        Snackbar.make(findViewById(R.id.rootView), message, Snackbar.LENGTH_SHORT).show();

    }

}
