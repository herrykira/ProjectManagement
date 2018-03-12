package com.example.tinku.projectmanagementsystem.tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tinku.projectmanagementsystem.R;
import com.example.tinku.projectmanagementsystem.adapter.AllTasksListAdapter;
import com.example.tinku.projectmanagementsystem.model.TaskListResponse;
import com.example.tinku.projectmanagementsystem.network.RetrofitInstance;
import com.example.tinku.projectmanagementsystem.network.UserService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ryellap on 3/3/18.
 */

public class TabAllTasks extends Fragment {
    static public List<String> idOfTasks = new ArrayList<>();
    AllTasksListAdapter myAdapter;
    RecyclerView myRecyclerView;

    public TabAllTasks() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab_all_tasks, container, false);
        myRecyclerView = rootView.findViewById(R.id.recycler_view_of_all_tasks);

        UserService userService = RetrofitInstance.getRetrofitInstance().create(UserService.class);
        Call<TaskListResponse> call = userService.getListOfTasks();
        call.enqueue(new Callback<TaskListResponse>() {
            @Override
            public void onResponse(Call<TaskListResponse> call, Response<TaskListResponse> response) {
                for (int i = 0; i < response.body().getProjectTask().size(); i++) {
                    idOfTasks.add(response.body().getProjectTask().get(i).getTaskid());
                }
                myAdapter = new AllTasksListAdapter(response.body().getProjectTask(), getContext());
                myRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                myRecyclerView.setHasFixedSize(true);
                myRecyclerView.setAdapter(myAdapter);
                Log.e("ID OF TASKS", "" + idOfTasks);
            }

            @Override
            public void onFailure(Call<TaskListResponse> call, Throwable t) {

            }
        });
        return rootView;
    }

}
