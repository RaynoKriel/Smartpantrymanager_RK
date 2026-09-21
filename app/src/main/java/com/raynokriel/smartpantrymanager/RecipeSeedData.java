package com.raynokriel.smartpantrymanager;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

//when DB is created adds a few recipies
public class RecipeSeedData {

    public static void seedRecipes(SQLiteDatabase db) {

        addRecipe(db,"Scrambled Eggs","Whisk eggs.\nCook in pan.",
                new Object[][]{
                        {"egg", 2.0, "pcs"},{"butter", 10.0, "g"}
                }
        );

        addRecipe(db,"Cheese Toast","Toast bread.\nAdd cheese.",
                new Object[][]{
                        {"bread", 2.0, "pcs"},{"cheese", 50.0, "g"}
                }
        );

        addRecipe(db,"Garlic Rice","Cook rice.\nAdd garlic.",
                new Object[][]{
                        {"rice", 200.0, "g"},{"garlic", 2.0, "pcs"}
                }
        );
    }

    //Inserts one recipe + all of its ingredients.
    private static void addRecipe(SQLiteDatabase db,String name,String steps,
            Object[][] ingredients
    ) {
        ContentValues recipeValues = new ContentValues();
        recipeValues.put(DatabaseHelper.COL_RECIPE_NAME,name);
        recipeValues.put(DatabaseHelper.COL_RECIPE_STEPS,steps);

        long recipeId = db.insert(DatabaseHelper.TABLE_RECIPES,null, recipeValues);

        for (Object[] ingredient : ingredients) {
            ContentValues ingredientValues = new ContentValues();
            ingredientValues.put(DatabaseHelper.COL_RI_RECIPE_ID, recipeId);
            ingredientValues.put(DatabaseHelper.COL_RI_NAME,(String) ingredient[0]);
            ingredientValues.put(DatabaseHelper.COL_RI_QTY,(Double) ingredient[1]);
            ingredientValues.put(DatabaseHelper.COL_RI_UNIT,(String) ingredient[2]);

            db.insert(DatabaseHelper.TABLE_RECIPE_INGREDIENTS,null,ingredientValues);
        }
    }
}