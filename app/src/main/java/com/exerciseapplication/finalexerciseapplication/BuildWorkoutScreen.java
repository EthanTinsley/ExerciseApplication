package com.exerciseapplication.finalexerciseapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BuildWorkoutScreen extends AppCompatActivity {

    Button AddExerciseButton ;
    TextView Title ;
    String WorkoutTitle ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build_workout_screen);

        WorkoutTitle = getIntent().getStringExtra("WorkoutTitle");

        AddExerciseButton = (Button) findViewById(R.id.AddExerciseButton);
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