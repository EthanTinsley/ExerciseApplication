package com.exerciseapplication.finalexerciseapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class WorkoutTemplates extends AppCompatActivity {

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
        DataBaseHelper DataBaseHelper = new DataBaseHelper(WorkoutTemplates.this);

        // Return all available workouts
        Workouts = DataBaseHelper.getWorkouts();

        // find the ListView in resources
        WorkoutListView = findViewById(R.id.workoutTemplatesListView);

        // create the object to hold the workouts
        workoutArrayAdapter = new ArrayAdapter<Workout>(WorkoutTemplates.this, android.R.layout.simple_list_item_1, Workouts);

        // fill the list view with the array adapter
        WorkoutListView.setAdapter(workoutArrayAdapter);

        // Method for selecting an element from the ListView
        WorkoutListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // get the object stored in the listview that the user selected
                Workout ListViewSelectedWorkout = (Workout) WorkoutListView.getItemAtPosition(position);

                // if user is NOT starting a workout direct them to workout builder to edit workout
                // else direct to start workout work-flow
                if (startingWorkout != true) WorkoutSelected = new Intent(WorkoutTemplates.this,BuildWorkoutScreen.class);
                else WorkoutSelected = new Intent(WorkoutTemplates.this,WorkoutStartConfirmation.class);

                // send workout infromation to the next activity
                WorkoutSelected.putExtra("WorkoutTitle",ListViewSelectedWorkout.getTitle());
                WorkoutSelected.putExtra("WorkoutDescription",ListViewSelectedWorkout.getDescription());
                WorkoutSelected.putExtra("WorkoutStretches",ListViewSelectedWorkout.getStretches());
                startActivityForResult(WorkoutSelected,0);
            }
        });

        // Back Button and Action Listener
        Button BackButton = (Button) findViewById(R.id.WorkoutTemplatesBackButton);
        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent GoBack = new Intent(v.getContext() , MainActivity.class);
                startActivityForResult(GoBack, 0);
            }
        });


    }
}