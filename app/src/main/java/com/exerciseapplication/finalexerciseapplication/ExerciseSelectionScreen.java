package com.exerciseapplication.finalexerciseapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ExerciseSelectionScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_selection_screen);

        Button ExerciseSlelectionBack = (Button) findViewById(R.id.ExerciseSlelectionBack);
        ExerciseSlelectionBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent GoBackIntent = new Intent(view.getContext(), MuscleGroupSelection.class) ;
                startActivityForResult(GoBackIntent, 0);
            }
        });
    }
}