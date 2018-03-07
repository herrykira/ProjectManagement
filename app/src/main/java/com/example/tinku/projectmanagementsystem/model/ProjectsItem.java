package com.example.tinku.projectmanagementsystem.model;

public class ProjectsItem{
	private String projectname;
	private String endstart;
	private String projectdesc;
	private String id;
	private String startdate;
	private String projectstatus;

	public void setProjectname(String projectname){
		this.projectname = projectname;
	}

	public String getProjectname(){
		return projectname;
	}

	public void setEndstart(String endstart){
		this.endstart = endstart;
	}

	public String getEndstart(){
		return endstart;
	}

	public void setProjectdesc(String projectdesc){
		this.projectdesc = projectdesc;
	}

	public String getProjectdesc(){
		return projectdesc;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setStartdate(String startdate){
		this.startdate = startdate;
	}

	public String getStartdate(){
		return startdate;
	}

	public void setProjectstatus(String projectstatus){
		this.projectstatus = projectstatus;
	}

	public String getProjectstatus(){
		return projectstatus;
	}

	@Override
 	public String toString(){
		return 
			"ProjectsItem{" + 
			"projectname = '" + projectname + '\'' + 
			",endstart = '" + endstart + '\'' + 
			",projectdesc = '" + projectdesc + '\'' + 
			",id = '" + id + '\'' + 
			",startdate = '" + startdate + '\'' + 
			",projectstatus = '" + projectstatus + '\'' + 
			"}";
		}
}
