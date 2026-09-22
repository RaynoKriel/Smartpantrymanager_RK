package com.raynokriel.smartpantrymanager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
//same as pantry item select just for recipy this time
public class RecipeDetailActivity extends BaseNavActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        long recipeId = getIntent().getLongExtra(SuggestedRecipesActivity.EXTRA_RECIPE_ID,-1);
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        Recipe recipe = dbHelper.getRecipeById(recipeId);

        if (recipe == null) {
            finish();
            return;
        }

        TextView name = findViewById(R.id.textRecipeDetailName);
        TextView ingredients = findViewById(R.id.textRecipeDetailIngredients);
        TextView steps = findViewById(R.id.textRecipeDetailSteps);
        //set the recipy name
        name.setText(recipe.getName());

        StringBuilder ingredientText = new StringBuilder();
        //build the ingrediend string
        for (RecipeIngredient ingredient : recipe.getIngredients()) {
            ingredientText.append("• ").append(ingredient.getQuantity()).append(" ")
                    .append(ingredient.getUnit()).append(" ")
                    .append(ingredient.getName()).append("\n");
        }
        //show ingredients
        ingredients.setText(ingredientText.toString());
        //show steps
        steps.setText(recipe.getSteps());
    }
    //same backmenu item again
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}