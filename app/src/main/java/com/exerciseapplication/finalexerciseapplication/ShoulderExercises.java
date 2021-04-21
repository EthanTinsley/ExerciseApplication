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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoulder_exercises);

        //determine if user is currently building a workout
        BuildingWorkout = getIntent().getBooleanExtra("BuildingWorkout",false);

        // if building a workout assign workout title
        if (BuildingWorkout == true) WorkoutName = getIntent().getStringExtra("WorkoutTitle");



        Button SeatedOverHeadWeightedPress = (Button) findViewById(R.id.seatWeightedPressButton) ;
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
    }
}