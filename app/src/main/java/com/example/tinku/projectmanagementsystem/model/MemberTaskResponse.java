package com.example.tinku.projectmanagementsystem.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class MemberTaskResponse{

	@SerializedName("members")
	private List<MembersItem> members;

	public void setMembers(List<MembersItem> members){
		this.members = members;
	}

	public List<MembersItem> getMembers(){
		return members;
	}

	@Override
 	public String toString(){
		return 
			"MemberTaskResponse{" + 
			"members = '" + members + '\'' + 
			"}";
		}
}