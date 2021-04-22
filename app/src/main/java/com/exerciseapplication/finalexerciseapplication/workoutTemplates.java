package com.exerciseapplication.finalexerciseapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class workoutTemplates extends AppCompatActivity {

    ArrayAdapter workoutArrayAdapter ;
    List<Workout> Workouts ;
    ListView WorkoutListView ;
    Intent WorkoutSelected ;
    boolean startingWorkout ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_templates);

        // test to see if user is starting a workout
        startingWorkout = getIntent().getBooleanExtra("StartingWorkout",false);

        // Get access to the database
        DataBaseHelper DataBaseHelper = new DataBaseHelper(workoutTemplates.this);

        // Return all available workouts
        Workouts = DataBaseHelper.getWorkouts();

        // find the ListView in resources
        WorkoutListView = findViewById(R.id.workoutTemplatesListView);

        // create the object to hold the workouts
        workoutArrayAdapter = new ArrayAdapter<Workout>(workoutTemplates.this, android.R.layout.simple_list_item_1, Workouts);

        // fill the list view with the array adapter
        WorkoutListView.setAdapter(workoutArrayAdapter);

        WorkoutListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Workout SelectedWorkout = (Workout) WorkoutListView.getItemAtPosition(position);

                if (startingWorkout != true) WorkoutSelected = new Intent(workoutTemplates.this,BuildWorkoutScreen.class);


                WorkoutSelected.putExtra("WorkoutTitle",SelectedWorkout.getTitle());
                startActivityForResult(WorkoutSelected,0);
            }
        });



    }
}