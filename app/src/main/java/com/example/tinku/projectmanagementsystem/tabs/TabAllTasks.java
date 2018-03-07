package com.example.tinku.projectmanagementsystem.tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tinku.projectmanagementsystem.R;

import com.example.tinku.projectmanagementsystem.model.TaskListResponse;
import com.example.tinku.projectmanagementsystem.network.RetrofitInstance;
import com.example.tinku.projectmanagementsystem.network.UserService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ryellap on 3/3/18.
 */

public class TabAllTasks extends Fragment {

    public TabAllTasks() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab_all_tasks, container, false);

        UserService userService = RetrofitInstance.getRetrofitInstance().create(UserService.class);
        Call<TaskListResponse> call = userService.getListOfTasks();
        call.enqueue(new Callback<TaskListResponse>() {
            @Override
            public void onResponse(Call<TaskListResponse> call, Response<TaskListResponse> response) {
                Log.e("Task List is ", response.body().toString());
            }

            @Override
            public void onFailure(Call<TaskListResponse> call, Throwable t) {

            }
        });
        return rootView;
    }

}
