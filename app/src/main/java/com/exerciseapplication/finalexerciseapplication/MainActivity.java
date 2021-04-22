package com.exerciseapplication.finalexerciseapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button CompletedWorkouts = (Button) findViewById(R.id.PreviousWorkoutsButton);
        CompletedWorkouts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent CompletedWorkoutsIntent = new Intent(view.getContext() , CompletedWorkouts.class) ;
                startActivityForResult(CompletedWorkoutsIntent, 0);
            }
        });

        Button BrowseExercise = (Button) findViewById(R.id.BrowseExercisesButton);
        BrowseExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent BrowseExerciseIntent = new Intent(view.getContext(), MuscleGroupSelection.class) ;
                BrowseExerciseIntent.putExtra("BuildingWorkout" , false ) ;
                startActivityForResult(BrowseExerciseIntent, 0);
            }
        });

        Button BuildWorkoutButton = (Button) findViewById(R.id.BuildWorkoutButton);
        BuildWorkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent BuildWorkoutIntent = new Intent(view.getContext(), NewWorkout.class) ;
                startActivityForResult(BuildWorkoutIntent, 0);
            }
        });

        Button SavedWorkoutButton = (Button) findViewById(R.id.ViewWorkoutsButton);
        SavedWorkoutButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent SavedWorkouts = new Intent(view.getContext(), WorkoutTemplates.class);
                startActivityForResult(SavedWorkouts,0);
            }
        });

        Button StartWorkoutButton = (Button) findViewById(R.id.MainStartWorkout);
        StartWorkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent StartWorkout = new Intent(view.getContext(), WorkoutTemplates.class);
                StartWorkout.putExtra("StartingWorkout", true);
                startActivityForResult(StartWorkout,0);
            }
        });


    }
}