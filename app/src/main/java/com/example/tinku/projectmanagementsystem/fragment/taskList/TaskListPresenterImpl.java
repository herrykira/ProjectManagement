package com.example.tinku.projectmanagementsystem.fragment.taskList;

import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;

import com.example.tinku.projectmanagementsystem.model.DetailResponse;
import com.example.tinku.projectmanagementsystem.model.SubTaskDetailResponse;
import com.example.tinku.projectmanagementsystem.model.SubTaskListResponse;
import com.example.tinku.projectmanagementsystem.model.Task;
import com.example.tinku.projectmanagementsystem.model.TaskResponse;
import com.example.tinku.projectmanagementsystem.network.RetrofitInstance;
import com.example.tinku.projectmanagementsystem.network.UserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by KinhangPoon on 7/3/2018.
 */

public class TaskListPresenterImpl implements TaskListPresenter {
    TaskListView taskListView;
    Map<String,List<SubTaskDetailResponse>> taskMap = new HashMap<>();
    List<String> taskTitles = new ArrayList<>();

    public TaskListPresenterImpl(TaskListFragment taskListFragment) {
        taskListView = taskListFragment;
    }
    @Override
    public void createView(View view){
        taskListView.updateView(view);
    }

    @Override
    public void sendTaskListRequest(final SharedPreferences sharedPreferences){
        String userId = sharedPreferences.getString("UserId","");
        Log.i("tasklistUserId",userId);
        if(userId.equals("")){
            return;
        }
//        taskMap = new HashMap<>();
//        taskTitles = new ArrayList<>();
        UserService userService = RetrofitInstance.getRetrofitInstance().create(UserService.class);
        Call<TaskResponse> call = userService.getTaskList(userId);
        call.enqueue(new Callback<TaskResponse>() {
            @Override
            public void onResponse(Call<TaskResponse> call, Response<TaskResponse> response) {
                Log.i("TaskListResponse",response.body().toString());
                List<Task> taskList = response.body().getTasksview();

                for(int i=0;i<taskList.size();i++){
                    String projectid = taskList.get(i).getProjectid();
                    String taskid = taskList.get(i).getTaskid();
                    String subtaskid = taskList.get(i).getSubtaskid();
                    requestTaskDetail(taskid,projectid,sharedPreferences);

                }
//                taskListView.showTaskList(taskTitles,taskMap);
//                Log.i("taskMap Size",taskMap.size()+"");
//                Log.i("title size",taskTitles.size()+"");

            }

            @Override
            public void onFailure(Call<TaskResponse> call, Throwable t) {
                Log.e("TaskListError",t.getMessage().toString());
            }
        });
//        taskListView.showTaskList(taskTitles,taskMap);
//        Log.i("taskMap Size",taskMap.size()+"");
//        Log.i("title size",taskTitles.size()+"");

    }

    public void requestTaskDetail(final String taskid, final String projectid, SharedPreferences sharedPreferences){
        final String userId = sharedPreferences.getString("UserId","");
        final UserService userService = RetrofitInstance.getRetrofitInstance().create(UserService.class);
        Call<DetailResponse> call = userService.getTaskDetail(taskid,projectid);
        call.enqueue(new Callback<DetailResponse>() {
            @Override
            public void onResponse(Call<DetailResponse> call, Response<DetailResponse> response) {
                Log.i("TaskDetail",response.body().toString());
                if (response.body().toString().contains("null")){
                    return;
                }
                Log.i("TaskDetail",response.body().getTaskname());
                final String taskName = response.body().getTaskname();
                taskTitles.add(taskName);

                String taskStatus = response.body().getTaskstatus();
                String taskdesc = response.body().getTaskdesc();
                String startdate = response.body().getStartdate();
                String endstart = response.body().getEndstart();

                 final List<SubTaskDetailResponse> subTaskDetailResponses = new ArrayList<>();

                Call<SubTaskListResponse> subtaskCall = userService.getSubTaskList(userId,taskid);
                subtaskCall.enqueue(new Callback<SubTaskListResponse>() {
                    @Override
                    public void onResponse(Call<SubTaskListResponse> call, Response<SubTaskListResponse> response) {
                        Log.i("SubTaskList",response.raw().toString());

                        for(int i =0;i<response.body().getViewSubtasks().size();i++){
                            final String subtaskid = response.body().getViewSubtasks().get(i).getSubtaskid();
                            final Call<SubTaskDetailResponse> subTaskDetailCall = userService.getSubTaskDetail(taskid,subtaskid,projectid);
                            subTaskDetailCall.enqueue(new Callback<SubTaskDetailResponse>() {
                                @Override
                                public void onResponse(Call<SubTaskDetailResponse> call, Response<SubTaskDetailResponse> response) {
                                    Log.i("SubTaskDetail",response.body().getSubtaskname());
                                    String subtaskname = response.body().getSubtaskname();
                                    String subtaskstatus = response.body().getSubtaskstatus();
                                    String subtaskdesc = response.body().getSubtaskdesc();
                                    String startdate = response.body().getStartdate();
                                    String endstart = response.body().getEndstart();

                                    subTaskDetailResponses.add(new SubTaskDetailResponse(subtaskdesc,endstart,subtaskname,subtaskid,subtaskstatus,startdate,projectid,taskid));
                                }

                                @Override
                                public void onFailure(Call<SubTaskDetailResponse> call, Throwable t) {

                                }
                            });
                        }


                    }

                    @Override
                    public void onFailure(Call<SubTaskListResponse> call, Throwable t) {

                    }
                });
                taskMap.put(taskName,subTaskDetailResponses);
                taskListView.showTaskList(taskTitles,taskMap);
                Log.i("taskMap Size",taskMap.size()+"");
                Log.i("title size",taskTitles.size()+"");
            }

            @Override
            public void onFailure(Call<DetailResponse> call, Throwable t) {

            }
        });


    }

}
