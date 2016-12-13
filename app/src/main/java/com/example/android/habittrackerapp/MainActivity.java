package com.example.android.habittrackerapp;


import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.android.habittrackerapp.data.HabitTrackerDbHelper;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HabitTrackerDbHelper mDbHelper = new HabitTrackerDbHelper(this);
        mDbHelper.insertHabit();

        Cursor cursor = mDbHelper.readAllHabits();

        TextView displayView = (TextView) findViewById(R.id.textView);
        displayView.setText("The habits table contains " + cursor.getCount() + " habits.\n\n");
    }
}