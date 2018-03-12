package com.example.tinku.projectmanagementsystem.tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tinku.projectmanagementsystem.R;
import com.example.tinku.projectmanagementsystem.adapter.ProjectListAdapter;
import com.example.tinku.projectmanagementsystem.model.ProjectsListResponse;
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

public class TabProjects extends Fragment {

    static public List<String> idOfProjects = new ArrayList<>();
    static public List<String> namesOfProjects = new ArrayList<>();

    ProjectListAdapter adapter;
    RecyclerView recyclerView_projectlist;

    public TabProjects() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.tabprojects, container, false);

        UserService userService = RetrofitInstance.getRetrofitInstance().create(UserService.class);
        Call<ProjectsListResponse> call = userService.getListOfProjects();
        call.enqueue(new Callback<ProjectsListResponse>() {
            @Override
            public void onResponse(Call<ProjectsListResponse> call, Response<ProjectsListResponse> response) {


                for (int i = 0; i < response.body().getProjects().size(); i++) {
                    idOfProjects.add(response.body().getProjects().get(i).getId());
                }
                Log.e("List Of Id's", "" + idOfProjects);

                for (int i = 0; i < response.body().getProjects().size(); i++) {
                    namesOfProjects.add(response.body().getProjects().get(i).getProjectname());
                }
                Log.e("Names Of Projects", "" + namesOfProjects);
                adapter = new ProjectListAdapter(getContext(), response.body().getProjects());

                recyclerView_projectlist = rootView.findViewById(R.id.recyclerView_projectList);
                recyclerView_projectlist.setLayoutManager(new GridLayoutManager(getContext(),2));
                recyclerView_projectlist.setHasFixedSize(true);
                recyclerView_projectlist.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<ProjectsListResponse> call, Throwable t) {

            }
        });
        return rootView;
    }
}
