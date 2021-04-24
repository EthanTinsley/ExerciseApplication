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

        ForearmExercises = (Button) findViewById(R.id.ForearmButton);
        ForearmExercises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Forearm = new Intent(view.getContext() , ForearmExercises.class) ;

                if (buildingWorkout == true) {
                    Forearm.putExtra("BuildingWorkout", buildingWorkout);
                    Forearm.putExtra("WorkoutTitle", WorkoutTitle);
                }
                startActivityForResult(Forearm,0);

            }
        });

        ChestExercises = (Button) findViewById(R.id.ChestButton);
        ChestExercises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Chest = new Intent(view.getContext() , ChestExercises.class) ;

                if (buildingWorkout == true) {
                    Chest.putExtra("BuildingWorkout", buildingWorkout);
                    Chest.putExtra("WorkoutTitle", WorkoutTitle);
                }
                startActivityForResult(Chest,0);

            }
        });

        BackExercises = (Button) findViewById(R.id.BackButton);
        BackExercises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Back = new Intent(view.getContext() , BackExercises.class) ;

                if (buildingWorkout == true) {
                    Back.putExtra("BuildingWorkout", buildingWorkout);
                    Back.putExtra("WorkoutTitle", WorkoutTitle);
                }
                startActivityForResult(Back,0);

            }
        });

        AbdominalExercises = (Button) findViewById(R.id.AbdominalsButton);
        AbdominalExercises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Abdominal = new Intent(view.getContext() , AbdominalExercises.class) ;

                if (buildingWorkout == true) {
                    Abdominal.putExtra("BuildingWorkout", buildingWorkout);
                    Abdominal.putExtra("WorkoutTitle", WorkoutTitle);
                }
                startActivityForResult(Abdominal,0);

            }
        });

        GlutesExercises = (Button) findViewById(R.id.GlutesButton);
        GlutesExercises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Glutes = new Intent(view.getContext() , GluteExercises.class) ;

                if (buildingWorkout == true) {
                    Glutes.putExtra("BuildingWorkout", buildingWorkout);
                    Glutes.putExtra("WorkoutTitle", WorkoutTitle);
                }
                startActivityForResult(Glutes,0);

            }
        });

        HamstringsExercises = (Button) findViewById(R.id.HamstringsButton);
        HamstringsExercises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Hamstrings = new Intent(view.getContext() , HamstringExercises.class) ;

                if (buildingWorkout == true) {
                    Hamstrings.putExtra("BuildingWorkout", buildingWorkout);
                    Hamstrings.putExtra("WorkoutTitle", WorkoutTitle);
                }
                startActivityForResult(Hamstrings,0);

            }
        });

        CalvesExercises = (Button) findViewById(R.id.CalvesButton);
        CalvesExercises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Calves = new Intent(view.getContext() , CalvesExercises.class) ;

                if (buildingWorkout == true) {
                    Calves.putExtra("BuildingWorkout", buildingWorkout);
                    Calves.putExtra("WorkoutTitle", WorkoutTitle);
                }
                startActivityForResult(Calves,0);

            }
        });

    }
}