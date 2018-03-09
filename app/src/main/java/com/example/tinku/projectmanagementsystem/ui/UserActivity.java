package com.example.tinku.projectmanagementsystem.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.example.tinku.projectmanagementsystem.R;
import com.example.tinku.projectmanagementsystem.adapter.UserPagerAdapter;
import com.example.tinku.projectmanagementsystem.fragment.InboxFragment;
import com.example.tinku.projectmanagementsystem.fragment.member.MemberFragment;
import com.example.tinku.projectmanagementsystem.fragment.detail.DetailFragment;
import com.example.tinku.projectmanagementsystem.fragment.taskList.TaskListFragment;
import com.example.tinku.projectmanagementsystem.fragment.UserFragmentSwitch;


public class UserActivity extends AppCompatActivity implements UserFragmentSwitch {
    /**
     * declaration
     */
//    NoSwipePager viewPager;
    AHBottomNavigation ahBottomNavigation;
    UserPagerAdapter userPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        /**
         * initialization
         */
        ahBottomNavigation = findViewById(R.id.bottom_navigation);
//        viewPager = findViewById(R.id.viewPager_user);
        userPagerAdapter = new UserPagerAdapter(getSupportFragmentManager(),2);
//        viewPager.setAdapter(userPagerAdapter);

//        viewPager.setPagingEnabled(false);
        /**
         * set up bottom navigation
         */
        AHBottomNavigationItem item1 = new AHBottomNavigationItem("Inbox",R.drawable.inbox1);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem("MyTasks",R.drawable.task1);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem("Member",R.drawable.team);
        ahBottomNavigation.addItem(item1);
        ahBottomNavigation.addItem(item2);
        ahBottomNavigation.addItem(item3);

        ahBottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position, boolean wasSelected) {
                switch (position){
                    case 0:
                        getSupportFragmentManager().beginTransaction()
                                .addToBackStack(null)
                                .replace(R.id.user_main,new InboxFragment())
                                .commit();
                        break;
                    case 1:
                        getSupportFragmentManager().beginTransaction()
                                .addToBackStack(null)
                                .replace(R.id.user_main,new TaskListFragment())
                                .commit();
                        break;
                    case 2:
                        getSupportFragmentManager().beginTransaction()
                                .addToBackStack(null)
                                .replace(R.id.user_main,new MemberFragment())
                                .commit();
                }
//                if(!wasSelected) {
//                    viewPager.setCurrentItem(position);
//                }
            }
        });
    }

    @Override
    public void switchToDetail(String taskId,String productId) {
        Bundle bundle = new Bundle();
        bundle.putString("taskId",taskId);
        bundle.putString("productId",productId);
        Log.i("beforeDetail",taskId);
        Log.i("beforeDetail",productId);
        DetailFragment detailFragment = new DetailFragment();
        detailFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.user_main,detailFragment)
                .addToBackStack(null).commit();
    }
}
