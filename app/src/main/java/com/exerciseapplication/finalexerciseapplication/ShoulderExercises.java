package com.exerciseapplication.finalexerciseapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShoulderExercises extends AppCompatActivity {

    boolean BuildingWorkout ;
    String WorkoutName ;
    String ExerciseName ;
    String ExerciseDescription ;
    int imageID ;

    protected Button SeatedOverHeadWeightedPress ;
    protected Button WeightedLateralRaises ;
    protected Button WeightedFrontRaises ;
    protected Button WeightedUprightRows ;
    protected Button ArnoldPress ;
    protected Button WeightedRearDeltRaises ;
    protected Button StandingOverheadWeightedPress ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoulder_exercises);

        //determine if user is currently building a workout
        BuildingWorkout = getIntent().getBooleanExtra("BuildingWorkout",false);

        // if building a workout assign workout title
        if (BuildingWorkout == true) WorkoutName = getIntent().getStringExtra("WorkoutTitle");



        SeatedOverHeadWeightedPress = (Button) findViewById(R.id.seatWeightedPressButton) ;
        SeatedOverHeadWeightedPress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Exercise = new Intent(view.getContext() , ExerciseAddTemplate.class) ;

                if (BuildingWorkout == true) {
                    Exercise.putExtra("WorkoutName", WorkoutName);
                    Exercise.putExtra("BuildingWorkout", BuildingWorkout);
                }

                ExerciseName = getString(R.string.SeatedOverheadWeightedPress).toString();
                ExerciseDescription = getString(R.string.SeatedOverheadWeightedPressDescription).toString();
                imageID = R.drawable.seatedoverheadweightedpress;

                Exercise.putExtra("ExerciseName", ExerciseName);
                Exercise.putExtra("ExerciseDescription", ExerciseDescription);
                Exercise.putExtra("ExerciseImage", imageID);
                startActivityForResult(Exercise,0);
            }
        });

        WeightedLateralRaises = (Button) findViewById(R.id.wtdLatRaisesButton);
        WeightedLateralRaises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Exercise = new Intent(view.getContext() , ExerciseAddTemplate.class) ;

                if (BuildingWorkout == true) {
                    Exercise.putExtra("WorkoutName", WorkoutName);
                    Exercise.putExtra("BuildingWorkout", BuildingWorkout);
                }

                ExerciseName = getString(R.string.WeightedLateralRaises).toString();
                ExerciseDescription = getString(R.string.WeightedLateralRaisesDescription).toString();
                imageID = R.drawable.weightedlateralraises;

                Exercise.putExtra("ExerciseName", ExerciseName);
                Exercise.putExtra("ExerciseDescription", ExerciseDescription);
                Exercise.putExtra("ExerciseImage", imageID);
                startActivityForResult(Exercise,0);
            }
        });

        WeightedFrontRaises = (Button) findViewById(R.id.wtdFrontRaisesButton);
        WeightedFrontRaises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Exercise = new Intent(view.getContext() , ExerciseAddTemplate.class) ;

                if (BuildingWorkout == true) {
                    Exercise.putExtra("WorkoutName", WorkoutName);
                    Exercise.putExtra("BuildingWorkout", BuildingWorkout);
                }

                ExerciseName = getString(R.string.WeightedFrontRaises).toString();
                ExerciseDescription = getString(R.string.WeightedFrontRaisesDescription).toString();
                imageID = R.drawable.weightedfrontraises;

                Exercise.putExtra("ExerciseName", ExerciseName);
                Exercise.putExtra("ExerciseDescription", ExerciseDescription);
                Exercise.putExtra("ExerciseImage", imageID);
                startActivityForResult(Exercise,0);
            }
        });

        WeightedUprightRows = (Button) findViewById(R.id.wtdUprightRowsButton);
        WeightedUprightRows.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Exercise = new Intent(view.getContext() , ExerciseAddTemplate.class) ;

                if (BuildingWorkout == true) {
                    Exercise.putExtra("WorkoutName", WorkoutName);
                    Exercise.putExtra("BuildingWorkout", BuildingWorkout);
                }

                ExerciseName = getString(R.string.WeightedUprightRows).toString();
                ExerciseDescription = getString(R.string.WeightedUprightRowsDescription).toString();
                imageID = R.drawable.weighteduprightrows;

                Exercise.putExtra("ExerciseName", ExerciseName);
                Exercise.putExtra("ExerciseDescription", ExerciseDescription);
                Exercise.putExtra("ExerciseImage", imageID);
                startActivityForResult(Exercise,0);
            }
        });

        ArnoldPress = (Button) findViewById(R.id.arnldPressButton);
        ArnoldPress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Exercise = new Intent(view.getContext() , ExerciseAddTemplate.class) ;

                if (BuildingWorkout == true) {
                    Exercise.putExtra("WorkoutName", WorkoutName);
                    Exercise.putExtra("BuildingWorkout", BuildingWorkout);
                }

                ExerciseName = getString(R.string.AronoldPress).toString();
                ExerciseDescription = getString(R.string.AronoldPressDescription).toString();
                imageID = R.drawable.arnoldpress;

                Exercise.putExtra("ExerciseName", ExerciseName);
                Exercise.putExtra("ExerciseDescription", ExerciseDescription);
                Exercise.putExtra("ExerciseImage", imageID);
                startActivityForResult(Exercise,0);
            }
        });

        WeightedRearDeltRaises = (Button) findViewById(R.id.wtdRearDeltRaisesButton);
        WeightedRearDeltRaises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Exercise = new Intent(view.getContext() , ExerciseAddTemplate.class) ;

                if (BuildingWorkout == true) {
                    Exercise.putExtra("WorkoutName", WorkoutName);
                    Exercise.putExtra("BuildingWorkout", BuildingWorkout);
                }

                ExerciseName = getString(R.string.WeightedRearDeltRaises).toString();
                ExerciseDescription = getString(R.string.WeightedRearDeltRaisesDescription).toString();
                imageID = R.drawable.weightedreardektraises;

                Exercise.putExtra("ExerciseName", ExerciseName);
                Exercise.putExtra("ExerciseDescription", ExerciseDescription);
                Exercise.putExtra("ExerciseImage", imageID);
                startActivityForResult(Exercise,0);
            }
        });

        StandingOverheadWeightedPress = (Button) findViewById(R.id.stndWtdPressButton);
        StandingOverheadWeightedPress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Exercise = new Intent(view.getContext() , ExerciseAddTemplate.class) ;

                if (BuildingWorkout == true) {
                    Exercise.putExtra("WorkoutName", WorkoutName);
                    Exercise.putExtra("BuildingWorkout", BuildingWorkout);
                }

                ExerciseName = getString(R.string.StandingOverheadWeightedPress).toString();
                ExerciseDescription = getString(R.string.StandingOverheadWeightedPressDescription).toString();
                imageID = R.drawable.standingoverheadweightedpress;

                Exercise.putExtra("ExerciseName", ExerciseName);
                Exercise.putExtra("ExerciseDescription", ExerciseDescription);
                Exercise.putExtra("ExerciseImage", imageID);
                startActivityForResult(Exercise,0);
            }
        });
    }
}