package com.example.tinku.projectmanagementsystem.fragment.taskDetail;

import android.view.View;

import com.example.tinku.projectmanagementsystem.model.DetailResponse;

import retrofit2.Response;


/**
 * Created by KinhangPoon on 5/3/2018.
 */

public interface TaskDetailView {
    public void updateView(View view);
    public void setText(Response<DetailResponse> response);
}
