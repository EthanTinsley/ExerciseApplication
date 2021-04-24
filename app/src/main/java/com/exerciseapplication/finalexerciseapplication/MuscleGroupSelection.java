package com.exerciseapplication.finalexerciseapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MuscleGroupSelection extends AppCompatActivity {

    boolean buildingWorkout ;
    String WorkoutTitle ;

    protected Button ShoulderExercises ;
    protected Button BicepExercises ;
    protected Button TricepExercises ;
    protected Button ForearmExercises ;
    protected Button ChestExercises ;
    protected Button BackExercises ;
    protected Button AbdominalExercises ;
    protected Button GlutesExercises ;
    protected Button HamstringsExercises ;
    protected Button CalvesExercises ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muscle_group_selection);

        // boolean determines if user is currently building a workout or not
        buildingWorkout  = getIntent().getBooleanExtra("BuildingWorkout", false) ;

        //if user is building a workout then get the title of the workout
        if (buildingWorkout == true) WorkoutTitle = getIntent().getStringExtra("WorkoutTitle") ;


        ShoulderExercises = (Button) findViewById(R.id.ShouldersButton) ;
        ShoulderExercises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shoulders = new Intent(view.getContext() , ShoulderExercises.class) ;

                if (buildingWorkout == true) {
                    shoulders.putExtra("BuildingWorkout", buildingWorkout);
                    shoulders.putExtra("WorkoutTitle", WorkoutTitle);
                }
                startActivityForResult(shoulders,0);
            }
        });

        BicepExercises = (Button) findViewById(R.id.BicepButton);
        BicepExercises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Biceps = new Intent(view.getContext() , BicepExercises.class) ;

                if (buildingWorkout == true) {
                    Biceps.putExtra("BuildingWorkout", buildingWorkout);
                    Biceps.putExtra("WorkoutTitle", WorkoutTitle);
                }
                startActivityForResult(Biceps,0);

            }
        });

        TricepExercises = (Button) findViewById(R.id.TricepButton);
        TricepExercises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Triceps = new Intent(view.getContext() , TricepExercises.class) ;

                if (buildingWorkout == true) {
                    Triceps.putExtra("BuildingWorkout", buildingWorkout);
                    Triceps.putExtra("WorkoutTitle", WorkoutTitle);
                }
                startActivityForResult(Triceps,0);

            }
        });







       
    }
}