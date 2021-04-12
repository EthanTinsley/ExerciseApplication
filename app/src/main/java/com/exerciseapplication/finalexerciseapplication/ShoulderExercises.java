package com.exerciseapplication.finalexerciseapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShoulderExercises extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoulder_exercises);

        Button SeatedOverHeadWeightedPress = (Button) findViewById(R.id.seatWeightedPressButton) ;
        SeatedOverHeadWeightedPress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String testString = getString(R.string.SeatedOverheadWeightedPressDescription);
                Intent Exercise = new Intent(view.getContext() , ExerciseAddTemplate.class) ;
                Exercise.putExtra("ExerciseName", "test");
                Exercise.putExtra("ExerciseDescription", testString);
                startActivityForResult(Exercise,0);
            }
        });
    }
}