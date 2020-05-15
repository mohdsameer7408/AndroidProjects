package com.example.networkcheckexample;

import androidx.appcompat.app.AppCompatActivity;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

import java.net.NetworkInterface;

public class MainActivity extends AppCompatActivity {

    private ConnectivityManager connectivityManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
    }

    public void checkNetworkStatus(View view) {

        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected())
        {
            informUser("Connected to Internet...");
        }
        else
        {
            informUser("No Internet Connection available...");
        }

    }

    public void checkNetworkType(View view) {

        NetworkInfo wifiInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobileInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        if (wifiInfo.isConnected())
        {
            informUser("Connected to WIFI...");
        }
        else if (mobileInfo.isConnected())
        {
            informUser("Connected to Mobile Data...");
        }
        else
        {
            informUser("No Network available...");
        }

    }

    private void informUser(String message)
    {

        Snackbar.make(findViewById(R.id.rootView), message, Snackbar.LENGTH_SHORT).show();

    }

}
