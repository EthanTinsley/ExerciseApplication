package com.exerciseapplication.finalexerciseapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

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

    // Initializing a Database helper object uses this class as context , database name for file , and version number
    public DataBaseHelper(@Nullable Context context) {
        super(context, "workoutApp.db", null, 1 );
    }

    // this is called the first time a database is accessed. There Should be code here to create a new database.
    // Uses strings to hold SQL queries that would create the appropriate tables
    // db.execSQL() passes the string to create table to SQLite and creates the tables within the database
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
                TEMPLATE_TITLE +  " VARCHAR(255) ,\n" +
                WORKOUT_DURATION + " VARCHAR(255) ,\n" +
                WORKOUT_DATE + " VARCHAR(255) ,\n" +
                WORKOUT_TIME + " VARCHAR(255) ,\n" +
                "PRIMARY KEY(" + TEMPLATE_ID + " , " + WORKOUT_ID + "),\n" +
                "FOREIGN KEY(" + TEMPLATE_ID + ") REFERENCES " + WORKOUT_TEMPLATE_TABLE + "(" + TEMPLATE_ID + ")) ;\n" + "\n" ;

        String  CreateExerciseTableStatement = "CREATE TABLE " + EXERCISE_TABLE + " ( \n" +
                TEMPLATE_ID + " int ,\n" +
                EXERCISE_ID + " int ,\n" + // Used for Positioning
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
    // ignore this mostly
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    // this method gets the highest template-ID and returns that value + 1
    // used to keep workout templates unique
    // does the job of autoincrement essentially
    public int getNewWorkoutTemplateID(){

        // get the max workout template id from database
        int templateID = 1;

        // query to get the highest id value
        String query = "SELECT MAX(" + TEMPLATE_ID + ") FROM " + WORKOUT_TEMPLATE_TABLE ;

        // creating a database object to read from the database
        SQLiteDatabase database = this.getReadableDatabase() ;

        // used to store results in a list
        Cursor result = database.rawQuery(query,null);

        // getting the results from the result list
        if (result.moveToFirst()) {
            templateID = result.getInt(0) + 1;
        }
        else {
            // if cursor returns nothing - do nothing
        }

        result.close();
        return templateID  ; // new workout template ID
    }

    // NewWorkout() takes a workout object and uploads it into the database
    // Returns a boolean to indicate if data upload was successful or not
    public boolean NewWorkout(Workout workout){

        // takes in a workout object and stores it into the database
        SQLiteDatabase database = this.getWritableDatabase() ; // create database connection
        ContentValues ContentValues = new ContentValues() ;    // Values to insert into database

        // templateID keeps workouts unique inside database
        int templateID = getNewWorkoutTemplateID(); // workout id --> database only

        ContentValues.put(TEMPLATE_ID, templateID);
        ContentValues.put(TEMPLATE_TITLE, workout.getTitle());
        ContentValues.put(TEMPLATE_DESCRIPTION, workout.getDescription());
        ContentValues.put(TEMPLATE_STRETCHES, workout.getStretches());

        // use insert to store the data in the database
        // imsert will return -1 if it fails
        // if it does not return -1 then return that the workout it true
        long insert = database.insert(WORKOUT_TEMPLATE_TABLE,null, ContentValues);

        database.close();

        if (insert == -1) return false ; // if workout upload to database fails
        else return true ; // if workout upload works correctly

    }

    // addExercise() takes an Exercise object and uploads it into the database
    // Exercise is Child of workout also included in method parameters
    // Returns a boolean to indicate if data upload was successful or not
    public boolean addExercise(String WorkoutName , Exercise exercise){

        //Create database and it's values to enter for the new exercise
        SQLiteDatabase database = this.getWritableDatabase() ; // create database connection
        ContentValues ContentValues = new ContentValues() ;    // Values to insert into database

        int TemplateID = getTemplateID(WorkoutName);
        int workoutPosition = getPosition(WorkoutName) ; // position in the workout
        String ExerciseName = exercise.getName(); // Name of exercise
        String ExerciseDescription = exercise.getDescription(); // Description of the exercise
        int ExerciseImageID = exercise.getImageID(); // Image ID of the exercise
        int repCount = exercise.getRepCount(); // how many reps for this exercise
        int setCount = exercise.getSetCount(); // how many sets for this exercise

        // setting our datapoints into a package to pass to the database
        ContentValues.put(TEMPLATE_ID, TemplateID);
        ContentValues.put(EXERCISE_NAME, ExerciseName);
        ContentValues.put(EXERCISE_ID, workoutPosition);
        ContentValues.put(EXERCISE_DESCRIPTION, ExerciseDescription);
        ContentValues.put(EXERCISE_IMG_ID, ExerciseImageID);
        ContentValues.put(REP_COUNT, repCount);
        ContentValues.put(SET_COUNT, setCount);

        // insert returns -1 if upload fails
        long insert = database.insert(EXERCISE_TABLE,null, ContentValues); // attempts to upload to database

        database.close();

        if (insert == -1) return false ; // if data entry fails
        else return true ; // if data entry is successful

    }

    // Use a method to get the next "available" slot in the workout
    // takes a workoutname to identify how many Exercises are in it
    // Returns the position with which the new exercise should be in the database
    public int getPosition(String WorkoutName){

        // default value
        int maxPosition = 0 ;

        // query to get the highest id value
        String query = "SELECT MAX(" + EXERCISE_ID + ") FROM " + EXERCISE_TABLE + " WHERE " + TEMPLATE_ID + " IN "
                + " ( SELECT " + TEMPLATE_ID + " FROM " + WORKOUT_TEMPLATE_TABLE + " WHERE " + TEMPLATE_TITLE +
                " = " + '"' +  WorkoutName + '"' + " );" ;

        System.out.println(query);
        // Create and instance of the database
        SQLiteDatabase database = this.getReadableDatabase() ;

        // Results list for the database query
        Cursor result = database.rawQuery(query, null);

        // get the results from the result list
        if (result.moveToFirst()) {
            maxPosition = result.getInt(0) + 1;
        }
        else {
            // if cursor returns nothing - do nothing
        }

        result.close();
        //return Position of the new Exercise in the Selected Workout
        return maxPosition  ;
    }

    // create a method to get the template ID for a workout based on the workout title
    public int getTemplateID(String WorkoutName){

        //workout title
        int templateID = 0;

        // query to retrieve appropriate id number
        String query = "SELECT " + TEMPLATE_ID + " FROM " + WORKOUT_TEMPLATE_TABLE + " WHERE " + TEMPLATE_TITLE +
                " = " + '"' + WorkoutName + '"' + " ;" ;

        // create a database object
        SQLiteDatabase database = this.getReadableDatabase();

        //stores results
        Cursor result = database.rawQuery(query,null);

        // retrieve results from the query
        if (result.moveToFirst()){
            templateID = result.getInt(0);
        }

        result.close();
        return templateID ; // return template id
    }

    // Create a method that will return a list of all the Exercises that belong to a workout
    // name of the workout is passed as a parameter to the method to be called
    public List<Exercise>  getAddedExercises(String WorkoutName) {

        // List to hold the Exercises returned by search query
        List<Exercise> addedExercises = new ArrayList<>();

        // get data from the database
        String query = "SELECT * FROM " + EXERCISE_TABLE + " WHERE " + TEMPLATE_ID + " IN ( SELECT " +
                TEMPLATE_ID + " FROM " + WORKOUT_TEMPLATE_TABLE + " WHERE " + TEMPLATE_TITLE + " = " + '"' +
                WorkoutName + '"' + " );" ;

        System.out.println(query);

        // Create instance of the database
        SQLiteDatabase database = this.getReadableDatabase();
        // holds results
        Cursor result = database.rawQuery(query, null);

        if (result.moveToFirst()) {
            do {
                int TemplateID = result.getInt(0);
                int ExerciseID = result.getInt(1);
                String ExerciseName = result.getString(2);
                String ExerciseDescription = result.getString(3);
                int ExerciseImageID = result.getInt(4);
                int repCount = result.getInt(5);
                int setCount = result.getInt(6);

                Exercise exercise = new Exercise(ExerciseName);
                exercise.setDescription(ExerciseDescription);
                exercise.setImageID(ExerciseImageID);
                exercise.setRepCount(repCount);
                exercise.setSetCount(setCount);

                System.out.println(exercise);

                addedExercises.add(exercise);

            } while( result.moveToNext());

        }

        result.close();
        database.close();
        return addedExercises ; // return list of exercises

    }

    public List<Workout> getWorkouts(){

        // create list to hold workouts
        List<Workout> workouts = new ArrayList<>();

        // Create the query to return all workouts
        String query = "SELECT * FROM " + WORKOUT_TEMPLATE_TABLE ;

        // Create database instance
        SQLiteDatabase database = getReadableDatabase();

        // Create results list to hold query results
        Cursor results = database.rawQuery(query,null);

        // assing results from database to workout object and then add into the list
        if (results.moveToFirst()){
            do{
                int templateID = results.getInt(0);
                String workoutTitle = results.getString(1);
                String workoutDescription = results.getString(2);
                String workoutStretches = results.getString(3);

                Workout NewWorkout = new Workout(workoutTitle);
                NewWorkout.setDescription(workoutDescription);
                NewWorkout.setStretches(workoutStretches);

                workouts.add(NewWorkout);

            } while(results.moveToNext());
        }

        results.close();
        database.close();
        return workouts ;

    }


public List<Workout> getCompletedWorkouts(){

    // create list to hold workouts
    List<Workout> workouts = new ArrayList<>();

    // Create the query to return all workouts
    String query = "SELECT * FROM " + WORKOUT_COMPLETED_TABLE ;

    // Create database instance
    SQLiteDatabase database = getReadableDatabase();

    // Create results list to hold query results
    Cursor results = database.rawQuery(query,null);

    // assing results from database to workout object and then add into the list
    if (results.moveToFirst()){
        do{

            String workoutTitle = results.getString(2);
            String workoutDuration = results.getString(3);
            String workoutDate = results.getString(4);
            String workoutTime = results.getString(5);

            Workout NewWorkout = new Workout(workoutTitle);
            NewWorkout.setDuration(workoutDuration);
            NewWorkout.setDateTotal(workoutDate);
            NewWorkout.setTime(workoutTime);

            workouts.add(NewWorkout);

        } while(results.moveToNext());
    }

    results.close();
    database.close();
    return workouts ;

}

public boolean finishWorkout(Workout CompletedWorkout){

    // takes in a workout object and stores it into the database
    SQLiteDatabase database = this.getWritableDatabase() ; // create database connection
    ContentValues ContentValues = new ContentValues() ;    // Values to insert into database

    // templateID keeps workouts unique inside database
    int templateID = getTemplateID(CompletedWorkout.getTitle());
    int workoutID = getNewCompletedWorkoutID(); // workout id --> database only

    ContentValues.put(TEMPLATE_ID, templateID);
    ContentValues.put(TEMPLATE_TITLE, CompletedWorkout.getTitle());
    ContentValues.put(WORKOUT_ID, workoutID);
    ContentValues.put(WORKOUT_DATE, CompletedWorkout.getDateTotal());
    ContentValues.put(WORKOUT_DURATION, CompletedWorkout.getDuration());
    ContentValues.put(WORKOUT_TIME, CompletedWorkout.getTime());

    // use insert to store the data in the database
    // imsert will return -1 if it fails
    // if it does not return -1 then return that the workout it true
    long insert = database.insert(WORKOUT_COMPLETED_TABLE,null, ContentValues);

    database.close();

    if (insert == -1) return false ; // if workout upload to database fails
    else return true ; // if workout upload works correctly
}

public int getNewCompletedWorkoutID(){

    // get the max workout template id from database
    int workoutID = 1;

    // query to get the highest id value
    String query = "SELECT MAX(" + WORKOUT_ID + ") FROM " + WORKOUT_COMPLETED_TABLE ;

    // creating a database object to read from the database
    SQLiteDatabase database = this.getReadableDatabase() ;

    // used to store results in a list
    Cursor result = database.rawQuery(query,null);

    // getting the results from the result list
    if (result.moveToFirst()) {
        workoutID = result.getInt(0) + 1;
    }
    else {
        // if cursor returns nothing - do nothing
    }

    result.close();
    return workoutID  ; // new workout template ID
}


}
