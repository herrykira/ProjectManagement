package com.example.tinku.projectmanagementsystem.model;


import com.google.gson.annotations.SerializedName;

public class ProjectTaskItem{

	@SerializedName("taskstatus")
	private String taskstatus;

	@SerializedName("taskdesc")
	private String taskdesc;

	@SerializedName("endstart")
	private String endstart;

	@SerializedName("taskname")
	private String taskname;

	@SerializedName("startdate")
	private String startdate;

	@SerializedName("projectid")
	private String projectid;

	@SerializedName("taskid")
	private String taskid;

	public void setTaskstatus(String taskstatus){
		this.taskstatus = taskstatus;
	}

	public String getTaskstatus(){
		return taskstatus;
	}

	public void setTaskdesc(String taskdesc){
		this.taskdesc = taskdesc;
	}

	public String getTaskdesc(){
		return taskdesc;
	}

	public void setEndstart(String endstart){
		this.endstart = endstart;
	}

	public String getEndstart(){
		return endstart;
	}

	public void setTaskname(String taskname){
		this.taskname = taskname;
	}

	public String getTaskname(){
		return taskname;
	}

	public void setStartdate(String startdate){
		this.startdate = startdate;
	}

	public String getStartdate(){
		return startdate;
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
			"ProjectTaskItem{" + 
			"taskstatus = '" + taskstatus + '\'' + 
			",taskdesc = '" + taskdesc + '\'' + 
			",endstart = '" + endstart + '\'' + 
			",taskname = '" + taskname + '\'' + 
			",startdate = '" + startdate + '\'' + 
			",projectid = '" + projectid + '\'' + 
			",taskid = '" + taskid + '\'' + 
			"}";
		}
}