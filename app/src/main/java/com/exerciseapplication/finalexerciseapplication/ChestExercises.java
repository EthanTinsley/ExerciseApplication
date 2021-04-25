package com.exerciseapplication.finalexerciseapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ChestExercises extends AppCompatActivity {


    boolean BuildingWorkout ;
    String WorkoutName ;
    String ExerciseName ;
    String ExerciseDescription ;
    int imageID ;

    protected Button BarbellBenchPress;
    protected Button DeclineBenchPress ;
    protected Button InclineBenchPress ;
    protected Button CableFly ;
    protected Button DumbellBenchPress ;
    protected Button DeclineDumbellBenchPress;
    protected Button InclineDumbellBenchPress ;
    protected Button DumbellFly ;
    protected Button Pushups ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest_exercises);


        //determine if user is currently building a workout
        BuildingWorkout = getIntent().getBooleanExtra("BuildingWorkout",false);

        // if building a workout assign workout title
        if (BuildingWorkout == true) WorkoutName = getIntent().getStringExtra("WorkoutTitle");

        BarbellBenchPress = (Button) findViewById(R.id.BenchButton);
        BarbellBenchPress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Exercise = new Intent(view.getContext() , ExerciseAddTemplate.class) ;

                if (BuildingWorkout == true) {
                    Exercise.putExtra("WorkoutName", WorkoutName);
                    Exercise.putExtra("BuildingWorkout", BuildingWorkout);
                }

                ExerciseName = getString(R.string.BenchPress).toString();
                ExerciseDescription = getString(R.string.BenchPressDescription).toString();
                imageID = R.drawable.barbellbenchpress;

                Exercise.putExtra("ExerciseName", ExerciseName);
                Exercise.putExtra("ExerciseDescription", ExerciseDescription);
                Exercise.putExtra("ExerciseImage", imageID);
                startActivityForResult(Exercise,0);
            }
        });

        DeclineBenchPress  = (Button) findViewById(R.id.DeclineBenchButton);
        DeclineBenchPress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Exercise = new Intent(view.getContext() , ExerciseAddTemplate.class) ;

                if (BuildingWorkout == true) {
                    Exercise.putExtra("WorkoutName", WorkoutName);
                    Exercise.putExtra("BuildingWorkout", BuildingWorkout);
                }

                ExerciseName = getString(R.string.DeclineBenchPress).toString();
                ExerciseDescription = getString(R.string.DeclineBenchPressDescription).toString();
                imageID = R.drawable.declinebenchpress;

                Exercise.putExtra("ExerciseName", ExerciseName);
                Exercise.putExtra("ExerciseDescription", ExerciseDescription);
                Exercise.putExtra("ExerciseImage", imageID);
                startActivityForResult(Exercise,0);
            }
        });

        InclineBenchPress = (Button) findViewById(R.id.InclineBenchButton);
        InclineBenchPress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Exercise = new Intent(view.getContext() , ExerciseAddTemplate.class) ;

                if (BuildingWorkout == true) {
                    Exercise.putExtra("WorkoutName", WorkoutName);
                    Exercise.putExtra("BuildingWorkout", BuildingWorkout);
                }

                ExerciseName = getString(R.string.InclineBenchPress).toString();
                ExerciseDescription = getString(R.string.InclineBenchPressDescription).toString();
                imageID = R.drawable.inclinebenchpress;

                Exercise.putExtra("ExerciseName", ExerciseName);
                Exercise.putExtra("ExerciseDescription", ExerciseDescription);
                Exercise.putExtra("ExerciseImage", imageID);
                startActivityForResult(Exercise,0);
            }
        });

        CableFly = (Button) findViewById(R.id.CableFlyButton);
        CableFly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Exercise = new Intent(view.getContext() , ExerciseAddTemplate.class) ;

                if (BuildingWorkout == true) {
                    Exercise.putExtra("WorkoutName", WorkoutName);
                    Exercise.putExtra("BuildingWorkout", BuildingWorkout);
                }

                ExerciseName = getString(R.string.CableFly).toString();
                ExerciseDescription = getString(R.string.CableFlyDescription).toString();
                imageID = R.drawable.cableflys;

                Exercise.putExtra("ExerciseName", ExerciseName);
                Exercise.putExtra("ExerciseDescription", ExerciseDescription);
                Exercise.putExtra("ExerciseImage", imageID);
                startActivityForResult(Exercise,0);
            }
        });

        DumbellBenchPress = (Button) findViewById(R.id.DumbellBenchButton);
        DumbellBenchPress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Exercise = new Intent(view.getContext() , ExerciseAddTemplate.class) ;

                if (BuildingWorkout == true) {
                    Exercise.putExtra("WorkoutName", WorkoutName);
                    Exercise.putExtra("BuildingWorkout", BuildingWorkout);
                }

                ExerciseName = getString(R.string.DumbbellBenchPress).toString();
                ExerciseDescription = getString(R.string.DumbbellBenchPressDescription).toString();
                imageID = R.drawable.dumbellbenchpress;

                Exercise.putExtra("ExerciseName", ExerciseName);
                Exercise.putExtra("ExerciseDescription", ExerciseDescription);
                Exercise.putExtra("ExerciseImage", imageID);
                startActivityForResult(Exercise,0);
            }
        });

        InclineDumbellBenchPress = (Button) findViewById(R.id.InclineDumbellButton);
        InclineDumbellBenchPress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Exercise = new Intent(view.getContext() , ExerciseAddTemplate.class) ;

                if (BuildingWorkout == true) {
                    Exercise.putExtra("WorkoutName", WorkoutName);
                    Exercise.putExtra("BuildingWorkout", BuildingWorkout);
                }

                ExerciseName = getString(R.string.InclineDumbbellBenchPress).toString();
                ExerciseDescription = getString(R.string.InclineDumbbellBenchPressDescription).toString();
                imageID = R.drawable.inclinedumbellbenchpress;

                Exercise.putExtra("ExerciseName", ExerciseName);
                Exercise.putExtra("ExerciseDescription", ExerciseDescription);
                Exercise.putExtra("ExerciseImage", imageID);
                startActivityForResult(Exercise,0);
            }
        });

        DeclineDumbellBenchPress = (Button) findViewById(R.id.DeclineDumbellButton);
        DeclineDumbellBenchPress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Exercise = new Intent(view.getContext() , ExerciseAddTemplate.class) ;

                if (BuildingWorkout == true) {
                    Exercise.putExtra("WorkoutName", WorkoutName);
                    Exercise.putExtra("BuildingWorkout", BuildingWorkout);
                }

                ExerciseName = getString(R.string.DeclineDumbbellBenchPress).toString();
                ExerciseDescription = getString(R.string.DeclineDumbbellBenchPressDescription).toString();
                imageID = R.drawable.declinedumbellbenchpress;

                Exercise.putExtra("ExerciseName", ExerciseName);
                Exercise.putExtra("ExerciseDescription", ExerciseDescription);
                Exercise.putExtra("ExerciseImage", imageID);
                startActivityForResult(Exercise,0);
            }
        });

        DumbellFly = (Button) findViewById(R.id.DumbellFlyButton);
        DumbellFly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Exercise = new Intent(view.getContext() , ExerciseAddTemplate.class) ;

                if (BuildingWorkout == true) {
                    Exercise.putExtra("WorkoutName", WorkoutName);
                    Exercise.putExtra("BuildingWorkout", BuildingWorkout);
                }

                ExerciseName = getString(R.string.DumbbellFly).toString();
                ExerciseDescription = getString(R.string.DumbbellFlyDescription).toString();
                imageID = R.drawable.dumbellfly;

                Exercise.putExtra("ExerciseName", ExerciseName);
                Exercise.putExtra("ExerciseDescription", ExerciseDescription);
                Exercise.putExtra("ExerciseImage", imageID);
                startActivityForResult(Exercise,0);
            }
        });

        Pushups = (Button) findViewById(R.id.PushupsButton);
        Pushups.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Exercise = new Intent(view.getContext() , ExerciseAddTemplate.class) ;

                if (BuildingWorkout == true) {
                    Exercise.putExtra("WorkoutName", WorkoutName);
                    Exercise.putExtra("BuildingWorkout", BuildingWorkout);
                }

                ExerciseName = getString(R.string.Pushups).toString();
                ExerciseDescription = getString(R.string.PushupsDescription).toString();
                //imageID = R.drawable.;

                Exercise.putExtra("ExerciseName", ExerciseName);
                Exercise.putExtra("ExerciseDescription", ExerciseDescription);
                Exercise.putExtra("ExerciseImage", imageID);
                startActivityForResult(Exercise,0);
            }
        });
    }



}