package com.exerciseapplication.finalexerciseapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class WorkoutStartConfirmation extends AppCompatActivity {


    String WorkoutTitle ;
    String WorkoutDescription ;
    String WorkoutStretches ;
    TextView TitleTextView ;
    TextView DescriptionTextView ;
    TextView StretchesTextView ;
    Button StartWorkout ;
    Intent BeginWorkoutIntent ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_start_confirmation);
        
        // Build the Workout from incoming Intent
        // get Title from the incoming Intent
        WorkoutTitle = getIntent().getStringExtra("WorkoutTitle");

        //get Description from incoming Intent
        WorkoutDescription = getIntent().getStringExtra("WorkoutDescription");
        
        //get stretches from incoming Intent
        WorkoutStretches = getIntent().getStringExtra("WorkoutStretches");
        
        // Identify the textViews that will display the Workout information
        // find the title 
        TitleTextView = (TextView) findViewById(R.id.ConfrimPageTitle);
        
        // find the description 
        DescriptionTextView = (TextView) findViewById(R.id.ConfirmationWorkoutDescription);
        
        //find the Stretches 
        StretchesTextView = (TextView) findViewById(R.id.ConfirmationWorkoutStretches);
        
        // Identify the Button that will start the Workout
        StartWorkout = (Button) findViewById(R.id.ConfirmStartWorkoutButton);

        // Change the TextViews to reflect the information of the incoming Workout
        TitleTextView.setText(WorkoutTitle);
        DescriptionTextView.setText(WorkoutDescription);
        StretchesTextView.setText(WorkoutStretches);
        
        //Button Listener for starting a workout
        StartWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(WorkoutStartConfirmation.this, "Success!", Toast.LENGTH_SHORT).show();

                BeginWorkoutIntent = new Intent(view.getContext(), ActiveExercise.class);
                BeginWorkoutIntent.putExtra("WorkoutTitle", WorkoutTitle);
                // BeginWorkoutIntent.putExtra("WorkoutDescription", WorkoutDescription);
                // BeginWorkoutIntent.putExtra("WorkoutStretches", WorkoutStretches);
                startActivityForResult(BeginWorkoutIntent,0);
            }
        });
    }
}