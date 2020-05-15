package com.example.settingstest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.prefs.PreferenceChangeListener;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    public static final String PREF_DELETE_OLD_MESSAGE = "pref_delete_old_message";
    public static final String PREF_SMS_DELETE_LIMIT = "sms_delete_limit";
    public static final String PREF_MMS_DELETE_LIMIT = "mms_delete_limit";
    public static final String PREF_SMS_DELIVERY_REPORT = "pref_delivery_report_sms";
    public static final String PREF_MMS_DELIVERY_REPORT = "pref_delivery_report_mms";

    private TextView Txt_delete_old_messages, Txt_sms_delete_limit, Txt_mms_delete_limit, Txt_sms_delivery, Txt_mms_delivery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);

        Txt_delete_old_messages = findViewById(R.id.message_delete_status);
        Txt_sms_delete_limit = findViewById(R.id.sms_delete_limit);
        Txt_mms_delete_limit = findViewById(R.id.mms_delete_limit);
        Txt_sms_delivery = findViewById(R.id.sms_delivery_report);
        Txt_mms_delivery = findViewById(R.id.mms_delivery_report);

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

            case R.id.action_settings:
                startActivity(new Intent(this, SettingsActivity.class));
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }

    }

    public void readSettings(View view) {

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        Txt_delete_old_messages.setText("Message Delete Status : " +String.valueOf(sharedPreferences.getBoolean(PREF_DELETE_OLD_MESSAGE, false)));
        Txt_sms_delete_limit.setText("SMS Delete Limit : "+ sharedPreferences.getString(PREF_SMS_DELETE_LIMIT, "0"));
        Txt_mms_delete_limit.setText("MMS Delete Limit : "+ sharedPreferences.getString(PREF_MMS_DELETE_LIMIT, "0"));
        Txt_sms_delivery.setText("SMS Delivery Report : " +String.valueOf(sharedPreferences.getBoolean(PREF_SMS_DELIVERY_REPORT, false)));
        Txt_mms_delivery.setText("MMS Delivery Report : " +String.valueOf(sharedPreferences.getBoolean(PREF_MMS_DELIVERY_REPORT, false)));

    }
}
