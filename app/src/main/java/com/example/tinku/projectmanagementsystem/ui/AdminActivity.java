package com.example.tinku.projectmanagementsystem.ui;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.tinku.projectmanagementsystem.R;
import com.example.tinku.projectmanagementsystem.tabs.TabAllTasks;
import com.example.tinku.projectmanagementsystem.tabs.TabCreateProjects;
import com.example.tinku.projectmanagementsystem.tabs.TabCreateUsers;
import com.example.tinku.projectmanagementsystem.tabs.TabEmployeeList;
import com.example.tinku.projectmanagementsystem.tabs.TabProjects;

public class AdminActivity extends AppCompatActivity {
    private AdminActivity.SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);


        mSectionsPagerAdapter = new AdminActivity.SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);

        mViewPager.setAdapter(mSectionsPagerAdapter);

        final TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);



        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
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
                    TabCreateProjects tabTeams = new TabCreateProjects();
                    return tabTeams;
                case 2:
                    TabEmployeeList tabReports = new TabEmployeeList();
                    return tabReports;
                case 3:
                    TabAllTasks tabPriority = new TabAllTasks();
                    return tabPriority;
                case 4:
                    TabCreateUsers tabCreateUsers = new TabCreateUsers();
                    return tabCreateUsers;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            // Show 4 total pages.
            return 5;
        }


    }
}