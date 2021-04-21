package com.exerciseapplication.finalexerciseapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MuscleGroupSelection extends AppCompatActivity {

    boolean buildingWorkout ;
    String WorkoutTitle ;
    Intent NewIntent ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muscle_group_selection);

        // boolean determines if user is currently building a workout or not
        buildingWorkout  = getIntent().getBooleanExtra("BuildingWorkout", false) ;

        //if user is building a workout then get the title of the workout
        if (buildingWorkout == true) WorkoutTitle = getIntent().getStringExtra("WorkoutTitle") ;


        Button ShoulderExercises = (Button) findViewById(R.id.ShouldersButton) ;
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





       
    }
}