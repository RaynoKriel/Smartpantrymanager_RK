package com.raynokriel.smartpantrymanager;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private DatabaseHelper dbHelper;
    private PantryAdapter adapter;
    private TextView emptyView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DatabaseHelper(this);
        emptyView = findViewById(R.id.textEmptyPantry);
        RecyclerView recyclerView = findViewById(R.id.recyclerPantry);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new PantryAdapter(new ArrayList<>());
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadPantry();
    }

    //Load from DB
    private void loadPantry() {
        List<PantryItem> items = dbHelper.getAllPantryItems();
        adapter.setItems(items);
        emptyView.setVisibility(items.isEmpty() ? View.VISIBLE : View.GONE);
    }
}