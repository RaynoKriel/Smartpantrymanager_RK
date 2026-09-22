package com.raynokriel.smartpantrymanager;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

//when DB is created adds a few recipies
public class RecipeSeedData {

    public static void seedRecipes(SQLiteDatabase db) {
        //added recipies that i would think cover breakfast, lunch and dinner for now.
        // i mostly love mexican food so all is a variation of that and chinese.
        addRecipe(db,"Scrambled Eggs","Whisk eggs.\nCook in pan.",
                new Object[][]{
                        {"egg", 2.0, "pcs"},
                        {"butter", 10.0, "g"}
                }
        );

        addRecipe(db,"Cheese Toast","Toast bread.\nAdd cheese.",
                new Object[][]{
                        {"bread", 2.0, "pcs"},
                        {"cheese", 50.0, "g"}
                }
        );

        addRecipe(db,"Garlic Rice","Cook rice.\nAdd garlic.",
                new Object[][]{
                        {"rice", 200.0, "g"},
                        {"garlic", 2.0, "pcs"}
                }
        );

        addRecipe(db,"Tomato and Cheese Toasted Sandwich",
                "Place tomato slices and cheese between two slices of bread.\nToast until golden.",
                new Object[][]{
                        {"bread", 2.0, "pcs"},
                        {"tomato", 1.0, "pcs"},
                        {"cheese", 50.0, "g"}
                }
        );

        addRecipe(db,"Avocado Toast",
                "Mash the avocado.\nToast the bread.\nSpread avocado on toast.",
                new Object[][]{
                        {"bread", 1.0, "pcs"},
                        {"avocado", 1.0, "pcs"}
                }
        );

        addRecipe(db,"Egg Fried Rice",
                "Scramble the egg.\nAdd rice.\nAdd soy sauce and stir fry.",
                new Object[][]{
                        {"rice", 200.0, "g"},
                        {"egg", 2.0, "pcs"},
                        {"soy sauce", 1.0, "tbsp"}
                }
        );

        addRecipe(db,"Beef Tacos",
                "Cook onion and beef mince.\nFill taco shells.\nAdd toppings.",
                new Object[][]{
                        {"taco shells", 6.0, "pcs"},
                        {"beef mince", 100.0, "g"},
                        {"onion", 1.0, "pcs"},
                        {"tomato", 1.0, "pcs"},
                        {"lettuce", 50.0, "g"},
                        {"cream cheese", 3.0, "tbsp"}
                }
        );

        addRecipe(db,"Chicken Tacos",
                "Cook chicken.\nFill taco shells.\nAdd toppings.",
                new Object[][]{
                        {"taco shells", 6.0, "pcs"},
                        {"chicken", 200.0, "g"},
                        {"onion", 1.0, "pcs"},
                        {"tomato", 1.0, "pcs"},
                        {"lettuce", 50.0, "g"},
                        {"cream cheese", 3.0, "tbsp"}
                }
        );

        addRecipe(db,"Pork Tacos",
                "Cook pork.\nFill taco shells.\nAdd toppings.",
                new Object[][]{
                        {"taco shells", 6.0, "pcs"},
                        {"pork", 200.0, "g"},
                        {"onion", 1.0, "pcs"},
                        {"tomato", 1.0, "pcs"},
                        {"lettuce", 50.0, "g"},
                        {"cream cheese", 3.0, "tbsp"}
                }
        );

        addRecipe(db,"Beef Nachos",
                "Cook beef mince.\nLayer over chips.\nAdd toppings and cheese.",
                new Object[][]{
                        {"beef mince", 200.0, "g"},
                        {"onion", 1.0, "pcs"},
                        {"avocado", 1.0, "pcs"},
                        {"cream cheese", 3.0, "tbsp"},
                        {"salsa", 3.0, "tbsp"},
                        {"nacho chips", 100.0, "g"},
                        {"cheese", 50.0, "g"}
                }
        );

        addRecipe(db,"Chicken Nachos",
                "Cook chicken.\nLayer over chips.\nAdd toppings and cheese.",
                new Object[][]{
                        {"chicken", 200.0, "g"},
                        {"onion", 1.0, "pcs"},
                        {"cream cheese", 3.0, "tbsp"},
                        {"salsa", 3.0, "tbsp"},
                        {"nacho chips", 100.0, "g"},
                        {"cheese", 50.0, "g"}
                }
        );

        addRecipe(db,"Pork Nachos",
                "Cook pork.\nLayer over chips.\nAdd toppings and cheese.",
                new Object[][]{
                        {"pork", 200.0, "g"},
                        {"onion", 1.0, "pcs"},
                        {"cream cheese", 3.0, "tbsp"},
                        {"salsa", 3.0, "tbsp"},
                        {"nacho chips", 100.0, "g"},
                        {"cheese", 50.0, "g"}
                }
        );

        addRecipe(db,"Beef Enchiladas","Cook mince.\nFill wrap.\nRoll and bake.",
                new Object[][]{
                        {"beef mince", 100.0, "g"},
                        {"onion", 1.0, "pcs"},
                        {"cream cheese", 3.0, "tbsp"},
                        {"cheese", 50.0, "g"},
                        {"tortilla wraps", 2.0, "pcs"}
                }
        );

        addRecipe(db,"Chicken Enchiladas","Cook chicken.\nFill wrap.\nRoll and bake.",
                new Object[][]{
                        {"chicken", 200.0, "g"},
                        {"onion", 1.0, "pcs"},
                        {"cream cheese", 3.0, "tbsp"},
                        {"cheese", 50.0, "g"},
                        {"tortilla wraps", 2.0, "pcs"}
                }
        );

        addRecipe(db,"Pork Enchiladas","Cook pork.\nFill wrap.\nRoll and bake.",
                new Object[][]{
                        {"pork", 200.0, "g"},
                        {"onion", 1.0, "pcs"},
                        {"cream cheese", 3.0, "tbsp"},
                        {"cheese", 50.0, "g"},
                        {"tortilla wraps", 2.0, "pcs"}
                }
        );

        addRecipe(db,"Beef Quesadilla","Fill wraps with ingredients.\nCook until melted.",
                new Object[][]{
                        {"beef mince", 100.0, "g"},
                        {"onion", 1.0, "pcs"},
                        {"tomato", 1.0, "pcs"},
                        {"cream cheese", 3.0, "tbsp"},
                        {"cheese", 100.0, "g"},
                        {"tortilla wraps", 2.0, "pcs"}
                }
        );

        addRecipe(db,"Chicken Quesadilla","Fill wraps with ingredients.\nCook until melted.",
                new Object[][]{
                        {"chicken", 200.0, "g"},
                        {"tomato", 1.0, "pcs"},
                        {"cream cheese", 3.0, "tbsp"},
                        {"cheese", 100.0, "g"},
                        {"tortilla wraps", 2.0, "pcs"}
                }
        );

        addRecipe(db,"Pork Quesadilla","Fill wraps with ingredients.\nCook until melted.",
                new Object[][]{
                        {"pork", 200.0, "g"},
                        {"tomato", 1.0, "pcs"},
                        {"cream cheese", 3.0, "tbsp"},
                        {"cheese", 100.0, "g"},
                        {"tortilla wraps", 2.0, "pcs"}
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