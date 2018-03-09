package com.example.tinku.projectmanagementsystem.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tinku.projectmanagementsystem.R;
import com.example.tinku.projectmanagementsystem.fragment.fragmentsforfab.ActivityForFloatingActionBar;
import com.example.tinku.projectmanagementsystem.tabs.TabAllTasks;
import com.example.tinku.projectmanagementsystem.tabs.TabEmployeeList;
import com.example.tinku.projectmanagementsystem.tabs.TabProjects;

public class AdminActivity extends AppCompatActivity {
    public FloatingActionButton fab, assign_task_member, assign_subtask_member, fab_create_project, fab_create_task, fab_create_subtask, fab_create_team, fab_edit_project, fab_create_user;
    Animation FabOpen, FabClockwise, FabAntiClockWise, FabClose;
    boolean isOpen = false;
    TextView create_project_tv, assign_task_member_tv, assign_subtask_member_tv, create_task_tv, create_sub_task_tv, create_team_tv, edit_team_tv, create_user_tv;
    TabLayout tabLayout;
    private AdminActivity.SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);


        mSectionsPagerAdapter = new AdminActivity.SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container_viewpager);

        mViewPager.setAdapter(mSectionsPagerAdapter);

        tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));
        fab_create_project = findViewById(R.id.fab_create_project);
        fab_create_task = findViewById(R.id.fab_create_task);
        fab_create_subtask = findViewById(R.id.fab_create_subtask);
        fab_create_team = findViewById(R.id.fab_create_team);
        fab_edit_project = findViewById(R.id.fab_edit_project);
        fab_create_user = findViewById(R.id.create_user);
        assign_task_member = findViewById(R.id.assign_task_member);
        assign_subtask_member = findViewById(R.id.assign_subtask_member);
        create_user_tv = findViewById(R.id.create_user_tv);
        create_project_tv = findViewById(R.id.create_project_tv);
        create_task_tv = findViewById(R.id.create_task_tv);
        create_sub_task_tv = findViewById(R.id.create_sub_task_tv);
        create_team_tv = findViewById(R.id.create_team_tv);
        edit_team_tv = findViewById(R.id.edit_team_tv);
        assign_task_member_tv = findViewById(R.id.assign_task_member_tv);
        assign_subtask_member_tv = findViewById(R.id.assign_subtask_member_tv);


        FabOpen = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        FabClose = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);
        FabClockwise = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_clockwise);
        FabAntiClockWise = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_anticlockwise);

        fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isOpen) {
                    fab.startAnimation(FabAntiClockWise);
                    fab_create_project.startAnimation(FabClose);
                    fab_create_task.startAnimation(FabClose);
                    fab_create_subtask.startAnimation(FabClose);
                    fab_create_team.startAnimation(FabClose);
                    fab_edit_project.startAnimation(FabClose);
                    fab_create_user.startAnimation(FabClose);
                    assign_task_member.startAnimation(FabClose);
                    assign_subtask_member.startAnimation(FabClose);
                    create_user_tv.startAnimation(FabClose);
                    create_project_tv.startAnimation(FabClose);
                    create_task_tv.startAnimation(FabClose);
                    create_sub_task_tv.startAnimation(FabClose);
                    create_team_tv.startAnimation(FabClose);
                    assign_task_member_tv.startAnimation(FabClose);
                    edit_team_tv.startAnimation(FabClose);
                    assign_subtask_member_tv.startAnimation(FabClose);
                    fab_create_user.setClickable(false);
                    fab_create_project.setClickable(false);
                    fab_create_task.setClickable(false);
                    fab_create_subtask.setClickable(false);
                    fab_create_team.setClickable(false);
                    fab_edit_project.setClickable(false);
                    assign_subtask_member.setClickable(false);
                    isOpen = false;

                } else {
                    fab.startAnimation(FabClockwise);
                    fab_create_project.startAnimation(FabOpen);
                    fab_create_task.startAnimation(FabOpen);
                    fab_create_subtask.startAnimation(FabOpen);
                    fab_create_team.startAnimation(FabOpen);
                    fab_edit_project.startAnimation(FabOpen);
                    fab_create_user.startAnimation(FabOpen);
                    assign_task_member.startAnimation(FabOpen);
                    assign_subtask_member.startAnimation(FabOpen);
                    assign_task_member_tv.startAnimation(FabOpen);
                    assign_subtask_member_tv.startAnimation(FabOpen);
                    create_project_tv.startAnimation(FabOpen);
                    create_task_tv.startAnimation(FabOpen);
                    create_sub_task_tv.startAnimation(FabOpen);
                    create_team_tv.startAnimation(FabOpen);
                    create_user_tv.startAnimation(FabOpen);
                    edit_team_tv.startAnimation(FabOpen);
                    fab_create_project.setClickable(true);
                    fab_create_task.setClickable(true);
                    fab_create_subtask.setClickable(true);
                    fab_create_team.setClickable(true);
                    fab_edit_project.setClickable(true);
                    fab_create_user.setClickable(true);
                    assign_subtask_member.setClickable(true);
                    isOpen = true;
                }
            }
        });

        fab_create_project.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AdminActivity.this, ActivityForFloatingActionBar.class);
                Bundle bundle = new Bundle();
                bundle.putInt("data", 1);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        fab_create_task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AdminActivity.this, ActivityForFloatingActionBar.class);
                Bundle bundle = new Bundle();
                bundle.putInt("data", 2);
                i.putExtras(bundle);
                startActivity(i);

            }
        });

        fab_create_subtask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AdminActivity.this, ActivityForFloatingActionBar.class);
                Bundle bundle = new Bundle();
                bundle.putInt("data", 3);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        fab_create_team.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AdminActivity.this, ActivityForFloatingActionBar.class);
                Bundle bundle = new Bundle();
                bundle.putInt("data", 4);
                i.putExtras(bundle);
                startActivity(i);

            }
        });

        fab_edit_project.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AdminActivity.this, ActivityForFloatingActionBar.class);
                Bundle bundle = new Bundle();
                bundle.putInt("data", 5);
                i.putExtras(bundle);
                startActivity(i);

            }
        });
        fab_create_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AdminActivity.this, ActivityForFloatingActionBar.class);
                Bundle bundle = new Bundle();
                bundle.putInt("data", 6);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        assign_task_member.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AdminActivity.this, "clicked", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(AdminActivity.this, ActivityForFloatingActionBar.class);
                Bundle bundle = new Bundle();
                bundle.putInt("data", 7);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        assign_subtask_member.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AdminActivity.this, "clicked", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(AdminActivity.this, ActivityForFloatingActionBar.class);
                Bundle bundle = new Bundle();
                bundle.putInt("data", 8);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        tabLayout.setVisibility(View.VISIBLE);
        super.onResume();
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.

            switch (position) {
                case 0:
                    TabProjects tabProjects = new TabProjects();
                    return tabProjects;
                case 1:
                    TabEmployeeList employeeList = new TabEmployeeList();
                    return employeeList;
                case 2:
                    TabAllTasks allTasks = new TabAllTasks();
                    return allTasks;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

    }
}