package com.first.sharedpreferencesexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SharedPreferenceConfig preferenceConfig;
    private EditText UserName, UserPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferenceConfig = new SharedPreferenceConfig(getApplicationContext());
        UserName = findViewById(R.id.user_name);
        UserPassword = findViewById(R.id.user_password);

        if(preferenceConfig.readLoginStatus())
        {
            startActivity(new Intent(this, SuccessActivity.class));
            finish();
        }

    }

    public void loginUser(View view)
    {

        String username = UserName.getText().toString();
        String userpassword = UserPassword.getText().toString();

        if(username.equals(getResources().getString(R.string.user_name)) && userpassword.equals(getResources().getString(R.string.user_password)))
        {

            startActivity(new Intent(this, SuccessActivity.class));
            preferenceConfig.writeLoginStatus(true);
            finish();

        }
        else
        {
            Toast.makeText(this, "Login Failed...Try again...", Toast.LENGTH_SHORT).show();
            UserName.setText("");
            UserPassword.setText("");
        }

    }
}
