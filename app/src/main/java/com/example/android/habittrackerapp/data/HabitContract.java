package com.example.android.habittrackerapp.data;

import android.provider.BaseColumns;

class HabitContract {

    //An empty private constructor makes sure that the class is not going to be initialised.
    private HabitContract(){}

    static final class HabitEntry implements BaseColumns {

        final static String TABLE_NAME = "habits";

        final static String COLUMN_HABIT_NAME = "name";
        final static String COLUMN_PROGRESS = "progress";

        public final static int COLUMN_PROGRESS_NOT_STARTED = 0;
        public final static int COLUMN_PROGRESS_IN_PROCESS = 1;
        public final static int COLUMN_PROGRESS_COMPLETED = 2;
    }
}