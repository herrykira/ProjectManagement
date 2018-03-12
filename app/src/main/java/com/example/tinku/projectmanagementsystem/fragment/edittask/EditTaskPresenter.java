package com.example.tinku.projectmanagementsystem.fragment.edittask;

import android.view.View;

/**
 * Created by KinhangPoon on 9/3/2018.
 */

public interface EditTaskPresenter {
    public void createView(View view);

    public void updateStatus(String userid, String taskid, String projectid, String status);
}
