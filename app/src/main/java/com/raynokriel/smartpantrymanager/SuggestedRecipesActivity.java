package com.raynokriel.smartpantrymanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import android.view.MenuItem;

public class SuggestedRecipesActivity extends BaseNavActivity {
    private DatabaseHelper dbHelper;
    private RecipeAdapter adapter;
    private TextView emptyView;
    public static final String EXTRA_RECIPE_ID = "extra_recipe_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggested_recipes);
        dbHelper = new DatabaseHelper(this);
        emptyView = findViewById(R.id.textEmptySuggestions);
        RecyclerView recyclerView = findViewById(R.id.recyclerSuggestedRecipes);
        recyclerView.setLayoutManager( new LinearLayoutManager(this));
        //select a recipy and go to detail screen
        adapter = new RecipeAdapter( new ArrayList<>(),recipe -> {
            Intent intent = new Intent(SuggestedRecipesActivity.this, RecipeDetailActivity.class);
            intent.putExtra(EXTRA_RECIPE_ID, recipe.getId());
            startActivity(intent);
            });
        recyclerView.setAdapter(adapter);
        //adding the back button as well to make navigation easier (not using menu the whole time)
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
    //adding the menu items to the screen
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    //on screen switch or refresh
    @Override
    protected void onResume() {
        super.onResume();
        loadSuggestions();
    }
    //suggested matching recipies/items etc in lists
    private void loadSuggestions() {
        List<PantryItem> pantry = dbHelper.getAllPantryItems();
        List<Recipe> allRecipes = dbHelper.getAllRecipes();
        List<Recipe> suggested = new ArrayList<>();
        for (Recipe recipe : allRecipes) {
            if (MatchingUtils.canMake(recipe,pantry)) {
                suggested.add(recipe);
            }
        }
        adapter.setRecipes(suggested);
        emptyView.setVisibility(suggested.isEmpty() ? View.VISIBLE : View.GONE);
    }
}