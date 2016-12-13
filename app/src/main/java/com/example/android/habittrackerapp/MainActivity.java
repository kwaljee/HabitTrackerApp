package com.example.android.habittrackerapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.android.habittrackerapp.data.HabitContract.HabitEntry;
import com.example.android.habittrackerapp.data.HabitTrackerDbHelper;

public class MainActivity extends AppCompatActivity {

    private HabitTrackerDbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayDatabaseInfo();
        mDbHelper = new HabitTrackerDbHelper(this);
        insertHabit();
    }

    private void displayDatabaseInfo() {
        // To access our database, we instantiate our subclass of SQLiteOpenHelper
        // and pass the context, which is the current activity.
        mDbHelper = new HabitTrackerDbHelper(this);

        // Create and/or open a database to read from it
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        // Perform this raw SQL query "SELECT * FROM habits"
        // to get a Cursor that contains all rows from the habits table.
        Cursor cursor = db.rawQuery("SELECT * FROM " + HabitEntry.TABLE_NAME, null);
        try {
            // Display the number of rows in the Cursor (which reflects the number of rows in the
            // habits table in the database).
            TextView displayView = (TextView) findViewById(R.id.textView);
            displayView.setText("Number of rows in 'habits' database table: " + cursor.getCount());
        } finally {
            // Always close the cursor when you're done reading from it. This releases all its
            // resources and makes it invalid.
            cursor.close();
        }
    }

    private void insertHabit() {
        // Gets the data repository in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();

        values.put(HabitEntry.COLUMN_HABIT_NAME, "Meditation");
        values.put(HabitEntry.COLUMN_PROGRESS, 1);

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(HabitEntry.TABLE_NAME, null, values);

        Log.v("MainActivity", "New row ID" + newRowId);
    }
}