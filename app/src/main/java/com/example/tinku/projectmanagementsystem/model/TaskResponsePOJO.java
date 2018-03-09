package com.example.tinku.projectmanagementsystem.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class TaskResponsePOJO{

	@SerializedName("view tasks")
	private List<ViewTasksItem> viewTasks;

	public void setViewTasks(List<ViewTasksItem> viewTasks){
		this.viewTasks = viewTasks;
	}

	public List<ViewTasksItem> getViewTasks(){
		return viewTasks;
	}

	@Override
 	public String toString(){
		return 
			"TaskResponsePOJO{" + 
			"view tasks = '" + viewTasks + '\'' + 
			"}";
		}
}