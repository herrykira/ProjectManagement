package com.example.tinku.projectmanagementsystem.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.tinku.projectmanagementsystem.fragment.SubTaskDetailFragment;
import com.example.tinku.projectmanagementsystem.fragment.taskDetail.TaskDetailFragment;

/**
 * Created by KinhangPoon on 5/3/2018.
 */

public class DetailPagerAdapter extends FragmentStatePagerAdapter {
    String taskId,productId;
    int tabcount;

    public DetailPagerAdapter(FragmentManager fm, int tabcount,String taskId,String productId) {
        super(fm);
        this.tabcount = tabcount;
        this.taskId = taskId;
        this.productId = productId;
    }

    @Override
    public Fragment getItem(int position) {
        Bundle bundle = new Bundle();
        bundle.putString("taskId",taskId);
        bundle.putString("productId",productId);
        switch (position){
            case 0:
                TaskDetailFragment taskDetailFragment = new TaskDetailFragment();
                taskDetailFragment.setArguments(bundle);
                return taskDetailFragment;
            case 1:
                SubTaskDetailFragment subTaskDetailFragment = new SubTaskDetailFragment();
                subTaskDetailFragment.setArguments(bundle);
                return subTaskDetailFragment;
        }
        return null;
    }

    @Override
    public int getCount() {
        return tabcount;
    }
}
