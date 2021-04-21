package com.exerciseapplication.finalexerciseapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String TEMPLATE_ID = "templateID";
    public static final String TEMPLATE_TITLE = "templateTitle";
    public static final String TEMPLATE_DESCRIPTION = "templateDescription";
    public static final String TEMPLATE_STRETCHES = "templateStretches";
    public static final String WORKOUT_ID = "workoutID";
    public static final String WORKOUT_DURATION = "workoutDuration";
    public static final String WORKOUT_DATE = "workoutDate";
    public static final String WORKOUT_TIME = "workoutTime";
    public static final String EXERCISE_TABLE = "exercise";
    public static final String EXERCISE_ID = EXERCISE_TABLE + "ID";
    public static final String EXERCISE_NAME = EXERCISE_TABLE + "Name";
    public static final String EXERCISE_DESCRIPTION = EXERCISE_TABLE + "Description";
    public static final String EXERCISE_IMG_ID = EXERCISE_TABLE + "ImgID";
    public static final String REP_COUNT = "repCount";
    public static final String SET_COUNT = "setCount";
    public static final String WORKOUT_COMPLETED_TABLE = "workoutCompleted";
    public static final String WORKOUT_TEMPLATE_TABLE = "workoutTemplate";

    public DataBaseHelper(@Nullable Context context) {
        super(context, "workoutApp.db", null, 1 );
    }

    // this is called the first time a database is accessed. There Should be code here to create a new database.
    @Override
    public void onCreate(SQLiteDatabase db) {

        String CreateWorkoutTemplateTableStatement = "CREATE TABLE " + WORKOUT_TEMPLATE_TABLE + "(\n" +
                TEMPLATE_ID + " int UNIQUE ,\n" +
                TEMPLATE_TITLE + " VARCHAR(255) ,\n" +
                TEMPLATE_DESCRIPTION + " VARCAHR (1023) ,\n" +
                TEMPLATE_STRETCHES + " VARCHAR (1023) ,\n" +
                "PRIMARY KEY(" + TEMPLATE_ID + ")) ;\n" +  "\n" ;

        String CreateCompletedWorkoutTableStatement = "CREATE TABLE " + WORKOUT_COMPLETED_TABLE + " (\n" +
                TEMPLATE_ID + " int ,\n" +
                WORKOUT_ID + " int,\n" +
                WORKOUT_DURATION + " double ,\n" +
                WORKOUT_DATE + " date ,\n" +
                WORKOUT_TIME + " time ,\n" +
                "PRIMARY KEY(" + TEMPLATE_ID + " , " + WORKOUT_ID + "),\n" +
                "FOREIGN KEY(" + TEMPLATE_ID + ") REFERENCES " + WORKOUT_TEMPLATE_TABLE + "(" + TEMPLATE_ID + ")) ;\n" + "\n" ;

        String  CreateExerciseTableStatement = "CREATE TABLE " + EXERCISE_TABLE + " ( \n" +
                TEMPLATE_ID + " int ,\n" +
                EXERCISE_ID + " int ,\n" +
                EXERCISE_NAME + " VARCHAR(255) NOT NULL ,\n" +
                EXERCISE_DESCRIPTION + " VARCHAR(1023) ,\n" +
                EXERCISE_IMG_ID + " int ,\n" +
                REP_COUNT + " int ,\n" +
                SET_COUNT + " int ,\n" +
                "PRIMARY KEY(" + TEMPLATE_ID + " , " + EXERCISE_ID + ") ,\n" +
                "FOREIGN KEY(" + TEMPLATE_ID + ") REFERENCES " + WORKOUT_TEMPLATE_TABLE + "(" + TEMPLATE_ID + ")) ;" ;

        db.execSQL(CreateWorkoutTemplateTableStatement);
        db.execSQL(CreateCompletedWorkoutTableStatement);
        db.execSQL(CreateExerciseTableStatement);


    }


    // this is called if the database version number changes. IT prevents previous users apps from breaking when you change the database design.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public int getNewWorkoutTemplateID(){

        // get the max workout template id from database
        int templateID = 1;

        // query to get the highest id value
        String query = "SELECT MAX(" + TEMPLATE_ID + ") FROM " + WORKOUT_TEMPLATE_TABLE ;

        SQLiteDatabase database = this.getReadableDatabase() ;

        Cursor result = database.rawQuery(query,null);

        if (result.moveToFirst()) {
            templateID = result.getInt(0);
        }
        else {
            // if cursor returns nothing - do nothing
        }

        return templateID + 1 ;
    }

    public boolean NewWorkout(Workout workout){

        // takes in a workout object and stores it into the database
        SQLiteDatabase database = this.getWritableDatabase() ; // create database connection
        ContentValues ContentValues = new ContentValues() ;    // Values to insert into database

        int templateID = getNewWorkoutTemplateID(); // workout id --> database only

        ContentValues.put(TEMPLATE_ID, templateID);
        ContentValues.put(TEMPLATE_TITLE, workout.getTitle());
        ContentValues.put(TEMPLATE_DESCRIPTION, workout.getDescription());
        ContentValues.put(TEMPLATE_STRETCHES, workout.getStretches());

        // use insert to store the data in the database
        // imsert will return -1 if it fails
        // if it does not return -1 then return that the workout it true
        long insert = database.insert(WORKOUT_TEMPLATE_TABLE,null, ContentValues);

        if (insert == -1) {
            return false ;
        } else {
            return true ;
        }

    }

    public boolean addExercise(String WorkoutName , Exercise exercise){


        return true ;
    }

}
