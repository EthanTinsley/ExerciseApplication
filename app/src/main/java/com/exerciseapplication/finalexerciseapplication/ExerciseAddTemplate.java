package com.exerciseapplication.finalexerciseapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ExerciseAddTemplate extends AppCompatActivity {

    Boolean BuildingWorkout ;
    String WorkoutName ;
    String ExerciseName ;
    String ExerciseDescription ;
    int ExerciseImageID ;
    EditText RepCount ;
    EditText SetCount ;
    Button addExercise ;
    Exercise exercise ;
    int Reps ;
    int Sets ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_add_template);

        //determine if building a workout
        BuildingWorkout = getIntent().getBooleanExtra("BuildingWorkout",false);
        // if building a workout then set workoutName
        if (BuildingWorkout == true) WorkoutName = getIntent().getStringExtra("WorkoutName");

        // get Exercise Name, Description , and image from intenet
        ExerciseName = getIntent().getStringExtra("ExerciseName");
        ExerciseDescription = getIntent().getStringExtra("ExerciseDescription");
        ExerciseImageID = getIntent().getIntExtra("ExerciseImage", 0);

        // Exercise title changes to name of exercise
        TextView ExerciseTitle = (TextView) findViewById(R.id.confirmationWorkoutTitle) ;
        ExerciseTitle.setText(ExerciseName);

        // Exercise Description set based off of Intent
        TextView ExerciseDescriptionTextView = (TextView) findViewById((R.id.confirmPreWorkoutStretches)) ;
        ExerciseDescriptionTextView.setText(ExerciseDescription);

        //Exercise Image is set accordingly
        ImageView image = (ImageView) findViewById(R.id.imageView);
        image.setImageResource(ExerciseImageID);

        // Getting EditText and button id's
        RepCount = (EditText) findViewById(R.id.repCountEditText);
        SetCount = (EditText) findViewById(R.id.setCountEditText);
        addExercise = (Button) findViewById(R.id.confirmedStartWorkout);

        // If the user is not building a workout then hide user input and finalization options
        if (BuildingWorkout != true){
            RepCount.setVisibility(View.GONE);
            SetCount.setVisibility(View.GONE);
            addExercise.setVisibility(View.GONE);
        }

        addExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get user input for set and rep counts

                if (!SetCount.getText().toString().matches("")) Sets = Integer.parseInt(SetCount.getText().toString());
                else Sets = -1 ;
                if (!RepCount.getText().toString().matches("")) Reps = Integer.parseInt(RepCount.getText().toString());
                else Reps = -1 ;

                // create a new exercise to enter the database
                exercise = new Exercise(ExerciseName);
                exercise.setDescription(ExerciseDescription);
                exercise.setImageID(ExerciseImageID);
                exercise.setRepCount(Reps);
                exercise.setSetCount(Sets);
                // Intent to go back to template screen
                Intent ExerciseAdded = new Intent(view.getContext(), BuildWorkoutScreen.class );

                //Create database helper to add exercise to the database
                DataBaseHelper dataBaseHelper = new DataBaseHelper(ExerciseAddTemplate.this);
                // Insert the exercise into the currently selected workout
                boolean success = dataBaseHelper.addExercise(WorkoutName, exercise);

                // if exercise was added correctly then return to overview and let user know
                if (success == true) {
                    Toast.makeText(ExerciseAddTemplate.this, "Exercise: " + ExerciseName +
                            " Was successfully added to " + WorkoutName , Toast.LENGTH_LONG).show();
                    ExerciseAdded.putExtra("WorkoutTitle",WorkoutName);
                    startActivityForResult(ExerciseAdded,0);
                }
                else {
                    Toast.makeText(ExerciseAddTemplate.this, "Something Went Wrong!" , Toast.LENGTH_LONG).show();
                }
            }
        });



    }
}