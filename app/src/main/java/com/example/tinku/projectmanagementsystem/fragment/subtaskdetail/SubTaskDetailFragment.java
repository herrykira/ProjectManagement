package com.example.tinku.projectmanagementsystem.fragment.subtaskdetail;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tinku.projectmanagementsystem.R;

/**
 * Created by KinhangPoon on 5/3/2018.
 */

public class SubTaskDetailFragment extends Fragment implements SubTaskDetailView {
    RecyclerView recyclerView;
    SubTaskDetailPresenter subTaskDetailPresenter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        subTaskDetailPresenter = new SubTaskDetailPresenterImpl(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sub_task_detail_fragment,container,false);
        subTaskDetailPresenter.createView(view);
        return view;
    }

    @Override
    public void updateView(View view) {
        recyclerView = view.findViewById(R.id.recyclerView_subTask);

    }
}
