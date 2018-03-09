package com.example.tinku.projectmanagementsystem.model;


import com.google.gson.annotations.SerializedName;

public class MemberResponse{

	@SerializedName("userlastname")
	private String userlastname;

	@SerializedName("userfirstname")
	private String userfirstname;

	@SerializedName("usermobile")
	private String usermobile;

	@SerializedName("userid")
	private String userid;

	@SerializedName("useremail")
	private String useremail;

	public void setUserlastname(String userlastname){
		this.userlastname = userlastname;
	}

	public String getUserlastname(){
		return userlastname;
	}

	public void setUserfirstname(String userfirstname){
		this.userfirstname = userfirstname;
	}

	public String getUserfirstname(){
		return userfirstname;
	}

	public void setUsermobile(String usermobile){
		this.usermobile = usermobile;
	}

	public String getUsermobile(){
		return usermobile;
	}

	public void setUserid(String userid){
		this.userid = userid;
	}

	public String getUserid(){
		return userid;
	}

	public void setUseremail(String useremail){
		this.useremail = useremail;
	}

	public String getUseremail(){
		return useremail;
	}

	@Override
 	public String toString(){
		return 
			"MemberResponse{" + 
			"userlastname = '" + userlastname + '\'' + 
			",userfirstname = '" + userfirstname + '\'' + 
			",usermobile = '" + usermobile + '\'' + 
			",userid = '" + userid + '\'' + 
			",useremail = '" + useremail + '\'' + 
			"}";
		}
}