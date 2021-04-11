package com.exerciseapplication.finalexerciseapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

    public DataBaseHelper(@Nullable Context context) {
        super(context, "workoutApp.db", null, 1 );
    }

    // this is called the first time a database is accessed. There Should be code here to create a new database.
    @Override
    public void onCreate(SQLiteDatabase db) {

    }


    // this is called if the database version number changes. IT prevents previous users apps from breaking when you change the database design.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
