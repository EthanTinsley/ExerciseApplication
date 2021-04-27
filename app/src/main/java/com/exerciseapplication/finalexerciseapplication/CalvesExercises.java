package com.exerciseapplication.finalexerciseapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class CalvesExercises extends AppCompatActivity {

    boolean BuildingWorkout ;
    String WorkoutName ;
    String ExerciseName ;
    String ExerciseDescription ;
    int imageID ;

    protected Button LegPressCalfRaises ;
    protected Button DonkeyCalfRasies ;
    protected Button SeatedCalfRaises ;
    protected Button SmithMachineCalfRaises ;
    protected Button StandingBarbellCalfRaise ;
    protected Button StandingDumbellCalfRaises ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calves_exercises);

        //determine if user is currently building a workout
        BuildingWorkout = getIntent().getBooleanExtra("BuildingWorkout",false);

        // if building a workout assign workout title
        if (BuildingWorkout == true) WorkoutName = getIntent().getStringExtra("WorkoutTitle");

        LegPressCalfRaises = (Button) findViewById(R.id.LegPressCalfRaiseButton);
        LegPressCalfRaises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Exercise = new Intent(view.getContext() , ExerciseAddTemplate.class) ;

                if (BuildingWorkout == true) {
                    Exercise.putExtra("WorkoutName", WorkoutName);
                    Exercise.putExtra("BuildingWorkout", BuildingWorkout);
                }

                ExerciseName = getString(R.string.LegPressCalfRaise).toString();
                ExerciseDescription = getString(R.string.LegPressCalfRaiseDescription).toString();
                imageID = R.drawable.legpresscalfraise;

                Exercise.putExtra("ExerciseName", ExerciseName);
                Exercise.putExtra("ExerciseDescription", ExerciseDescription);
                Exercise.putExtra("ExerciseImage", imageID);
                startActivityForResult(Exercise,0);
            }
        });

        DonkeyCalfRasies = (Button) findViewById(R.id.DonkeyCalfRaiseButton);
        DonkeyCalfRasies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Exercise = new Intent(view.getContext() , ExerciseAddTemplate.class) ;

                if (BuildingWorkout == true) {
                    Exercise.putExtra("WorkoutName", WorkoutName);
                    Exercise.putExtra("BuildingWorkout", BuildingWorkout);
                }

                ExerciseName = getString(R.string.DonkeyCalfRaise).toString();
                ExerciseDescription = getString(R.string.DonkeyCalfRaiseDescription).toString();
                imageID = R.drawable.donkeycalfraise;

                Exercise.putExtra("ExerciseName", ExerciseName);
                Exercise.putExtra("ExerciseDescription", ExerciseDescription);
                Exercise.putExtra("ExerciseImage", imageID);
                startActivityForResult(Exercise,0);
            }
        });

        SeatedCalfRaises = (Button) findViewById(R.id.SeatedCalfRaiseButton);
        SeatedCalfRaises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Exercise = new Intent(view.getContext() , ExerciseAddTemplate.class) ;

                if (BuildingWorkout == true) {
                    Exercise.putExtra("WorkoutName", WorkoutName);
                    Exercise.putExtra("BuildingWorkout", BuildingWorkout);
                }

                ExerciseName = getString(R.string.SeatedCalfRaise).toString();
                ExerciseDescription = getString(R.string.SeatedCalfRaiseDescription).toString();
                imageID = R.drawable.seatedcalfraise;

                Exercise.putExtra("ExerciseName", ExerciseName);
                Exercise.putExtra("ExerciseDescription", ExerciseDescription);
                Exercise.putExtra("ExerciseImage", imageID);
                startActivityForResult(Exercise,0);
            }
        });

        SmithMachineCalfRaises = (Button) findViewById(R.id.SmithMachineCalfRaiseButton);
        SmithMachineCalfRaises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Exercise = new Intent(view.getContext() , ExerciseAddTemplate.class) ;

                if (BuildingWorkout == true) {
                    Exercise.putExtra("WorkoutName", WorkoutName);
                    Exercise.putExtra("BuildingWorkout", BuildingWorkout);
                }

                ExerciseName = getString(R.string.SmithMachineCalfRaise).toString();
                ExerciseDescription = getString(R.string.SmithMachineCalfRaiseDescription).toString();
                imageID = R.drawable.smithmachinecalfraise;

                Exercise.putExtra("ExerciseName", ExerciseName);
                Exercise.putExtra("ExerciseDescription", ExerciseDescription);
                Exercise.putExtra("ExerciseImage", imageID);
                startActivityForResult(Exercise,0);
            }
        });

        StandingBarbellCalfRaise = (Button) findViewById(R.id.StandingBarbellCalfRaiseButton);
        StandingBarbellCalfRaise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Exercise = new Intent(view.getContext() , ExerciseAddTemplate.class) ;

                if (BuildingWorkout == true) {
                    Exercise.putExtra("WorkoutName", WorkoutName);
                    Exercise.putExtra("BuildingWorkout", BuildingWorkout);
                }

                ExerciseName = getString(R.string.StandingBarbellCalfRaise).toString();
                ExerciseDescription = getString(R.string.StandingBarbellCalfRaiseDescription).toString();
                imageID = R.drawable.standingbarbellcalfraise;

                Exercise.putExtra("ExerciseName", ExerciseName);
                Exercise.putExtra("ExerciseDescription", ExerciseDescription);
                Exercise.putExtra("ExerciseImage", imageID);
                startActivityForResult(Exercise,0);
            }
        });

        StandingDumbellCalfRaises = (Button) findViewById(R.id.StandingDumbbellCalfRaiseButton);
        StandingDumbellCalfRaises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Exercise = new Intent(view.getContext() , ExerciseAddTemplate.class) ;

                if (BuildingWorkout == true) {
                    Exercise.putExtra("WorkoutName", WorkoutName);
                    Exercise.putExtra("BuildingWorkout", BuildingWorkout);
                }

                ExerciseName = getString(R.string.StandingDumbbellCalfRaise).toString();
                ExerciseDescription = getString(R.string.StandingDumbbellCalfRaiseDescription).toString();
                imageID = R.drawable.standingdumbellcalfraise;

                Exercise.putExtra("ExerciseName", ExerciseName);
                Exercise.putExtra("ExerciseDescription", ExerciseDescription);
                Exercise.putExtra("ExerciseImage", imageID);
                startActivityForResult(Exercise,0);
            }
        });

        // Back Button and Action Listener
        Button BackButton = (Button) findViewById(R.id.CalvesBackButton);
        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent GoBack = new Intent(v.getContext() , MainActivity.class);
                startActivityForResult(GoBack, 0);
            }
        });

    }



}
