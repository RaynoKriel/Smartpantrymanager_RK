package com.raynokriel.smartpantrymanager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Switch;

import androidx.appcompat.widget.SwitchCompat;

public class SettingsActivity extends BaseNavActivity {

    //using shared preferences to store the toggle state instead of my DB
    private static final String PREFS_NAME = "smart_pantry_settings";
    //string or key value for checking the alert status
    public static final String PREF_EXPIRY_ALERTS = "expiry_alerts_enabled";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        setTitle("Settings");

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Switch switchExpiryAlerts = findViewById(R.id.switchExpiryAlerts);
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        // loading the current saved state of the toggle
        boolean enabled = prefs.getBoolean(PREF_EXPIRY_ALERTS,false);
        switchExpiryAlerts.setChecked(enabled);
        // if the user changes the toggle then save this new state then
        switchExpiryAlerts.setOnCheckedChangeListener(
                (buttonView, isChecked) -> {
                    prefs.edit().putBoolean(PREF_EXPIRY_ALERTS,isChecked).apply();
        });
    }
    //back button method like in all screens (i might amalgamate these eventually if time allows)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}