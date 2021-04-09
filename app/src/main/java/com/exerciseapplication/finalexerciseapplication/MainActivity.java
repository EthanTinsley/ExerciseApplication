package com.exerciseapplication.finalexerciseapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button CompletedWorkouts = (Button) findViewById(R.id.PreviousWorkoutsButton);
        CompletedWorkouts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent CompletedWorkoutsIntent = new Intent(view.getContext() , CompletedWorkouts .class) ;
                startActivityForResult(CompletedWorkoutsIntent, 0);
            }
        });
    }
}