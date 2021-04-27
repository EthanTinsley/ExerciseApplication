package com.exerciseapplication.finalexerciseapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class TricepExercises extends AppCompatActivity {

    boolean BuildingWorkout ;
    String WorkoutName ;
    String ExerciseName ;
    String ExerciseDescription ;
    int imageID ;

    protected Button DumbellTricepExtensions ;
    protected Button SkullCrushers ;
    protected Button Dips ;
    protected Button SeatedTricepPress ;
    protected Button TricepCablePushes ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tricep_exercises);


        //determine if user is currently building a workout
        BuildingWorkout = getIntent().getBooleanExtra("BuildingWorkout",false);

        // if building a workout assign workout title
        if (BuildingWorkout == true) WorkoutName = getIntent().getStringExtra("WorkoutTitle");

        DumbellTricepExtensions = (Button) findViewById(R.id.dumbelltricepextensionsButton);
        DumbellTricepExtensions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent TricepExtensions = new Intent(view.getContext() , ExerciseAddTemplate.class) ;

                if (BuildingWorkout == true) {
                    TricepExtensions.putExtra("WorkoutName", WorkoutName);
                    TricepExtensions.putExtra("BuildingWorkout", BuildingWorkout);
                }

                ExerciseName = getString(R.string.DumbbellTricepExtensions).toString();
                ExerciseDescription = getString(R.string.DumbbellTricepExtensionsDescription).toString();
                imageID = R.drawable.dumbelltricepextentions;

                TricepExtensions.putExtra("ExerciseName", ExerciseName);
                TricepExtensions.putExtra("ExerciseDescription", ExerciseDescription);
                TricepExtensions.putExtra("ExerciseImage", imageID);
                startActivityForResult(TricepExtensions,0);
            }
        });

        SkullCrushers = (Button) findViewById(R.id.skullcrusherButton);
        SkullCrushers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent SkullCrushers = new Intent(view.getContext() , ExerciseAddTemplate.class) ;

                if (BuildingWorkout == true) {
                    SkullCrushers.putExtra("WorkoutName", WorkoutName);
                    SkullCrushers.putExtra("BuildingWorkout", BuildingWorkout);
                }

                ExerciseName = getString(R.string.SkullCrushers).toString();
                ExerciseDescription = getString(R.string.SkullCrushersDescription).toString();
                imageID = R.drawable.skullcrusher;

                SkullCrushers.putExtra("ExerciseName", ExerciseName);
                SkullCrushers.putExtra("ExerciseDescription", ExerciseDescription);
                SkullCrushers.putExtra("ExerciseImage", imageID);
                startActivityForResult(SkullCrushers,0);
            }
        });

        Dips = (Button) findViewById(R.id.dipsbutton);
        Dips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Exercise = new Intent(view.getContext() , ExerciseAddTemplate.class) ;

                if (BuildingWorkout == true) {
                    Exercise.putExtra("WorkoutName", WorkoutName);
                    Exercise.putExtra("BuildingWorkout", BuildingWorkout);
                }

                ExerciseName = getString(R.string.Dips).toString();
                ExerciseDescription = getString(R.string.DipsDefinition).toString();
                imageID = R.drawable.dips;

                Exercise.putExtra("ExerciseName", ExerciseName);
                Exercise.putExtra("ExerciseDescription", ExerciseDescription);
                Exercise.putExtra("ExerciseImage", imageID);
                startActivityForResult(Exercise,0);
            }
        });

        SeatedTricepPress = (Button) findViewById(R.id.seatedtripressButton);
        SeatedTricepPress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Exercise = new Intent(view.getContext() , ExerciseAddTemplate.class) ;

                if (BuildingWorkout == true) {
                    Exercise.putExtra("WorkoutName", WorkoutName);
                    Exercise.putExtra("BuildingWorkout", BuildingWorkout);
                }

                ExerciseName = getString(R.string.SeatedTricepPress).toString();
                ExerciseDescription = getString(R.string.SeatedTricepPressDefinition).toString();
                imageID = R.drawable.seatedtriceppress;

                Exercise.putExtra("ExerciseName", ExerciseName);
                Exercise.putExtra("ExerciseDescription", ExerciseDescription);
                Exercise.putExtra("ExerciseImage", imageID);
                startActivityForResult(Exercise,0);
            }
        });

        TricepCablePushes = (Button) findViewById(R.id.tricepcablepushdownsButton);
        TricepCablePushes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Exercise = new Intent(view.getContext() , ExerciseAddTemplate.class) ;

                if (BuildingWorkout == true) {
                    Exercise.putExtra("WorkoutName", WorkoutName);
                    Exercise.putExtra("BuildingWorkout", BuildingWorkout);
                }

                ExerciseName = getString(R.string.TricepCablePushdowns).toString();
                ExerciseDescription = getString(R.string.TricepCablePushdownsDescription).toString();
                imageID = R.drawable.tricepcablepushdowns;

                Exercise.putExtra("ExerciseName", ExerciseName);
                Exercise.putExtra("ExerciseDescription", ExerciseDescription);
                Exercise.putExtra("ExerciseImage", imageID);
                startActivityForResult(Exercise,0);
            }
        });

        // Back Button and Action Listener
        Button BackButton = (Button) findViewById(R.id.TricepBackButton);
        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent GoBack = new Intent(v.getContext() , MainActivity.class);
                startActivityForResult(GoBack, 0);
            }
        });
    }



}

