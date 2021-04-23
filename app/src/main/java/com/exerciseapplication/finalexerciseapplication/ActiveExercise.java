package com.exerciseapplication.finalexerciseapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.security.spec.ECField;
import java.util.LinkedList;
import java.util.List;

public class ActiveExercise extends AppCompatActivity {

    protected TextView ActiveExerciseTitle ;
    protected TextView ActiveExerciseDescription ;
    protected TextView ActiveExerciseRepCount ;
    protected TextView ActiveExerciseSetCount ;
    protected TextView ActiveExerciseCount ;
    protected ImageView ActiveExerciseImage ;

    protected Button PreviousExercise ;
    protected Button NextExercise ;
    protected Button EndWorkout ;

    protected String WorkoutName;
    protected String ExerciseName ;
    protected String ExerciseDescription;
    protected String WorkoutPosition ;
    protected String ExerciseCounter;
    protected String repCount ;
    protected String setCount ;
    protected int currPosition;
    protected int maxPosition;
    protected int Iterator ;
    protected int ExerciseImageID ;

    protected DataBaseHelper DataBaseHelper ;
    protected Exercise currExercise ;
    protected List<Exercise> ExerciseList;
    protected Workout ActiveWorkout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active_exercise);

        // First we need to identify the componetns being used in the layout
        // find the title
        ActiveExerciseTitle = (TextView) findViewById(R.id.ActiveExerciseTitle);

        // find the Description
        ActiveExerciseDescription = (TextView) findViewById(R.id.ActiveExerciseDescription);

        // find the repCount
        ActiveExerciseRepCount = (TextView) findViewById(R.id.ActiveExerciseRepCount);

        // find the setCount
        ActiveExerciseSetCount = (TextView) findViewById(R.id.ActiveExerciseSetCount);

        // find the Amount of Exercises
        ActiveExerciseCount = (TextView) findViewById(R.id.ActiveExerciseCount);

        // find the Exercise Image
        ActiveExerciseImage = (ImageView) findViewById(R.id.ActiveExerciseImage);

        // Identify the buttons on the layout
        // Previous Button
        PreviousExercise = (Button) findViewById(R.id.PreviousExerciseButton);

        // Next Button
        NextExercise = (Button) findViewById(R.id.NextExerciseButton);

        // End Button
        EndWorkout  = (Button) findViewById(R.id.EndWorkoutButton);

        // Retrieve the name of the workout to use in the database calls
        WorkoutName = getIntent().getStringExtra("WorkoutTitle"); ;

        // Create the database instance
        // retrieve the List of exercises used in the workout
        // Add Exercise list retrieved from database to the Workout object
        DataBaseHelper = new DataBaseHelper(ActiveExercise.this);

        // retrieve list
        ExerciseList = DataBaseHelper.getAddedExercises(WorkoutName);

        // Create Workout
        ActiveWorkout = new Workout(WorkoutName, ExerciseList);

        // Set layout attributes to the first exercise in the workout
        // Layout Title
        ActiveExerciseTitle.setText(ActiveWorkout.getExercise().getName());

        // Layout Description
        ActiveExerciseDescription.setText(ActiveWorkout.getExercise().getDescription());

        //Layout Image
        ActiveExerciseImage.setImageResource(ActiveWorkout.getExercise().getImageID());

        // LAyout rep and set counts
        // can't concatante inside .settext() so we do it beforehand
        repCount = "Reps: " + ActiveWorkout.getExercise().getRepCount() ;
        setCount = "Sets: " + ActiveWorkout.getExercise().getSetCount() ;
        ActiveExerciseRepCount.setText(repCount);
        ActiveExerciseSetCount.setText(setCount);

        // Display that the current posiiton is 1/n Exercises
        // Current Workout position
        currPosition = ActiveWorkout.getIterator()+1;

        // Max Exercises in a workout
        maxPosition = ActiveWorkout.getExerciseCount();

        // Current postition in workout
        ExerciseCounter = "" + currPosition + "/" + maxPosition ;

        // Change text to reflect current position
        ActiveExerciseCount.setText(ExerciseCounter);

        // Make Buttons iterate through the workout object
        // Next exercise Button
        NextExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                ActiveExerciseCount.setText("2/2");
                Toast.makeText(ActiveExercise.this, "Success", Toast.LENGTH_SHORT).show();

            }
        });

        //PreviousExercise button
        PreviousExercise.setVisibility(View.GONE); // by default hide as there is no previous exercise
        PreviousExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



            }
        });

    }






}