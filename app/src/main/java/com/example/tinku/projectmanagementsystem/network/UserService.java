package com.example.tinku.projectmanagementsystem.network;

import com.example.tinku.projectmanagementsystem.model.DetailResponse;
import com.example.tinku.projectmanagementsystem.model.EmployeeListResponse;
import com.example.tinku.projectmanagementsystem.model.ForgotResponse;
import com.example.tinku.projectmanagementsystem.model.ProjectsListResponse;
import com.example.tinku.projectmanagementsystem.model.TaskListResponse;
import com.example.tinku.projectmanagementsystem.model.TaskResponse;
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

}