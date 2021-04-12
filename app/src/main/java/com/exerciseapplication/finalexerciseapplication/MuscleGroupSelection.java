package com.exerciseapplication.finalexerciseapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MuscleGroupSelection extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muscle_group_selection);

        boolean buildingWorkout  = getIntent().getBooleanExtra("BuildingWorkout", false) ;

        Button ShoulderExercises = (Button) findViewById(R.id.ShouldersButton) ;
        ShoulderExercises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shoulders = new Intent(view.getContext() , ShoulderExercises.class) ;
                startActivityForResult(shoulders,0);
            }
        });





       
    }
}