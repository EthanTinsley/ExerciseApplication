package com.exerciseapplication.finalexerciseapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NewWorkout extends AppCompatActivity {

    Button NewWorkout ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_workout);

        NewWorkout = (Button) findViewById(R.id.NewWorkoutButton);
        NewWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent NewWorkout = new Intent(view.getContext() , BuildWorkoutScreen.class);
                startActivityForResult(NewWorkout,0);
            }
        });


    }
}