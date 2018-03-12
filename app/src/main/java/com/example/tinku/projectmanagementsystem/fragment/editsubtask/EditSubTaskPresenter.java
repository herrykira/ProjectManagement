package com.example.tinku.projectmanagementsystem.fragment.editsubtask;

import android.view.View;

/**
 * Created by KinhangPoon on 9/3/2018.
 */

public interface EditSubTaskPresenter {
    public void createView(View view);

    public void updateStatus(String userid, String taskid, String subtaskid, String projectid, String status);
}
