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

        Button BackButton = (Button) findViewById(R.id.buildMuscleBackBtn) ;
        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent BackIntent = null ;
                if ( buildingWorkout == true ){
                    BackIntent = new Intent(view.getContext(), BuildWorkoutScreen.class) ;
                }
                else BackIntent = new Intent(view.getContext(), MainActivity.class) ;
                startActivityForResult(BackIntent,0);
            }
        });


        Button MuscleSelectBtn01 = (Button) findViewById(R.id.MuscleSelectBtn01);
        MuscleSelectBtn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent SelectExercise = new Intent(view.getContext(), ExerciseSelectionScreen.class) ;
                startActivityForResult(SelectExercise, 0);
            }
        });
    }
}