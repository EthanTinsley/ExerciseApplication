package com.exerciseapplication.finalexerciseapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class BackExercises extends AppCompatActivity {

    boolean BuildingWorkout ;
    String WorkoutName ;
    String ExerciseName ;
    String ExerciseDescription ;
    int imageID ;

    protected Button BarbellDeadlift ;
    protected Button BarbellBentOverRow;
    protected Button HexBarDeadlift ;
    protected Button OneArmDumbellRow ;
    protected Button PendlayRow ;
    protected Button PullUps ;
    protected Button SeatedCableRows ;
    protected Button tBarRows ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_exercises);


        //determine if user is currently building a workout
        BuildingWorkout = getIntent().getBooleanExtra("BuildingWorkout",false);

        // if building a workout assign workout title
        if (BuildingWorkout == true) WorkoutName = getIntent().getStringExtra("WorkoutTitle");


        BarbellDeadlift = (Button) findViewById(R.id.BarbellDeadliftButton);
        BarbellDeadlift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Exercise = new Intent(view.getContext() , ExerciseAddTemplate.class) ;

                if (BuildingWorkout == true) {
                    Exercise.putExtra("WorkoutName", WorkoutName);
                    Exercise.putExtra("BuildingWorkout", BuildingWorkout);
                }

                ExerciseName = getString(R.string.BarbellDeadlift).toString();
                ExerciseDescription = getString(R.string.BarbellDeadliftDescription).toString();
                imageID = R.drawable.barbelldeadlift;

                Exercise.putExtra("ExerciseName", ExerciseName);
                Exercise.putExtra("ExerciseDescription", ExerciseDescription);
                Exercise.putExtra("ExerciseImage", imageID);
                startActivityForResult(Exercise,0);
            }
        });

        BarbellBentOverRow = (Button) findViewById(R.id.BarbellBentOverRowButton);
        BarbellBentOverRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Exercise = new Intent(view.getContext() , ExerciseAddTemplate.class) ;

                if (BuildingWorkout == true) {
                    Exercise.putExtra("WorkoutName", WorkoutName);
                    Exercise.putExtra("BuildingWorkout", BuildingWorkout);
                }

                ExerciseName = getString(R.string.BarbellBentOverRow).toString();
                ExerciseDescription = getString(R.string.BarbellBentOverRowDescription).toString();
                imageID = R.drawable.barbellbentoverrow;

                Exercise.putExtra("ExerciseName", ExerciseName);
                Exercise.putExtra("ExerciseDescription", ExerciseDescription);
                Exercise.putExtra("ExerciseImage", imageID);
                startActivityForResult(Exercise,0);
            }
        });

        HexBarDeadlift = (Button) findViewById(R.id.HexBarDeadliftButton);
        HexBarDeadlift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Exercise = new Intent(view.getContext() , ExerciseAddTemplate.class) ;

                if (BuildingWorkout == true) {
                    Exercise.putExtra("WorkoutName", WorkoutName);
                    Exercise.putExtra("BuildingWorkout", BuildingWorkout);
                }

                ExerciseName = getString(R.string.HexBarDeadlift).toString();
                ExerciseDescription = getString(R.string.HexBarDeadliftDescription).toString();
                imageID = R.drawable.hexbardeadlift;

                Exercise.putExtra("ExerciseName", ExerciseName);
                Exercise.putExtra("ExerciseDescription", ExerciseDescription);
                Exercise.putExtra("ExerciseImage", imageID);
                startActivityForResult(Exercise,0);
            }
        });

        OneArmDumbellRow = (Button) findViewById(R.id.OneArmDumbbellRowButton);
        OneArmDumbellRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Exercise = new Intent(view.getContext() , ExerciseAddTemplate.class) ;

                if (BuildingWorkout == true) {
                    Exercise.putExtra("WorkoutName", WorkoutName);
                    Exercise.putExtra("BuildingWorkout", BuildingWorkout);
                }

                ExerciseName = getString(R.string.OneArmDumbbellRow).toString();
                ExerciseDescription = getString(R.string.OneArmDumbbellRowDescription).toString();
                imageID = R.drawable.onearmdumbellrow;

                Exercise.putExtra("ExerciseName", ExerciseName);
                Exercise.putExtra("ExerciseDescription", ExerciseDescription);
                Exercise.putExtra("ExerciseImage", imageID);
                startActivityForResult(Exercise,0);
            }
        });

        PendlayRow = (Button) findViewById(R.id.PendlayRowButton);
        PendlayRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Exercise = new Intent(view.getContext() , ExerciseAddTemplate.class) ;

                if (BuildingWorkout == true) {
                    Exercise.putExtra("WorkoutName", WorkoutName);
                    Exercise.putExtra("BuildingWorkout", BuildingWorkout);
                }

                ExerciseName = getString(R.string.PendlayRow).toString();
                ExerciseDescription = getString(R.string.PendlayRowDescription).toString();
                imageID = R.drawable.pendlayrow;

                Exercise.putExtra("ExerciseName", ExerciseName);
                Exercise.putExtra("ExerciseDescription", ExerciseDescription);
                Exercise.putExtra("ExerciseImage", imageID);
                startActivityForResult(Exercise,0);
            }
        });

        PullUps = (Button) findViewById(R.id.PullUpButton);
        PullUps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Exercise = new Intent(view.getContext() , ExerciseAddTemplate.class) ;

                if (BuildingWorkout == true) {
                    Exercise.putExtra("WorkoutName", WorkoutName);
                    Exercise.putExtra("BuildingWorkout", BuildingWorkout);
                }

                ExerciseName = getString(R.string.PullUps).toString();
                ExerciseDescription = getString(R.string.PullupsDescription).toString();
                imageID = R.drawable.pullups;

                Exercise.putExtra("ExerciseName", ExerciseName);
                Exercise.putExtra("ExerciseDescription", ExerciseDescription);
                Exercise.putExtra("ExerciseImage", imageID);
                startActivityForResult(Exercise,0);
            }
        });

        SeatedCableRows = (Button) findViewById(R.id.SeatedCableRowButton);
        SeatedCableRows.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Exercise = new Intent(view.getContext() , ExerciseAddTemplate.class) ;

                if (BuildingWorkout == true) {
                    Exercise.putExtra("WorkoutName", WorkoutName);
                    Exercise.putExtra("BuildingWorkout", BuildingWorkout);
                }

                ExerciseName = getString(R.string.SeatedCableRow).toString();
                ExerciseDescription = getString(R.string.SeatedCableRowDescription).toString();
                imageID = R.drawable.seatedcablerow;

                Exercise.putExtra("ExerciseName", ExerciseName);
                Exercise.putExtra("ExerciseDescription", ExerciseDescription);
                Exercise.putExtra("ExerciseImage", imageID);
                startActivityForResult(Exercise,0);
            }
        });

        tBarRows = (Button) findViewById(R.id.TBarRowButton);
        tBarRows.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Exercise = new Intent(view.getContext() , ExerciseAddTemplate.class) ;

                if (BuildingWorkout == true) {
                    Exercise.putExtra("WorkoutName", WorkoutName);
                    Exercise.putExtra("BuildingWorkout", BuildingWorkout);
                }

                ExerciseName = getString(R.string.TBarRow).toString();
                ExerciseDescription = getString(R.string.TBarRowDescription).toString();
                imageID = R.drawable.tbarrow;

                Exercise.putExtra("ExerciseName", ExerciseName);
                Exercise.putExtra("ExerciseDescription", ExerciseDescription);
                Exercise.putExtra("ExerciseImage", imageID);
                startActivityForResult(Exercise,0);
            }
        });

        // Back Button and Action Listener
        Button BackButton = (Button) findViewById(R.id.BackBackButton);
        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent GoBack = new Intent(v.getContext() , MainActivity.class);
                startActivityForResult(GoBack, 0);
            }
        });
    }


    }




