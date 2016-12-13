package com.example.android.habittrackerapp.data;

import android.provider.BaseColumns;

public class HabitContract {

    private HabitContract(){}

    public static final class HabitEntry implements BaseColumns {

        public final static String TABLE_NAME = "habits";

        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_HABIT_NAME = "name";
        public final static String COLUMN_PROGRESS = "progress";

        public final static int COLUMN_PROGRESS_NOT_STARTED = 0;
        public final static int COLUMN_PROGRESS_IN_PROCESS = 1;
        public final static int COLUMN_PROGRESS_COMPLETED = 2;
    }
}