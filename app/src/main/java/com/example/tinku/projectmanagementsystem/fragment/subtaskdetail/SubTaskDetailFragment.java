package com.example.tinku.projectmanagementsystem.fragment.subtaskdetail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tinku.projectmanagementsystem.R;

/**
 * Created by KinhangPoon on 5/3/2018.
 */

public class SubTaskDetailFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sub_task_detail_fragment,container,false);
        return view;
    }
}