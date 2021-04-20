package com.exerciseapplication.finalexerciseapplication;

import java.util.*;

public class Workout {
	
	
	private String Title ;
	private int WorkoutID ;
	private boolean completed ;
	private String dateDay , dateMonth , dateYear , description , stretches;
	private LinkedList <Exercise> ExerciseList = new LinkedList();
	private ListIterator<Exercise> iterator ;
	
	
	public Workout(String Title) {
		
		this.Title = Title ;
		
	}

	public boolean addExercise(Exercise newExercise) {
		
		if(ExerciseList.contains(newExercise) != true) return ExerciseList.add(newExercise);
		else return false ;
		
	}
	
	public boolean removeExercise(Exercise Exercise) {
		
		return ExerciseList.remove(Exercise);
		
	}
	
	public boolean swapPositions(Exercise Exercise01 , Exercise Exercise02) {

		if ( ExerciseList.contains(Exercise01) && ExerciseList.contains(Exercise02) ) {
			
			int index01 = ExerciseList.indexOf(Exercise01);
			int index02 = ExerciseList.indexOf(Exercise02);
		
			ExerciseList.add(index02, Exercise01);
			ExerciseList.add(index01, Exercise02);
		
			return true ;
		
		}
		else return false ;
	}
	
	public int getPosition(Exercise Exercise) {
		
		int index = ExerciseList.indexOf(Exercise) ;
		
		return index ;
	}
	
	public int getSize() {
		
		return ExerciseList.size() ;
	}
	
	public int getCurrentIndex() {
		return iterator.nextIndex() - 1 ;
	}
	
	public boolean startWorkout() {
		iterator = ExerciseList.listIterator() ;
		return true ;
	}
	
	
	public boolean hasNext() {
		if (iterator.hasNext() == true ) return true ;
		else return false ;
	}
	
	public Exercise nextExercise() {
		if ( iterator.hasNext() == true ) return iterator.next();
		else return null  ;
	}
	
	public boolean hasPrevious() {
		if (iterator.hasPrevious() == true ) return true ;
		else return false ;
	}
	
	public Exercise previousExercise() {
		if (iterator.previousIndex() != -1) return iterator.previous() ;
		else return null ;
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

	public LinkedList<Exercise> getExerciseList() {
		return ExerciseList;
	}

	public void setExerciseList(LinkedList<Exercise> exerciseList) {
		ExerciseList = exerciseList;
	}

	public void setDescription(String description){ this.description = description ; }

	public String getDescription(){ return description ;}

	public void setStretches(String stretches){ this.stretches = stretches ;}

	public String getStretches(){ return stretches ;}
	

}
