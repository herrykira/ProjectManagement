package com.example.tinku.projectmanagementsystem.tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tinku.projectmanagementsystem.R;
import com.example.tinku.projectmanagementsystem.model.ProjectsListResponse;
import com.example.tinku.projectmanagementsystem.network.RetrofitInstance;
import com.example.tinku.projectmanagementsystem.network.UserService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ryellap on 3/3/18.
 */

public class TabProjects extends Fragment {

    public TabProjects() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tabprojects, container, false);

        UserService userService = RetrofitInstance.getRetrofitInstance().create(UserService.class);
        Call<ProjectsListResponse> call = userService.getListOfProjects();
        call.enqueue(new Callback<ProjectsListResponse>() {
            @Override
            public void onResponse(Call<ProjectsListResponse> call, Response<ProjectsListResponse> response) {
                Log.e("Projects List is ", response.body().toString());
            }

            @Override
            public void onFailure(Call<ProjectsListResponse> call, Throwable t) {

            }
        });
        return rootView;
    }
}
