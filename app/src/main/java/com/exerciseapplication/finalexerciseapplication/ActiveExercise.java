package com.exerciseapplication.finalexerciseapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.security.spec.ECField;
import java.util.LinkedList;

public class ActiveExercise extends AppCompatActivity {

    TextView ActiveExerciseTitle ;
    TextView ActiveExerciseDescription;
    TextView ActiveExerciseRepCount ;
    TextView ActiceExerciseSetCount ;
    ImageView ActiveExerciseImage;

    Button PreviousExercise ;
    Button NextExercise ;
    Button EndWorkout ;

    String WorkoutName ;
    String ExerciseName ;
    String ExerciseDescription;
    String WorkoutPosition ;
    int ExerciseImageID ;
    int repCount ;
    int setCount ;

    Workout ActiveWorkout ;
    LinkedList<Exercise> ExerciseList ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active_exercise);

        // Need to get the identity of the assests being utilized
        // Need to get the resource value for ActiveExerciseTitle
        ActiveExerciseTitle = (TextView) findViewById(R.id.ActiveExerciseTitle);

        //Need to get the resource value for ActiveExerciseDescripton
        ActiveExerciseDescription = (TextView) findViewById(R.id.ActiveExerciseDescription);

        // Need to get the resource value for ActiveExerciseRepCount
        ActiveExerciseRepCount = (TextView) findViewById(R.id.ActiveExerciseRepCount);

        // Need to get resource value for ActiveExerciseSetCount
        ActiceExerciseSetCount = (TextView) findViewById(R.id.ActiveExerciseSetCount);

        //Need to get resource value for ActiveExerciseImage
        ActiveExerciseImage = (ImageView) findViewById(R.id.ActiveExerciseImage);

        // Need to get resource values for buttons
        // Get resource value of PreviousExercise
        PreviousExercise = (Button) findViewById(R.id.PreviousExerciseButton);

        //Get Resource value for NextExercise Button
        NextExercise = (Button) findViewById(R.id.NextExerciseButton);

        // Get resource value for end workout button
        EndWorkout = (Button) findViewById(R.id.EndWorkoutButton);

        // Use an intent to get the workoutName
        WorkoutName = getIntent().getStringExtra("WorkoutTitle");

        //Create Workout Object
        ActiveWorkout = new Workout(WorkoutName);

        // Retrieve the exercises in the Workout Through a database call
        DataBaseHelper DataBaseHelper = new DataBaseHelper(ActiveExercise.this);
        ExerciseList = DataBaseHelper.fillWorkout(WorkoutName);



        // Make Buttons iterate through the workout object
        NextExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
        // End button should give a toast, go to completed workouts and upload this workout to the datbase under completed

        // by default make the layout the first exercise!
        // Create methods outside on create that reset all the elements to the new exercise
        // Dont show previous button until next exercise has been pressed 
    }
}