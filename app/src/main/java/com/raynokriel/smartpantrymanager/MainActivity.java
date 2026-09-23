package com.raynokriel.smartpantrymanager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;



public class MainActivity extends BaseNavActivity {
    //vairable for the ingredient selected (by id for the intent to work)
    public static final String EXTRA_ITEM_ID = "extra_item_id";
    private DatabaseHelper dbHelper;
    private PantryAdapter adapter;
    private TextView emptyView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("My Pantry");
        dbHelper = new DatabaseHelper(this);
        emptyView = findViewById(R.id.textEmptyPantry);
        RecyclerView recyclerView = findViewById(R.id.recyclerPantry);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new PantryAdapter(new ArrayList<>(),item -> {
            Intent intent = new Intent(MainActivity.this,AddEditIngredientActivity.class);
            intent.putExtra(EXTRA_ITEM_ID, item.getId());
            startActivity(intent);
            });
        recyclerView.setAdapter(adapter);
        // linking the floating button to the Add/Edit view via INTENT
        FloatingActionButton fab = findViewById(R.id.fabAddIngredient);

        //click the "+" once and you can add items/ngredients
        fab.setOnClickListener(v -> startActivity(new Intent(
                MainActivity.this, AddEditIngredientActivity.class)));

       /** testing done and toolbar added for easier access to recipies
        //press the "+" long and it will open the suggested recipy screen
        fab.setOnLongClickListener(v -> {
            startActivity(new Intent(MainActivity.this,SuggestedRecipesActivity.class));
            return true;
        });
        */
    }

    //when switching between screens like after adding an item it refreshes
    @Override
    protected void onResume() {
        super.onResume();
        loadPantry();
        //adding the notification check here as well on reload/switches
        checkExpiryNotifications();
    }
    //method for checking the dates using the function in settings activity
    private void checkExpiryNotifications() {
        SharedPreferences prefs = getSharedPreferences("smart_pantry_settings",MODE_PRIVATE);
        boolean enabled = prefs.getBoolean(SettingsActivity.PREF_EXPIRY_ALERTS,false);
        if (!enabled) {return;}
        Toast.makeText(this,"Checking expiries...", Toast.LENGTH_LONG).show();
        ExpiryChecker.checkExpiryDates(this, dbHelper.getAllPantryItems());
    }

    //Load from DB
    private void loadPantry() {
        List<PantryItem> items = dbHelper.getAllPantryItems();
        adapter.setItems(items);
        emptyView.setVisibility(items.isEmpty() ? View.VISIBLE : View.GONE);
    }

}