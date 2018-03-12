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
import com.example.tinku.projectmanagementsystem.adapter.EmployeeListAdapter;
import com.example.tinku.projectmanagementsystem.model.EmployeeListResponse;
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

public class TabEmployeeList extends Fragment {
    public static List<String> list;
    EmployeeListAdapter adapter;
    RecyclerView recyclerView_employeelist;


    public TabEmployeeList() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.tab_employee_list, container, false);
        list = new ArrayList<>();
        UserService userService = RetrofitInstance.getRetrofitInstance().create(UserService.class);
        Call<EmployeeListResponse> call = userService.getListOfEmployees();
        call.enqueue(new Callback<EmployeeListResponse>() {
            @Override
            public void onResponse(Call<EmployeeListResponse> call, Response<EmployeeListResponse> response) {
                Log.e("Employee list is", response.body().getEmployees().size() + "");

                for (int i = 0; i < response.body().getEmployees().size(); i++) {

                    list.add(response.body().getEmployees().get(i).getEmpid());
                }
                adapter = new EmployeeListAdapter(response.body().getEmployees(), getContext());
                recyclerView_employeelist = rootView.findViewById(R.id.recyclerView_employeelist);
                recyclerView_employeelist.setLayoutManager(new LinearLayoutManager(getContext()));
                recyclerView_employeelist.setHasFixedSize(true);
                recyclerView_employeelist.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<EmployeeListResponse> call, Throwable t) {

            }
        });

        return rootView;
    }


}
