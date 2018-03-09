package com.example.tinku.projectmanagementsystem.fragment.subtaskdetail;

import android.view.View;

/**
 * Created by KinhangPoon on 7/3/2018.
 */

public class SubTaskDetailPresenterImpl implements SubTaskDetailPresenter {
    SubTaskDetailView subTaskDetailView;

    public SubTaskDetailPresenterImpl(SubTaskDetailFragment subTaskDetailFragment) {
        subTaskDetailView = subTaskDetailFragment;
    }
    @Override
    public void createView(View view){
        subTaskDetailView.updateView(view);
    }
}
