package com.exerciseapplication.finalexerciseapplication;

import java.util.*;

public class Workout {
	
	
	private String Title ;
	private int WorkoutID ;
	private boolean completed ;
	private String dateTotal , dateDay , dateMonth , dateYear , description , stretches ,duration, time ;
	private List <Exercise> ExerciseList = new ArrayList<>();
	private int Iterator = 0;


	public Workout(String Title) {

		this.Title = Title ;
	}

	public Workout (String Title, List<Exercise> ExerciseList){
		this.Title = Title ;
		this.ExerciseList = ExerciseList;
	}

	public boolean addExercise(Exercise Exercise) {
		if ( ExerciseList.add(Exercise)) return true;
		else return false;
	}

	public Exercise getFirstExercise(){

		return ExerciseList.get(0);

	}

	public Exercise nextExercise(){

		if (hasNext() == true) {
			Iterator++;
			return ExerciseList.get(Iterator);
		}
		else return null;
	}

	public Exercise previousExercise(){

		if (hasPrevious() == true) {
			Iterator--;
			return ExerciseList.get(Iterator);
		}
		else return null ;

	}

	public Exercise getExercise() {

		return ExerciseList.get(Iterator);

	}

	public boolean hasNext(){

		if (ExerciseList.size()-1 <= Iterator) return false ;
		else return true ;

	}

	public boolean hasPrevious(){

		if (Iterator > 0 ) return true ;
		else return false ;

	}

	public void setExerciseList(List<Exercise> List){

		ExerciseList = List;

	}

	public int getIterator(){
		return Iterator ;
	}

	public Exercise getExerciseAtIndex(int index){

		return ExerciseList.get(index);

	}

	public int getExerciseCount(){

		return ExerciseList.size();

	}

	public String getCompletedInfo(){

		String result;

		result = "Workout Title: " + Title + "\n" +
				 "Workout Date: " + dateTotal + "\n" +
				 "Workout Duration" + duration ;
		return  result ;
	}

	// Generated Getters and Setters
	public void setIterator(int Iterator){
		this.Iterator = Iterator ;
	}

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

	public void setDateTotal(String Date){ this.dateTotal = Date ;	}

	public String getDateTotal (){ return dateTotal	; }

	public void setDuration(String Duration){ this.duration = Duration; }

	public String getDuration(){ return duration ;}

	public void setTime(String Time){ this.time = Time; }

	public String getTime(){ return time ;}

	public String toString() {
		return Title ;
	}
	

}
