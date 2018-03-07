package com.example.tinku.projectmanagementsystem.fragment.taskList;

import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;

import com.example.tinku.projectmanagementsystem.adapter.TaskListAdapter;
import com.example.tinku.projectmanagementsystem.model.Task;
import com.example.tinku.projectmanagementsystem.model.TaskResponse;
import com.example.tinku.projectmanagementsystem.network.RetrofitInstance;
import com.example.tinku.projectmanagementsystem.network.UserService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by KinhangPoon on 7/3/2018.
 */

public class TaskListPresenterImpl implements TaskListPresenter {
    TaskListView taskListView;

    public TaskListPresenterImpl(TaskListFragment taskListFragment) {
        taskListView = taskListFragment;
    }
    @Override
    public void createView(View view){
        taskListView.updateView(view);
    }

    @Override
    public void sendTaskListRequest(SharedPreferences sharedPreferences){
        String userId = sharedPreferences.getString("UserId","");
        Log.i("tasklistUserId",userId);
        if(userId.equals("")){
            return;
        }
        UserService userService = RetrofitInstance.getRetrofitInstance().create(UserService.class);
        Call<TaskResponse> call = userService.getTaskList(userId);
        call.enqueue(new Callback<TaskResponse>() {
            @Override
            public void onResponse(Call<TaskResponse> call, Response<TaskResponse> response) {
                Log.i("TaskListResponse",response.raw().toString());
                List<Task> taskList = response.body().getTasksview();

                taskListView.showTaskList(taskList);
            }

            @Override
            public void onFailure(Call<TaskResponse> call, Throwable t) {
                Log.e("TaskListError",t.getMessage().toString());
            }
        });

    }
}
