package com.example.tinku.projectmanagementsystem.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class AllTaskListResponse{

	@SerializedName("project task")
	private List<ProjectTaskItem> projectTask;

	public void setProjectTask(List<ProjectTaskItem> projectTask){
		this.projectTask = projectTask;
	}

	public List<ProjectTaskItem> getProjectTask(){
		return projectTask;
	}

	@Override
 	public String toString(){
		return 
			"AllTaskListResponse{" + 
			"project task = '" + projectTask + '\'' + 
			"}";
		}
}