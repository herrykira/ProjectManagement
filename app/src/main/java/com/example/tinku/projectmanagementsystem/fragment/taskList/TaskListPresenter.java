package com.example.tinku.projectmanagementsystem.fragment.taskList;

import android.content.SharedPreferences;
import android.view.View;

/**
 * Created by KinhangPoon on 7/3/2018.
 */

public interface TaskListPresenter {
    public void createView(View view);
    public void sendTaskListRequest(SharedPreferences sharedPreferences);
}
