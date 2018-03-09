package com.example.tinku.projectmanagementsystem.model;


import com.google.gson.annotations.SerializedName;


public class SubTaskDetailResponse{

	@SerializedName("subtaskdesc")
	private String subtaskdesc;

	@SerializedName("endstart")
	private String endstart;

	@SerializedName("subtaskname")
	private String subtaskname;

	@SerializedName("subtaskid")
	private String subtaskid;

	@SerializedName("subtaskstatus")
	private String subtaskstatus;

	@SerializedName("startdate")
	private String startdate;

	@SerializedName("projectid")
	private String projectid;

	@SerializedName("taskid")
	private String taskid;

	public SubTaskDetailResponse(String subtaskdesc, String endstart, String subtaskname, String subtaskid, String subtaskstatus, String startdate, String projectid, String taskid) {
		this.subtaskdesc = subtaskdesc;
		this.endstart = endstart;
		this.subtaskname = subtaskname;
		this.subtaskid = subtaskid;
		this.subtaskstatus = subtaskstatus;
		this.startdate = startdate;
		this.projectid = projectid;
		this.taskid = taskid;
	}

	public void setSubtaskdesc(String subtaskdesc){
		this.subtaskdesc = subtaskdesc;
	}

	public String getSubtaskdesc(){
		return subtaskdesc;
	}

	public void setEndstart(String endstart){
		this.endstart = endstart;
	}

	public String getEndstart(){
		return endstart;
	}

	public void setSubtaskname(String subtaskname){
		this.subtaskname = subtaskname;
	}

	public String getSubtaskname(){
		return subtaskname;
	}

	public void setSubtaskid(String subtaskid){
		this.subtaskid = subtaskid;
	}

	public String getSubtaskid(){
		return subtaskid;
	}

	public void setSubtaskstatus(String subtaskstatus){
		this.subtaskstatus = subtaskstatus;
	}

	public String getSubtaskstatus(){
		return subtaskstatus;
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
			"SubTaskDetailResponse{" + 
			"subtaskdesc = '" + subtaskdesc + '\'' + 
			",endstart = '" + endstart + '\'' + 
			",subtaskname = '" + subtaskname + '\'' + 
			",subtaskid = '" + subtaskid + '\'' + 
			",subtaskstatus = '" + subtaskstatus + '\'' + 
			",startdate = '" + startdate + '\'' + 
			",projectid = '" + projectid + '\'' + 
			",taskid = '" + taskid + '\'' + 
			"}";
		}
}