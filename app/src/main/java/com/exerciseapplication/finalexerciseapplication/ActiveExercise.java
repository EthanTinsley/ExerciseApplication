package com.exerciseapplication.finalexerciseapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.health.TimerStat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.security.spec.ECField;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;

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
    protected String DurationString;
    protected String CompletedWorkoutString ;

    protected int currPosition;
    protected int maxPosition;
    protected int Iterator ;
    protected int ExerciseImageID ;


    protected DataBaseHelper DataBaseHelper ;
    protected Exercise currExercise ;
    protected List<Exercise> ExerciseList;
    protected Workout ActiveWorkout;

    protected Date StartTime ;
    protected Date EndTime ;

    protected long TimerStart ;
    protected long TimerEnd ;
    protected long WorkoutDuration ;
    protected long TimeOfWorkout ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active_exercise);

        // Record the date when workout starts
        StartTime.getTime();
        TimerStart = StartTime.getTime();

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
        this.ActiveWorkout = new Workout(WorkoutName, ExerciseList);

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

            nextExercise();

            }
        });

        //PreviousExercise button
        PreviousExercise.setVisibility(View.GONE); // by default hide as there is no previous exercise
        PreviousExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            previousExercise();

            }
        });

        //EndWorkoutButton
        EndWorkout = (Button) findViewById(R.id.EndWorkoutButton);
        EndWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                endWorkout() ;
                Toast.makeText(ActiveExercise.this, CompletedWorkoutString, Toast.LENGTH_LONG).show();

            }
        });

    }



    protected void nextExercise(){

        if (ActiveWorkout.hasNext()) {

            // Get the new current Exercise to display
            currExercise = ActiveWorkout.nextExercise();

            // Display Exercise Title
            ActiveExerciseTitle.setText(currExercise.getName());

            // Display Exercise Description
            ActiveExerciseDescription.setText(currExercise.getDescription());

            // Display Exercise Image
            ActiveExerciseImage.setImageResource(currExercise.getImageID());

            // Display Exercise Rep count
            repCount = "Reps: " + currExercise.getRepCount();
            ActiveExerciseRepCount.setText(repCount);

            //Display Exercise Set Count
            setCount = "Sets: " + currExercise.getSetCount();
            ActiveExerciseSetCount.setText(setCount);

            // Display Workout Progress
            currPosition = ActiveWorkout.getIterator()+1;
            ExerciseCounter = currPosition + "/" + maxPosition;
            ActiveExerciseCount.setText(ExerciseCounter);

        }

        PreviousExercise.setVisibility(View.VISIBLE);

    }

    protected void previousExercise() {

        if (ActiveWorkout.hasPrevious()){

            // Get the new current Exercise to display
            currExercise = ActiveWorkout.previousExercise();

            // Display Exercise Title
            ActiveExerciseTitle.setText(currExercise.getName());

            // Display Exercise Description
            ActiveExerciseDescription.setText(currExercise.getDescription());

            // Display Exercise Image
            ActiveExerciseImage.setImageResource(currExercise.getImageID());

            // Display Exercise Rep count
            repCount = "Reps: " + currExercise.getRepCount();
            ActiveExerciseRepCount.setText(repCount);

            //Display Exercise Set Count
            setCount = "Sets: " + currExercise.getSetCount();
            ActiveExerciseSetCount.setText(setCount);

            // Display Workout Progress
            currPosition = ActiveWorkout.getIterator()+1;
            ExerciseCounter = currPosition + "/" + maxPosition;
            ActiveExerciseCount.setText(ExerciseCounter);

            if (!ActiveWorkout.hasPrevious()){
                PreviousExercise.setVisibility(View.GONE);
            }
        }
    }

    protected void endWorkout(){

        // find the duration of the workout by subtracting start time from end time
        TimerEnd = EndTime.getTime() ;
        WorkoutDuration = TimerEnd - TimerStart ;
        WorkoutDuration = WorkoutDuration / 1000 ; // Format from miliseconds to seconds

        // Format Duration into a String
        // if lasted more than 60 seconds convert to minutes
        // if more than 60 minutes convert to hours
        if (WorkoutDuration > 60){ // more than 60 seconds
            WorkoutDuration /= 60 ;
            if (WorkoutDuration > 60) { // more than 60 minutes
                WorkoutDuration /= 60;
                DurationString = WorkoutDuration + " Hours";
            }
            else DurationString = WorkoutDuration + " Minutes" ; // minutes
        }
        else DurationString = WorkoutDuration + " Seconds" ;

        ActiveWorkout.setDateTotal(StartTime.toString());
        ActiveWorkout.setDuration(DurationString);
        ActiveWorkout.setTime(StartTime.toString());

        DataBaseHelper.finishWorkout(ActiveWorkout);

        CompletedWorkoutString = "Workout: " + ActiveWorkout.getTitle() + " Completed! " + "\n" +
                "Duration: " + ActiveWorkout.getDuration() + "\n" + "test date " + ActiveWorkout.getDateTotal() + "\n" +
                "test time: " + ActiveWorkout.getTime();

    }


}