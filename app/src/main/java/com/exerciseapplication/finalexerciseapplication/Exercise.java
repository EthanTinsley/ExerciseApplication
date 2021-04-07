package com.exerciseapplication.finalexerciseapplication;

public class Exercise {
	
	public int  repCount , setCount ;
	public String name , description , imageName , muscleGroup , ID  ;
	
	
	public Exercise(String name ) {
		
		this.name = name ;
		
	}


	
	//Appropriate Getters and Setters for Exercise Class 
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		this.ID = iD;
	}

	public int getRepCount() {
		return repCount;
	}

	public void setRepCount(int repCount) {
		this.repCount = repCount;
	}

	public int getSetCount() {
		return setCount;
	}

	public void setSetCount(int setCount) {
		this.setCount = setCount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getMuscleGroup() {
		return muscleGroup;
	}

	public void setMuscleGroup(String muscleGroup) {
		this.muscleGroup = muscleGroup;
	}
	
	public String toString() {
		return name ;
	}
}
