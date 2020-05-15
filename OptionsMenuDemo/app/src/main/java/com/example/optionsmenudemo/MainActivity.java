package com.example.optionsmenudemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Button button;
    private final int share_item_id = 101;
    private boolean isItemAdd = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        button = findViewById(R.id.bn);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.appbar_menu, menu);
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
        Snackbar snackbar = Snackbar.make(findViewById(R.id.rootLayout), message, Snackbar.LENGTH_LONG);
        snackbar.show();
//        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void manageShareOption(View view)
    {

        if(!isItemAdd)
        {
            isItemAdd = true;
            button.setText("Remove Share Option");
            invalidateOptionsMenu();
        }
        else
        {
            isItemAdd = false;
            button.setText("Add Share Option");
            invalidateOptionsMenu();
        }

    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        if(isItemAdd)
        {
            if(menu.findItem(share_item_id) == null)
            {
                MenuItem shareItem = menu.add(Menu.NONE, share_item_id, 5, "Share");
                shareItem.setIcon(R.drawable.ic_share);
                shareItem.setShowAsActionFlags(MenuItem.SHOW_AS_ACTION_ALWAYS);

                shareItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        displayMessage("Share option selected");
                        return true;
                    }
                });
            }
        }

        else
        {
            menu.removeItem(share_item_id);
        }

        super.onPrepareOptionsMenu(menu);
        return true;
    }
}
