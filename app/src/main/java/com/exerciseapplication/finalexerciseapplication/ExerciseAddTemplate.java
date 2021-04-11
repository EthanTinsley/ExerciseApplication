package com.exerciseapplication.finalexerciseapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ExerciseAddTemplate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_add_template);
        String name = "testingName" ;

        TextView Title = (TextView) findViewById(R.id.ExerciseTitle) ;
        Title.setText(getResources().getString(R.string.app_name)+name);
    }
}