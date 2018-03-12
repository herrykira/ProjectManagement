package com.example.tinku.projectmanagementsystem.network;

import com.example.tinku.projectmanagementsystem.model.CreateProjectResponse;
import com.example.tinku.projectmanagementsystem.model.CreateSubTaskResponse;
import com.example.tinku.projectmanagementsystem.model.CreateTaskResponse;
import com.example.tinku.projectmanagementsystem.model.CreateTeamMemberResponse;
import com.example.tinku.projectmanagementsystem.model.DetailResponse;
import com.example.tinku.projectmanagementsystem.model.EditProjectResponse;
import com.example.tinku.projectmanagementsystem.model.EmployeeListResponse;
import com.example.tinku.projectmanagementsystem.model.ForgotResponse;
import com.example.tinku.projectmanagementsystem.model.MemberDetailResponse;
import com.example.tinku.projectmanagementsystem.model.MemberTaskResponse;
import com.example.tinku.projectmanagementsystem.model.ProjectsListResponse;
import com.example.tinku.projectmanagementsystem.model.SubTaskDetailResponse;
import com.example.tinku.projectmanagementsystem.model.SubTaskListResponse;
import com.example.tinku.projectmanagementsystem.model.TaskListResponse;
import com.example.tinku.projectmanagementsystem.model.TaskResponse;
import com.example.tinku.projectmanagementsystem.model.TaskResponsePOJO;
import com.example.tinku.projectmanagementsystem.model.UserInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by KinhangPoon on 5/3/2018.
 */

public interface UserService {
    @GET("pms_login.php")
    public Call<UserInfo> getUserInforDetail(@Query("email") String email, @Query("password") String password);

    @GET("pms_forgot_pass.php")
    public Call<ForgotResponse> getPassword(@Query("email") String email);

    @GET("pms_view_task.php")
    public Call<TaskResponse> getTaskList(@Query("user_id") String user_id);

    @GET("pms_view_task_deatil.php")
    public Call<DetailResponse> getTaskDetail(@Query("taskid") String taskid, @Query("project_id") String productid);

    @GET("pms_employee_list.php") //This is for Admin to get list of employees
    public Call<EmployeeListResponse> getListOfEmployees();

    @GET("pms_projects.php")  // This is For admin to get list of projects
    public Call<ProjectsListResponse> getListOfProjects();

    @GET("pms_project_task_list.php") //This is for admin to Get List of tasks
    public Call<TaskListResponse> getListOfTasks();

    @GET("pms_create_project.php") //This is to create Project for admin
    public Call<CreateProjectResponse> getCreateProjectResponse(@Query("project_name") String projectName, @Query("project_status") String projectStatus, @Query("project_desc") String description, @Query("start_date") String startDate, @Query("end_date") String endDate);

    @GET("pms_create_sub_task.php") // This is for admin to create sub-Task
    public Call<CreateSubTaskResponse> getCreateSubTaskResponse(@Query("project_id") String ProjectName, @Query("task_id") String taskId, @Query("sub_task_name") String taskName, @Query("sub_task_status") String task_status, @Query("sub_task_desc") String sub_task_desc, @Query("start_date") String startDate, @Query("end_date") String endDate);

    @GET("pms_create_task.php")// This is for admin to create task
    public Call<CreateTaskResponse> getCreateTaskResponse(@Query("project_id") String projectId, @Query("task_name") String taskName, @Query("task_status") String taskStatus, @Query("task_desc") String taskDescription, @Query("start_date") String startDate, @Query("end_date") String endDate);

    @GET("pms_create_project_team.php") // This is fro admin to create the team
    public Call<CreateTeamMemberResponse> getCreateTeamMember(@Query("project_id") String projectId, @Query("team_member_userid") String teamMemberId);

    @GET("pms_edit_project.php") //This is for admin to edit projects
    public Call<EditProjectResponse> getEditProjectResponse(@Query("project_id") String projectId, @Query("project_name") String projectName, @Query("project_status") String status, @Query("project_desc") String projectDescription, @Query("start_date") String startDate, @Query("end_end") String endDate);




    @GET("pms_view_subtask.php")
    public Call<SubTaskListResponse> getSubTaskList(@Query("user_id") String user_id, @Query("taskid") String taskid);

    @GET("pms_view_sub_task_deatil.php")
    public Call<SubTaskDetailResponse> getSubTaskDetail(@Query("taskid") String taskid, @Query("subtask_id") String subtask_id, @Query("project_id") String project_id);

    @GET("pms_team_task.php")
    public Call<MemberTaskResponse> getTaskMember(@Query("taskid") String taskid,@Query("projectid") String projectid);

    @GET("pms_team_member_deatil.php")
    public Call<MemberDetailResponse> getMemberDetail(@Query("memberuserid") String userid);
}