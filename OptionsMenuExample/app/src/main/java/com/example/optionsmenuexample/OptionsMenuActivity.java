package com.example.optionsmenuexample;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class OptionsMenuActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.appbar_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.action_cast:
                displayMessage("Cast option is selected");
                return true;

            case R.id.action_search:
                displayMessage("Search option selected");
                return true;

            case R.id.action_settings:
                displayMessage("Settings option selected");
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private void displayMessage(String message)
    {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
