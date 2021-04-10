package com.exerciseapplication.finalexerciseapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BuildWorkoutScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build_workout_screen);


        Button AddExerciseButton = (Button) findViewById(R.id.AddExerciseButton);
        AddExerciseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent BuildWorkoutIntent = new Intent(view.getContext(), MuscleGroupSelection.class) ;
                BuildWorkoutIntent.putExtra("BuildingWorkout", true) ;
                startActivityForResult(BuildWorkoutIntent, 0);
            }
        });

    }
}