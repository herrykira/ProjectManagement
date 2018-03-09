package com.example.tinku.projectmanagementsystem.fragment.taskList;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.tinku.projectmanagementsystem.R;
import com.example.tinku.projectmanagementsystem.adapter.TaskListAdapter;
import com.example.tinku.projectmanagementsystem.fragment.UserFragmentSwitch;
import com.example.tinku.projectmanagementsystem.model.Task;
import com.example.tinku.projectmanagementsystem.model.TaskResponse;
import com.example.tinku.projectmanagementsystem.network.RetrofitInstance;
import com.example.tinku.projectmanagementsystem.network.UserService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by KinhangPoon on 3/3/2018.
 */

public class TaskListFragment extends Fragment implements TaskListView {


    TextView textViewTaskList;
    RecyclerView recyclerViewTaskList;
    UserFragmentSwitch userFragmentSwitch;
    TaskListAdapter taskListAdapter;
    SharedPreferences sharedPreferences;
    TaskListPresenter taskListPresenter;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        userFragmentSwitch = (UserFragmentSwitch) getActivity();
        sharedPreferences = context.getSharedPreferences("myinfo",Context.MODE_PRIVATE);
        taskListPresenter = new TaskListPresenterImpl(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.task_list_fragment,container,false);

        taskListPresenter.createView(view);
        return view;
    }

    @Override
    public void updateView(View view) {
        textViewTaskList = view.findViewById(R.id.textView_task_list);
        recyclerViewTaskList = view.findViewById(R.id.recyclerView_task_list);

        recyclerViewTaskList.setHasFixedSize(true);
        recyclerViewTaskList.setItemAnimator(new DefaultItemAnimator());
        recyclerViewTaskList.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewTaskList.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));

        taskListPresenter.sendTaskListRequest(sharedPreferences);
    }

    @Override
    public void showTaskList(List<Task> taskList) {
        taskListAdapter = new TaskListAdapter(taskList,getContext(),userFragmentSwitch);
        recyclerViewTaskList.setAdapter(taskListAdapter);

    }
}
