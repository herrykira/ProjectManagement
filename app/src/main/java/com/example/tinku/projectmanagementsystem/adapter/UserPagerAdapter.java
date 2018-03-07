package com.example.tinku.projectmanagementsystem.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.tinku.projectmanagementsystem.fragment.InboxFragment;
import com.example.tinku.projectmanagementsystem.fragment.taskList.TaskListFragment;


/**
 * Created by KinhangPoon on 3/3/2018.
 */

public class UserPagerAdapter extends FragmentStatePagerAdapter {
    int tabcount;

    public UserPagerAdapter(FragmentManager fm, int tabcount) {
        super(fm);
        this.tabcount = tabcount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                InboxFragment inboxFragment = new InboxFragment();
                return inboxFragment;
            case 1:
                TaskListFragment taskListFragment = new TaskListFragment();
                return taskListFragment;
        }
        return null;
    }

    @Override
    public int getCount() {
        return tabcount;
    }
}
