package com.example.android.habittrackerapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.android.habittrackerapp.HabitContract.HabitEntry;

/**
 * Created by Francis Gálvez on 25/06/2017.
 */
public class HabitDbManager {

    /**
     * Database helper that will provide us access to the database
     */
    private HabitDbHelper habitDbHelper;

    /**
     * Helper method to insert hardcoded habit data into the database. For debugging purposes only.
     */
    private void insertHabit() {
        // Gets the database in write mode
        SQLiteDatabase db = habitDbHelper.getWritableDatabase();

        // Create a ContentValues object where column names are the keys,
        // and the habit's attributes are the values.
        ContentValues values = new ContentValues();
        values.put(HabitEntry.COLUMN_HABITS_NAME, "Listen to music");
        values.put(HabitEntry.COLUMN_HABITS_TIMES, 3);

        values.put(HabitEntry.COLUMN_HABITS_NAME, "Go running");
        values.put(HabitEntry.COLUMN_HABITS_TIMES, 1);

        // Insert a new row for this habit in the database, returning the ID of that new row.
        // The first argument for db.insert() is the Habits table name.
        // The second argument provides the name of a column in which the framework
        // can insert NULL in the event that the ContentValues is empty (if
        // this is set to "null", then the framework will not insert a row when
        // there are no values).
        // The third argument is the ContentValues object containing the info for Toto.
        long newRowId = db.insert(HabitEntry.TABLE_NAME, null, values);
    }

    /**
     * Temporary helper method to display information in the onscreen TextView about the state of
     * the Habits database.
     */
    private Cursor readHabits() {
        // Create and/or open a database to read from it
        SQLiteDatabase db = habitDbHelper.getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                HabitEntry.COLUMN_HABITS_NAME,
                HabitEntry.COLUMN_HABITS_TIMES};

        String selection = HabitEntry.COLUMN_HABITS_TIMES + ">= ?";
        String[] selectionArgs = new String[]{"1"};

        // Perform a query on the Habits table
        Cursor cursor = db.query(
                HabitEntry.TABLE_NAME, // The table to query
                projection,            // The columns to return
                selection,             // The columns for the WHERE clause
                selectionArgs,         // The values for the WHERE clause
                null,                  // Don't group the rows
                null,                  // Don't filter by row groups
                null);                 // The sort order

        return cursor;
    }
}
