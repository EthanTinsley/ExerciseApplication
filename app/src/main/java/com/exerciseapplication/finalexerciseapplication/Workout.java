package com.exerciseapplication.finalexerciseapplication;

import java.util.*;

public class Workout {
	
	
	private String Title ;
	private int WorkoutID ;
	private boolean completed ;
	private String dateDay , dateMonth , dateYear , description , stretches;
	private List <Exercise> ExerciseList = new ArrayList<>();


	public Workout(String Title) {

		this.Title = Title ;
	}



	// Generated Getters and Setters
	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public int getWorkoutID() {
		return WorkoutID;
	}

	public void setWorkoutID(int workoutID) {
		WorkoutID = workoutID;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public String getDateDay() {
		return dateDay;
	}

	public void setDateDay(String dateDay) {
		this.dateDay = dateDay;
	}

	public String getDateMonth() {
		return dateMonth;
	}

	public void setDateMonth(String dateMonth) {
		this.dateMonth = dateMonth;
	}

	public String getDateYear() {
		return dateYear;
	}

	public void setDateYear(String dateYear) {
		this.dateYear = dateYear;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStretches() {
		return stretches;
	}

	public void setStretches(String stretches) {
		this.stretches = stretches;
	}

	public String toString() {
		return Title ;
	}
	

}
