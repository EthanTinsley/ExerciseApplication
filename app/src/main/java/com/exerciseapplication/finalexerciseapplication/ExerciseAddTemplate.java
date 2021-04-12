package com.exerciseapplication.finalexerciseapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ExerciseAddTemplate extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_add_template);

        String ExerciseName = getIntent().getStringExtra("ExerciseName");
        String ExerciseNameDescription = getIntent().getStringExtra("ExerciseDescription");

        TextView ExerciseTitle = (TextView) findViewById(R.id.ExerciseTitle) ;
        ExerciseTitle.setText(ExerciseName);

        TextView ExerciseDescription = (TextView) findViewById((R.id.ExerciseDescription)) ;
        ExerciseDescription.setText(ExerciseNameDescription);
    }
}