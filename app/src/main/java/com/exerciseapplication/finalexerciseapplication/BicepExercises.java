package com.exerciseapplication.finalexerciseapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class BicepExercises extends AppCompatActivity {
    
    protected Button DumbellCurls ;
    protected Button MachineDumbellCurls;
    protected Button InclineDumbellCurls;
    protected Button SittingPreacherCurls;
    protected Button StrictPreacherCurls;

    boolean BuildingWorkout ;
    String WorkoutName ;
    String ExerciseName ;
    String ExerciseDescription ;
    int imageID ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bicep_exercises);


        //determine if user is currently building a workout
        BuildingWorkout = getIntent().getBooleanExtra("BuildingWorkout",false);

        // if building a workout assign workout title
        if (BuildingWorkout == true) WorkoutName = getIntent().getStringExtra("WorkoutTitle");

        DumbellCurls = (Button) findViewById(R.id.DumbbellBicepCurlsButton);
        DumbellCurls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent DumbellCurls = new Intent(view.getContext() , ExerciseAddTemplate.class) ;

                if (BuildingWorkout == true) {
                    DumbellCurls.putExtra("WorkoutName", WorkoutName);
                    DumbellCurls.putExtra("BuildingWorkout", BuildingWorkout);
                }

                ExerciseName = getString(R.string.DumbbellCurls).toString();
                ExerciseDescription = getString(R.string.DumbbellCurlsDescription).toString();
                imageID = R.drawable.dumbellcurls;

                DumbellCurls.putExtra("ExerciseName", ExerciseName);
                DumbellCurls.putExtra("ExerciseDescription", ExerciseDescription);
                DumbellCurls.putExtra("ExerciseImage", imageID);
                startActivityForResult(DumbellCurls,0);
            }
        });

        MachineDumbellCurls = (Button) findViewById(R.id.MachineBicepCurlsButton);
        MachineDumbellCurls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent MachineDumbellCurls = new Intent(view.getContext() , ExerciseAddTemplate.class) ;

                if (BuildingWorkout == true) {
                    MachineDumbellCurls.putExtra("WorkoutName", WorkoutName);
                    MachineDumbellCurls.putExtra("BuildingWorkout", BuildingWorkout);
                }

                ExerciseName = getString(R.string.MachineDumbbellCurls).toString();
                ExerciseDescription = getString(R.string.MachineDumbbellCurlsDescription).toString();
                imageID = R.drawable.machinedumbellcurls;

                MachineDumbellCurls.putExtra("ExerciseName", ExerciseName);
                MachineDumbellCurls.putExtra("ExerciseDescription", ExerciseDescription);
                MachineDumbellCurls.putExtra("ExerciseImage", imageID);
                startActivityForResult(MachineDumbellCurls,0);
            }
        });

        InclineDumbellCurls = (Button) findViewById(R.id.inclinedumbbellcurlsButton);
        InclineDumbellCurls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent InclineDumbellCurls = new Intent(view.getContext() , ExerciseAddTemplate.class) ;

                if (BuildingWorkout == true) {
                    InclineDumbellCurls.putExtra("WorkoutName", WorkoutName);
                    InclineDumbellCurls.putExtra("BuildingWorkout", BuildingWorkout);
                }

                ExerciseName = getString(R.string.InclineDumbbellCurls).toString();
                ExerciseDescription = getString(R.string.InclineDumbbellCurlsDescription).toString();
                imageID = R.drawable.inclinedumbellcurls;

                InclineDumbellCurls.putExtra("ExerciseName", ExerciseName);
                InclineDumbellCurls.putExtra("ExerciseDescription", ExerciseDescription);
                InclineDumbellCurls.putExtra("ExerciseImage", imageID);
                startActivityForResult(InclineDumbellCurls,0);
            }
        });

        SittingPreacherCurls = (Button) findViewById(R.id.sittingpreachercurlButton);
        SittingPreacherCurls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent PreacherCurls = new Intent(view.getContext() , ExerciseAddTemplate.class) ;

                if (BuildingWorkout == true) {
                    PreacherCurls.putExtra("WorkoutName", WorkoutName);
                    PreacherCurls.putExtra("BuildingWorkout", BuildingWorkout);
                }

                ExerciseName = getString(R.string.SittingPreacherCurls).toString();
                ExerciseDescription = getString(R.string.SittingPreacherCurlsDescription).toString();
                //imageID = R.drawable.;

                PreacherCurls.putExtra("ExerciseName", ExerciseName);
                PreacherCurls.putExtra("ExerciseDescription", ExerciseDescription);
                PreacherCurls.putExtra("ExerciseImage", imageID);
                startActivityForResult(PreacherCurls,0);
            }
        });

        StrictPreacherCurls = (Button) findViewById(R.id.strictpreachercurlButton);
        StrictPreacherCurls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent PreacherCurls = new Intent(view.getContext() , ExerciseAddTemplate.class) ;

                if (BuildingWorkout == true) {
                    PreacherCurls.putExtra("WorkoutName", WorkoutName);
                    PreacherCurls.putExtra("BuildingWorkout", BuildingWorkout);
                }

                ExerciseName = getString(R.string.StrictPreacherCurls).toString();
                ExerciseDescription = getString(R.string.StrictPreacherCurlsDescription).toString();
                //imageID = R.drawable.dumbellcurls;

                PreacherCurls.putExtra("ExerciseName", ExerciseName);
                PreacherCurls.putExtra("ExerciseDescription", ExerciseDescription);
                PreacherCurls.putExtra("ExerciseImage", imageID);
                startActivityForResult(PreacherCurls,0);
            }
        });

        // Back Button and Action Listener
        Button BackButton = (Button) findViewById(R.id.BicepBackButton);
        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent GoBack = new Intent(v.getContext() , MainActivity.class);
                startActivityForResult(GoBack, 0);
            }
        });
    }



}
