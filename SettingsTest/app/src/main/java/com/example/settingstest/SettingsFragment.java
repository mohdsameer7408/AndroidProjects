package com.example.settingstest;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;

import androidx.annotation.Nullable;

public class SettingsFragment extends PreferenceFragment
{

    public static final String PREF_SMS_LIMIT = "sms_delete_limit";
    public static final String PREF_MMS_LIMIT = "mms_delete_limit";
    private SharedPreferences.OnSharedPreferenceChangeListener preferenceChangeListener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        addPreferencesFromResource(R.xml.preferences);

        preferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() {
            @Override
            public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

                if (key.equals(PREF_SMS_LIMIT))
                {
                    Preference smsPreference = findPreference(key);
                    smsPreference.setSummary(sharedPreferences.getString(key, "")+" messages per conversation");
                }
                if (key.equals(PREF_MMS_LIMIT))
                {
                    Preference mmsPreference = findPreference(key);
                    mmsPreference.setSummary(sharedPreferences.getString(key, "")+" messages per conversation");
                }

            }
        };
    }

    @Override
    public void onResume() {
        super.onResume();

        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(preferenceChangeListener);

        Preference smsPreference = findPreference(PREF_SMS_LIMIT);
        smsPreference.setSummary(getPreferenceScreen().getSharedPreferences().getString(PREF_SMS_LIMIT, "")+ " messages per conversation");

        Preference mmsPreference = findPreference(PREF_MMS_LIMIT);
        mmsPreference.setSummary(getPreferenceScreen().getSharedPreferences().getString(PREF_MMS_LIMIT, "")+ " messages per conversation");


    }

    @Override
    public void onPause() {
        super.onPause();

        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(preferenceChangeListener);

    }
}
