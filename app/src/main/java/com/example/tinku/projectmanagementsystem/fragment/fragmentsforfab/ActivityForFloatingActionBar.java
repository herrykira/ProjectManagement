package com.example.tinku.projectmanagementsystem.fragment.fragmentsforfab;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.tinku.projectmanagementsystem.*;

import com.example.tinku.projectmanagementsystem.fragment.editsubtask.EditSubTaskFragment;
import com.example.tinku.projectmanagementsystem.fragment.edittask.EditTaskFragment;

public class ActivityForFloatingActionBar extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_floating_action_bar);

        int value = getIntent().getExtras().getInt("data");

        if (value == 1) {
            //create projects
            getSupportFragmentManager().beginTransaction().replace(R.id.container_for_fab, new TabCreateProjects()).commit();
        } else if (value == 2) {
            //create Task
            getSupportFragmentManager().beginTransaction().replace(R.id.container_for_fab, new Createtask()).commit();
        } else if (value == 3) {
            // create SubTask
            getSupportFragmentManager().beginTransaction().replace(R.id.container_for_fab, new CreateSubTask()).commit();
        } else if (value == 4) {
            //create_team
            getSupportFragmentManager().beginTransaction().replace(R.id.container_for_fab, new CreateTeam()).commit();
        } else if (value == 5) {
            //edit_project
            getSupportFragmentManager().beginTransaction().replace(R.id.container_for_fab, new EditProjects()).commit();
        } else if (value == 6) {
            //create User
            getSupportFragmentManager().beginTransaction().replace(R.id.container_for_fab, new TabCreateUsers()).commit();
        }else if(value == 9){
            //Edit subTask status
            getSupportFragmentManager().beginTransaction().replace(R.id.container_for_fab, new EditSubTaskFragment()).commit();
        }
        else if(value ==10){
            //Edit Task status
            getSupportFragmentManager().beginTransaction().replace(R.id.container_for_fab,new EditTaskFragment()).commit();
        }
    }
}
