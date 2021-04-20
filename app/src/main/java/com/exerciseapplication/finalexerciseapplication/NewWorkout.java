package com.exerciseapplication.finalexerciseapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewWorkout extends AppCompatActivity {

    Button NewWorkout ;
    EditText WorkoutTitle ;
    EditText WorkoutDescription ;
    EditText WorkoutStretches ;
    String Title , Description , Stretches ;
    Workout CreatedWorkout ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_workout);

        NewWorkout = (Button) findViewById(R.id.NewWorkoutButton);
        WorkoutTitle = (EditText) findViewById(R.id.NewWorkoutTitleEditText);
        WorkoutDescription = (EditText) findViewById(R.id.DescriptionEditText);
        WorkoutStretches = (EditText) findViewById(R.id.StretchesEditText);





        NewWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Title = WorkoutTitle.getText().toString() ;
                Description = WorkoutDescription.getText().toString() ;
                Stretches = WorkoutStretches.getText().toString() ;

                DataBaseHelper dataBaseHelper = new DataBaseHelper(NewWorkout.this);
                CreatedWorkout = new Workout(Title);
                CreatedWorkout.setDescription(Description);
                CreatedWorkout.setStretches(Stretches);

                boolean success = dataBaseHelper.NewWorkout(CreatedWorkout);

                Toast.makeText(NewWorkout.this, "Workout: " + Title + " was created successfully!"
                                , Toast.LENGTH_SHORT).show();

                Intent NewWorkout = new Intent(view.getContext() , BuildWorkoutScreen.class);
                NewWorkout.putExtra("WorkoutTitle" , Title );
                startActivityForResult(NewWorkout,0);
            }
        });


    }
}