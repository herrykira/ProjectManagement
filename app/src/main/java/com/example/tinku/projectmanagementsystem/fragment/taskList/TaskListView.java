package com.example.tinku.projectmanagementsystem.fragment.taskList;

import android.view.View;

import com.example.tinku.projectmanagementsystem.model.Task;

import java.util.List;

/**
 * Created by KinhangPoon on 7/3/2018.
 */

public interface TaskListView {
    public void updateView(View view);
    public void showTaskList(List<Task> taskList);
}
