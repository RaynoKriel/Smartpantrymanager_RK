package com.raynokriel.smartpantrymanager;

/**
 * Represents one ingredient required by a recipe to be made like [Egg (2 pcs)]
 * Each recipe stores multiple RecipeIngredient objects.
 * this relation points to one recipy -> multiple ingredients.
 * or one ingredient -> multiple recipies
 */
public class RecipeIngredient {

    //Ingredient name.
    private final String name;
     //Quantity needed
    private final double quantity;
    //Unit needed like 2kg perhaps
    private final String unit;
    //Constructor (parametised as well
    public RecipeIngredient(String name,
                            double quantity,
                            String unit) {

        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
    }

    //Ingredient name, QTY, Unit getters
    public String getName() {
        return name;
    }
    public double getQuantity() {
        return quantity;
    }
    public String getUnit() {
        return unit;
    }
}