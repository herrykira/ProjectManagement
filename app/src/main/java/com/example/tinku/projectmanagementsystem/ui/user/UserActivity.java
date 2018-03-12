package com.example.tinku.projectmanagementsystem.ui.user;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.annotation.ColorRes;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.example.tinku.projectmanagementsystem.R;
import com.example.tinku.projectmanagementsystem.fragment.InboxFragment;
import com.example.tinku.projectmanagementsystem.fragment.fragmentsforfab.ActivityForFloatingActionBar;
import com.example.tinku.projectmanagementsystem.fragment.member.MemberFragment;
import com.example.tinku.projectmanagementsystem.fragment.detail.DetailFragment;
import com.example.tinku.projectmanagementsystem.fragment.taskList.TaskListFragment;
import com.example.tinku.projectmanagementsystem.fragment.UserFragmentSwitch;
import com.example.tinku.projectmanagementsystem.ui.MainActivity;


public class UserActivity extends AppCompatActivity implements UserFragmentSwitch,UserView {
    /**
     * declaration
     */
//    NoSwipePager viewPager;
    AHBottomNavigation ahBottomNavigation;
    FloatingActionButton fabUser,fabEditTask,fabEditSubTask;
    Animation FabOpen, FabClockwise, FabAntiClockWise, FabClose;
    TextView textViewEditTask, textViewEditSubtask;
    UserPresenter userPresenter;
    SharedPreferences sharedPreferences;
    boolean isOpen = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        /**
         * initialization
         */
        userPresenter = new UserPresenterImpl(this);
        userPresenter.createView();

        sharedPreferences = getSharedPreferences("myinfo",Context.MODE_PRIVATE);
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

    @Override
    public void updateView() {
        ahBottomNavigation = findViewById(R.id.bottom_navigation);
        fabUser = findViewById(R.id.fab_user);
        fabEditTask = findViewById(R.id.fab_edit_task);
        fabEditSubTask = findViewById(R.id.fab_edit_subtask);

        textViewEditSubtask = findViewById(R.id.create_edit_task);
        textViewEditTask = findViewById(R.id.create_edit_subtask);

        FabOpen = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        FabClose = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);
        FabClockwise = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_clockwise);
        FabAntiClockWise = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_anticlockwise);

        fabUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOpen) {
                    fabUser.startAnimation(FabAntiClockWise);
                    fabEditTask.startAnimation(FabClose);
                    fabEditSubTask.startAnimation(FabClose);
                    textViewEditTask.startAnimation(FabClose);
                    textViewEditSubtask.startAnimation(FabClose);
                    isOpen = false;
                } else {
                    fabUser.startAnimation(FabClockwise);
                    fabEditSubTask.startAnimation(FabOpen);
                    fabEditTask.startAnimation(FabOpen);
                    textViewEditTask.startAnimation(FabOpen);
                    textViewEditSubtask.startAnimation(FabOpen);
                    isOpen = true;
                }
            }
        });

        fabEditSubTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(UserActivity.this, ActivityForFloatingActionBar.class);
                Bundle bundle = new Bundle();
                bundle.putInt("data", 9);
                i.putExtras(bundle);
                startActivity(i);

            }
        });

        fabEditTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(UserActivity.this, ActivityForFloatingActionBar.class);
                Bundle bundle = new Bundle();
                bundle.putInt("data", 10);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        /**
         * set up bottom navigation
         */
        AHBottomNavigationItem item1 = new AHBottomNavigationItem("Inbox", R.drawable.inbox1, R.color.notepad_margin);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem("MyTasks", R.drawable.task1, R.color.active_color);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem("Member", R.drawable.team, R.color.inactive_color);
        ahBottomNavigation.addItem(item1);
        ahBottomNavigation.addItem(item2);
        ahBottomNavigation.addItem(item3);

        ahBottomNavigation.setDefaultBackgroundColor(Color.parseColor("#FEFEFE"));

        ahBottomNavigation.setCurrentItem(0);
        ahBottomNavigation.setAccentColor(Color.parseColor("#F63D2B"));
        ahBottomNavigation.setInactiveColor(Color.parseColor("#747474"));

        //  Enables color Reveal effect
        ahBottomNavigation.setColored(true);
// Colors for selected (active) and non-selected items (in color reveal mode).
        ahBottomNavigation.setColoredModeColors(Color.WHITE,
                fetchColor(R.color.notepad_margin));

        ahBottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                switch (position) {
                    case 0:
                        getSupportFragmentManager().beginTransaction()
                                .addToBackStack(null)
                                .replace(R.id.user_main, new InboxFragment())
                                .commit();
                        return true;
                    case 1:
                        getSupportFragmentManager().beginTransaction()
                                .addToBackStack(null)
                                .replace(R.id.user_main, new TaskListFragment())
                                .commit();
                        return true;
                    case 2:
                        getSupportFragmentManager().beginTransaction()
                                .addToBackStack(null)
                                .replace(R.id.user_main, new MemberFragment())
                                .commit();
                        return true;
                }

                return true;
            }
        });
    }
    private int fetchColor(@ColorRes int color) {
        return ContextCompat.getColor(this, color);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.logout_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        sharedPreferences = getSharedPreferences("myinfo",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Log.i("beforeClick",sharedPreferences.getString("UserId",""));
        editor.putString("UserId","");
        editor.commit();
        Log.i("afterClick",sharedPreferences.getString("UserId",""));
        Intent intent = new Intent(UserActivity.this, MainActivity.class);
        startActivity(intent);

        return super.onOptionsItemSelected(item);
    }
}
