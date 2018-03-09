package com.example.tinku.projectmanagementsystem.model;


import com.google.gson.annotations.SerializedName;


public class MembersItem{

	@SerializedName("projectid")
	private String projectid;

	@SerializedName("userid")
	private String userid;

	@SerializedName("assignid")
	private String assignid;

	@SerializedName("taskid")
	private String taskid;

	public void setProjectid(String projectid){
		this.projectid = projectid;
	}

	public String getProjectid(){
		return projectid;
	}

	public void setUserid(String userid){
		this.userid = userid;
	}

	public String getUserid(){
		return userid;
	}

	public void setAssignid(String assignid){
		this.assignid = assignid;
	}

	public String getAssignid(){
		return assignid;
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
			"MembersItem{" + 
			"projectid = '" + projectid + '\'' + 
			",userid = '" + userid + '\'' + 
			",assignid = '" + assignid + '\'' + 
			",taskid = '" + taskid + '\'' + 
			"}";
		}
}