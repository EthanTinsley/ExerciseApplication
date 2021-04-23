package com.exerciseapplication.finalexerciseapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class CompletedWorkouts extends AppCompatActivity {

    ArrayAdapter workoutArrayAdapter ;
    List<Workout> Workouts ;
    ListView WorkoutListView ;
    Intent WorkoutSelected ;
    boolean startingWorkout ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completed_workouts);


        // Get access to the database
        DataBaseHelper DataBaseHelper = new DataBaseHelper(CompletedWorkouts.this);

        // Return all available workouts
        Workouts = DataBaseHelper.getCompletedWorkouts();

        // find the ListView in resources
        WorkoutListView = findViewById(R.id.workoutTemplatesListView);

        // create the object to hold the workouts
        workoutArrayAdapter = new ArrayAdapter<Workout>(CompletedWorkouts.this, android.R.layout.simple_list_item_1, Workouts);

        // fill the list view with the array adapter
        WorkoutListView.setAdapter(workoutArrayAdapter);

        // Method for selecting an element from the ListView
        WorkoutListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // get the object stored in the listview that the user selected
                Workout ListViewSelectedWorkout = (Workout) WorkoutListView.getItemAtPosition(position);

                // Display the user selection in a Toast
                String WorkoutOverview = ListViewSelectedWorkout.getCompletedInfo();

                Toast.makeText(CompletedWorkouts.this, WorkoutOverview, Toast.LENGTH_SHORT).show();
            }
        });



    }
}