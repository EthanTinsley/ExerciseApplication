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

        String createTableStatement = "\n" +
                "CREATE TABLE workoutTemplate IF NOT EXISTS (\n" +
                "templateID int UNIQUE ,\n" +
                "templateTitle VARCHAR(255) ,\n" +
                "PRIMARY KEY(templateID , templateTitle)) ;\n" +
                "\n" +
                "\n" +
                "CREATE TABLE workoutActive IF NOT EXISTS(\n" +
                "templateID int ,\n" +
                "workoutID int , \n" +
                "dateCompleted datetime ,\n" +
                "duration double ,\n" +
                "PRIMARY KEY (templateID , workoutID) ,\n" +
                "FOREIGN KEY (templateID) REFERENCES workoutTemplate (templateID)) ;\n" +
                "\n" +
                "\n" +
                "CREATE TABLE muscleGroup IF NOT EXISTS(\n" +
                "muscleGroupName VARCHAR(255) UNIQUE ,\n" +
                "PRIMARY KEY (muscleGroupName)) ;\n" +
                "\n" +
                "\n" +
                "CREATE TABLE exerciseTemplate IF NOT EXISTS ( \n" +
                "exerciseID int UNIQUE ,\n" +
                "exerciseName VARCHAR(255) ,\n" +
                "exerciseMuscleGroup VARCHAR(255) ,\n" +
                "description VARCHAR(255) ,\n" +
                "imgName VARCHAR(255) ,\n" +
                "PRIMARY KEY(exerciseID, exerciseName),\n" +
                "FOREIGN KEY(exerciseMuscleGroup) REFERENCES muscleGroup(muscleGroupName)) ;\n" +
                "\n" +
                "\n" +
                "CREATE TABLE exerciseActive IF NOT EXISTS(\n" +
                "templateID int ,\n" +
                "exerciseID int ,\n" +
                "exerciseName VARCHAR(255) ,\n" +
                "exerciseMuscleGroup VARCHAR(255) ,\n" +
                "description VARCHAR(255) ,\n" +
                "imgName VARCHAR(255) ,\n" +
                "repCount int ,\n" +
                "setCount int ,\n" +
                "PRIMARY KEY (templateID , exerciseID) ,\n" +
                "FOREIGN KEY (templateID) REFERENCES workoutTemplate (templateID) ,\n" +
                "FOREIGN KEY (exerciseID) REFERENCES exerciseTemplate (exerciseID)) ;" ;



        db.execSQL(createTableStatement);


    }


    // this is called if the database version number changes. IT prevents previous users apps from breaking when you change the database design.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
