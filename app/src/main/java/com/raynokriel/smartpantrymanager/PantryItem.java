package com.raynokriel.smartpantrymanager;

/**
 * PantryItem represents a single ingredient currently stored in the user's pantry.
 * Each pantry item stores:
 * A unique database identifier, Ingredient name, Quantity available
 * Unit of measurement, Optional expiry date (like the table is layed out)
 * data container used for pantry items
 */
public class PantryItem {

    //Unique database identifier later be generated automatically by SQLite.
    private long id;

    // Name of the ingredient. (Egg)
    private String name;

    //Quantity
    private double quantity;

     // Unit associated with the quantity of the item (ml / kg etc)
    private String unit;
    //expiry date. (yyyy-MM-dd)
    private String expiryDate;

    //Empty constructor. Just incase objects are created before values are entered
    public PantryItem() {
    }

    // Constructor for fully populated pantry item. (parameterized)
    public PantryItem(long id,
                      String name,
                      double quantity,
                      String unit,
                      String expiryDate) {

        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
        this.expiryDate = expiryDate;
    }

    //standard getters and setters from the class below
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    /**
     * Changing the ingredient name here will affect how the item appears
     * throughout the entire application with the use of the name "setter".
     */
    public void setName(String name) {
        this.name = name;
    }

    public double getQuantity() {
        return quantity;
    }

    // setter used for QTY can be used in the matching as well
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
    //this one i will try and use for the notification on expired products
    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }
}