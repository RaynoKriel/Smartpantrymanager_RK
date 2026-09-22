package com.raynokriel.smartpantrymanager;

import java.util.List;
import java.util.Locale;

//the main function to macth ingredients to valid recipies
public class MatchingUtils {
    //since we can not use natural language processeing this will be a
    //makeshift version of it to help us match items
    public static String normalize(String value) {

        if (value == null) {
            return "";
        }
        //simple substring method only not NLP
        String result = value.trim().toLowerCase(Locale.ROOT);
        //plural words like tamatoes remove the last 2 char to get tamato
        if (result.endsWith("es") && result.length() > 4) {
            result = result.substring(0, result.length() - 2);
        //else words like eggs we cut to egg
        } else if (result.endsWith("s") && result.length() > 3) {
            result = result.substring(0, result.length() - 1);
        }
        return result;
    }
    //function matching all items to a single recipy
    // if not all items present then can make it
    public static boolean canMake(Recipe recipe, List<PantryItem> pantry) {
        for (RecipeIngredient needed : recipe.getIngredients()) {
            if (!pantryHasEnough(needed, pantry)) {
                return false;
            }
        }
        return true;
    }
    //function to check even if all items are in pantry if there is enough
    private static boolean pantryHasEnough(RecipeIngredient needed, List<PantryItem> pantry) {
        //calling my custom simple plural/normalize method
        String neededName = normalize(needed.getName());
        for (PantryItem item : pantry) {
            if (normalize(item.getName()).equals(neededName)) {
                return item.getQuantity() >= needed.getQuantity();
            }
        }
        return false;
    }
}