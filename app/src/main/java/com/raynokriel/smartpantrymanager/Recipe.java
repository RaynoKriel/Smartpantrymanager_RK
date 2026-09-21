package com.raynokriel.smartpantrymanager;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a suggested recipe to the user.
 * A recipe (Name, steps, ingredients needed)
 */
public class Recipe {

    // variables for ID, Name, Steps and Ingredients
    private final long id;
    private final String name;
    private final String steps;
    private List<RecipeIngredient> ingredients = new ArrayList<>();
    //Constructor.
    public Recipe(long id,
                  String name,
                  String steps) {

        this.id = id;
        this.name = name;
        this.steps = steps;
    }

    // getters for the id, name and steps + ingredients
    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getSteps() {
        return steps;
    }
    public List<RecipeIngredient> getIngredients() {
        return ingredients;
    }

    //set a list of ingredients that can make the recipy in the future
    public void setIngredients(List<RecipeIngredient> ingredients) {
        this.ingredients = ingredients;
    }
}