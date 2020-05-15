package com.example.settingsheaderexample;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import androidx.annotation.Nullable;

public class SettingsFragment extends PreferenceFragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String settings = getArguments().getString("settings");

        if (settings.equals("general"))
        {
            addPreferencesFromResource(R.xml.general_settings);
        }
        else if (settings.equals("about"))
        {
            addPreferencesFromResource(R.xml.about_app_settings_preference);
        }

    }
}
