package com.first.priorityofactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showLog("onCreate Finish...");
    }


    @Override
    protected void onStart() {
        super.onStart();
        showLog("onStart Finish...");
    }

    @Override
    protected void onResume() {
        super.onResume();
        showLog("onResume Finish...");
    }

    @Override
    protected void onPause() {
        super.onPause();
        showLog("onPause Finish");
    }

    @Override
    protected void onStop() {
        super.onStop();
        showLog("onStop Finish...");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        showLog("onRestart Finish...");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        showLog("onDestroy Finish...");
    }

    public void finishActivity(View view)
    {
        finish();
    }

    public void startAnotherActivity(View view)
    {

        startActivity(new Intent(this, SecondActivity.class));

    }

    private void showLog(String message)
    {
        Log.d("Lifecycle Test", message);
    }

}
