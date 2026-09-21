package com.raynokriel.smartpantrymanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

//DatabaseHelper for all communication between the app and SQLite db.
public class DatabaseHelper extends SQLiteOpenHelper {

     //DB name stored on the device. (SQlite)
    private static final String DATABASE_NAME = "smart_pantry.db";
    //DBversion incase DB changes
    private static final int DATABASE_VERSION = 1;

    // table 1:  Pantry table
    public static final String TABLE_PANTRY = "pantry";
    //columns
    public static final String COL_ID = "_id";
    public static final String COL_NAME = "name";
    public static final String COL_QUANTITY = "quantity";
    public static final String COL_UNIT = "unit";
    public static final String COL_EXPIRY = "expiry_date";

    //Constructor with parameters (name, version etc)
    public DatabaseHelper(Context context) {
        super(
                context,
                DATABASE_NAME,
                null,
                DATABASE_VERSION
        );
    }

    //starts automatically the first time. (DB is then created incl tables etc.)
    @Override
    public void onCreate(SQLiteDatabase db) {

        String createPantryTable = "CREATE TABLE " + TABLE_PANTRY + " (" +
                        COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COL_NAME + " TEXT NOT NULL, " +
                        COL_QUANTITY + " REAL NOT NULL, " +
                        COL_UNIT + " TEXT NOT NULL, " +
                        COL_EXPIRY + " TEXT" +
                        ")";

        db.execSQL(createPantryTable);
    }

    // upgrade method if the DB changes and need to be upgraded
    @Override
    public void onUpgrade(
            SQLiteDatabase db,
            int oldVersion,
            int newVersion
    ) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PANTRY);

        onCreate(db);
    }

    // CRUD functions/methods below
    // CREATE , new item (into the DB)
    public long addPantryItem(PantryItem item) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_NAME, item.getName());
        values.put(COL_QUANTITY, item.getQuantity());
        values.put(COL_UNIT, item.getUnit());
        values.put(COL_EXPIRY, item.getExpiryDate());

        return db.insert(TABLE_PANTRY,null,values);
    }

    // CRUD READ (select)
    public List<PantryItem> getAllPantryItems() {

        List<PantryItem> items = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.query(TABLE_PANTRY,null,null,
                null,null,null,
                COL_NAME + " ASC"
        );
        //building a cursor to read through the db and build the object to return all
        if (cursor.moveToFirst()) {
            do {
                PantryItem item = new PantryItem();
                item.setId(cursor.getLong(cursor.getColumnIndexOrThrow(COL_ID)));
                item.setName(cursor.getString(cursor.getColumnIndexOrThrow(COL_NAME)));
                item.setQuantity(cursor.getDouble(cursor.getColumnIndexOrThrow(COL_QUANTITY)));
                item.setUnit(cursor.getString(cursor.getColumnIndexOrThrow(COL_UNIT)));
                item.setExpiryDate(cursor.getString(cursor.getColumnIndexOrThrow(COL_EXPIRY)));
                items.add(item);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return items;
    }
    //same , but only brings back one item by ID
    public PantryItem getPantryItem(long id) {

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(TABLE_PANTRY,null,COL_ID + "=?",
                        new String[]{String.valueOf(id)},null,
                        null,null
                );
        PantryItem item = null;

        if (cursor.moveToFirst()) {
            item = new PantryItem();
            item.setId(cursor.getLong(cursor.getColumnIndexOrThrow(COL_ID)));
            item.setName(cursor.getString(cursor.getColumnIndexOrThrow(COL_NAME)));
            item.setQuantity(cursor.getDouble(cursor.getColumnIndexOrThrow(COL_QUANTITY)));
            item.setUnit(cursor.getString(cursor.getColumnIndexOrThrow(COL_UNIT)));
            item.setExpiryDate(cursor.getString(cursor.getColumnIndexOrThrow(COL_EXPIRY)));
        }
        cursor.close();
        return item;
    }

    //CRUD UPDATE (Edit current item)
    public int updatePantryItem(PantryItem item) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COL_NAME, item.getName());
        values.put(COL_QUANTITY, item.getQuantity());
        values.put(COL_UNIT, item.getUnit());
        values.put(COL_EXPIRY, item.getExpiryDate());

        return db.update(TABLE_PANTRY,values,COL_ID + "=?",
                new String[]{
                        String.valueOf(item.getId())
                }
        );
    }

    // CRUD DELETE (remove item by id)
    public void deletePantryItem(long id) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_PANTRY,COL_ID + "=?",
                new String[]{
                        String.valueOf(id)
                }
        );
    }
}