package com.example.tinku.projectmanagementsystem.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class EmployeeListResponse{

	@SerializedName("employees")
	private List<EmployeesItem> employees;

	public void setEmployees(List<EmployeesItem> employees){
		this.employees = employees;
	}

	public List<EmployeesItem> getEmployees(){
		return employees;
	}

	@Override
 	public String toString(){
		return 
			"EmployeeListResponse{" + 
			"employees = '" + employees + '\'' + 
			"}";
		}
}