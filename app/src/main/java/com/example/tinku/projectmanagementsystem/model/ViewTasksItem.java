package com.example.tinku.projectmanagementsystem.model;


import com.google.gson.annotations.SerializedName;


public class ViewTasksItem{

	@SerializedName("subtaskid")
	private String subtaskid;

	@SerializedName("projectid")
	private String projectid;

	@SerializedName("taskid")
	private String taskid;

	public void setSubtaskid(String subtaskid){
		this.subtaskid = subtaskid;
	}

	public String getSubtaskid(){
		return subtaskid;
	}

	public void setProjectid(String projectid){
		this.projectid = projectid;
	}

	public String getProjectid(){
		return projectid;
	}

	public void setTaskid(String taskid){
		this.taskid = taskid;
	}

	public String getTaskid(){
		return taskid;
	}

	@Override
 	public String toString(){
		return 
			"ViewTasksItem{" + 
			"subtaskid = '" + subtaskid + '\'' + 
			",projectid = '" + projectid + '\'' + 
			",taskid = '" + taskid + '\'' + 
			"}";
		}
}