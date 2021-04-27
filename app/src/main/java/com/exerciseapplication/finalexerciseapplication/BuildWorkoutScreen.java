package com.exerciseapplication.finalexerciseapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class BuildWorkoutScreen extends AppCompatActivity {

    Button AddExerciseButton ;
    TextView Title ;
    String WorkoutTitle ;
    ArrayAdapter ExerciseAdapter;
    List<Exercise> addedExercises ;
    ListView ExerciseHolder ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build_workout_screen);

        //gets name of the workout from database
        WorkoutTitle = getIntent().getStringExtra("WorkoutTitle");

        //sets the title of the workout based off of user selection
        Title = (TextView) findViewById(R.id.BuildWorkoutTitle);
        Title.setText(WorkoutTitle);

        ExerciseHolder = findViewById(R.id.AddedExercises);

        DataBaseHelper DataBaseHelper = new DataBaseHelper(BuildWorkoutScreen.this);
        addedExercises = DataBaseHelper.getAddedExercises(WorkoutTitle);

        ExerciseAdapter = new ArrayAdapter<Exercise>(BuildWorkoutScreen.this, android.R.layout.simple_list_item_1, addedExercises);
        ExerciseHolder.setAdapter(ExerciseAdapter);

        AddExerciseButton = (Button) findViewById(R.id.MainStartWorkout);
        AddExerciseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent BuildWorkoutIntent = new Intent(view.getContext(), MuscleGroupSelection.class) ;
                BuildWorkoutIntent.putExtra("WorkoutTitle", WorkoutTitle);
                BuildWorkoutIntent.putExtra("BuildingWorkout", true) ;
                startActivityForResult(BuildWorkoutIntent, 0);
            }
        });
        
        Button SaveWorkout = (Button) findViewById(R.id.BuildWorkoutButton);
        SaveWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BuildWorkoutScreen.this, "Workout Saved!", Toast.LENGTH_SHORT).show();
                
                Intent GoBack = new Intent(v.getContext() , MainActivity.class);
                startActivityForResult(GoBack, 0);
            }
        });

        // Back Button and Action Listener
        Button BackButton = (Button) findViewById(R.id.BuildWorkoutBackButton);
        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent GoBack = new Intent(v.getContext() , MainActivity.class);
                startActivityForResult(GoBack, 0);
            }
        });

    }
}