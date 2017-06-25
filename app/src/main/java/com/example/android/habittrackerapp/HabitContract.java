package com.example.android.habittrackerapp;

import android.provider.BaseColumns;

/**
 * Created by Francis Gálvez on 25/06/2017.
 */
class HabitContract {
    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    private HabitContract() {
    }

    /**
     * Inner class that defines constant values for the habits database table.
     * Each entry in the table represents a single habit.
     */
    static final class HabitEntry implements BaseColumns {

        /**
         * Name of database table for habits
         */
        final static String TABLE_NAME = "habits";

        /**
         * Unique ID number for the habit (only for use in the database table).
         * <p>
         * Type: INTEGER
         */
        final static String _ID = BaseColumns._ID;

        /**
         * Name of the habit.
         * <p>
         * Type: TEXT
         */
        final static String COLUMN_HABITS_NAME = "name";

        /**
         * Value of the times that habit was done in the day.
         * <p>
         * Type: INTEGER
         */
        final static String COLUMN_HABITS_TIMES = "times";
    }
}
