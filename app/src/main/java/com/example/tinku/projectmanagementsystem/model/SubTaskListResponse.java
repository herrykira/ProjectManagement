package com.example.tinku.projectmanagementsystem.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class SubTaskListResponse{

	@SerializedName("view subtasks")
	private List<ViewSubtasksItem> viewSubtasks;

	public void setViewSubtasks(List<ViewSubtasksItem> viewSubtasks){
		this.viewSubtasks = viewSubtasks;
	}

	public List<ViewSubtasksItem> getViewSubtasks(){
		return viewSubtasks;
	}

	@Override
 	public String toString(){
		return 
			"SubTaskListResponse{" + 
			"view subtasks = '" + viewSubtasks + '\'' + 
			"}";
		}
}