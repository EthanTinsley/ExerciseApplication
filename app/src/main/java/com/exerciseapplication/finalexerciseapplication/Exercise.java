package com.exerciseapplication.finalexerciseapplication;

public class Exercise {

	private int templateID, imageID, repCount, setCount;
	private String name , description , muscleGroup , ID  ;
	
	
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

	public int getImageID() {
		return imageID;
	}

	public void setImageID(int imageID) { this.imageID = imageID; }

	public String getMuscleGroup() { return muscleGroup; }

	public void setMuscleGroup(String muscleGroup) {
		this.muscleGroup = muscleGroup;
	}
	
	public String toString() {
		return name ;
	}

	public int getTemplateID() { return templateID; }

	public void setTemplateID(int templateID) {	this.templateID = templateID; }


}
