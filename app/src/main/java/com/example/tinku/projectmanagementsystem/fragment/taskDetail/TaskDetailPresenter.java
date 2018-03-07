package com.example.tinku.projectmanagementsystem.fragment.taskDetail;

import android.view.View;

/**
 * Created by KinhangPoon on 5/3/2018.
 */

public interface TaskDetailPresenter {
    public void createView(View view);
    public void sendDetailRequest(String taskId, String productId);
}
