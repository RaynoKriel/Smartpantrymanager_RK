package com.raynokriel.smartpantrymanager;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;

//the navigation logic for the app that is shared among screens
public abstract class BaseNavActivity
        extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nav_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_pantry && !(this instanceof MainActivity)) {
            startActivity(new Intent(this,MainActivity.class));
            return true;
        }

        if (id == R.id.nav_suggested && !(this instanceof SuggestedRecipesActivity)) {
            startActivity(new Intent(this, SuggestedRecipesActivity.class));
            return true;
        }

        if (id == R.id.nav_settings && !(this instanceof SettingsActivity)) {
            startActivity(new Intent(this, SettingsActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}