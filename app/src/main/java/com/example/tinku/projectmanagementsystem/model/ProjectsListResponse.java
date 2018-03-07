package com.example.tinku.projectmanagementsystem.model;

import java.util.List;

public class ProjectsListResponse{
	private List<ProjectsItem> projects;

	public void setProjects(List<ProjectsItem> projects){
		this.projects = projects;
	}

	public List<ProjectsItem> getProjects(){
		return projects;
	}

	@Override
 	public String toString(){
		return 
			"ProjectsListResponse{" + 
			"projects = '" + projects + '\'' + 
			"}";
		}
}