package com.example.tinku.projectmanagementsystem.fragment.taskList;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.tinku.projectmanagementsystem.R;
import com.example.tinku.projectmanagementsystem.adapter.TaskExpandableListAdapter;
import com.example.tinku.projectmanagementsystem.fragment.UserFragmentSwitch;
import com.example.tinku.projectmanagementsystem.model.SubTaskDetailResponse;

import java.util.List;
import java.util.Map;

/**
 * Created by KinhangPoon on 3/3/2018.
 */

public class TaskListFragment extends Fragment implements TaskListView {
//    TextView textViewTaskList;
//    RecyclerView recyclerViewTaskList;
    UserFragmentSwitch userFragmentSwitch;
//    TaskListAdapter taskListAdapter;
    SharedPreferences sharedPreferences;
    TaskListPresenter taskListPresenter;
    ExpandableListView expandableListView;
    TaskExpandableListAdapter taskExpandableListAdapter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        userFragmentSwitch = (UserFragmentSwitch) getActivity();
        sharedPreferences = context.getSharedPreferences("myinfo",Context.MODE_PRIVATE);
        taskListPresenter = new TaskListPresenterImpl(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tasklist_fragment,container,false);

        taskListPresenter.createView(view);
        return view;
    }

    @Override
    public void updateView(View view) {

        expandableListView = view.findViewById(R.id.expandableListview_task);

        taskListPresenter.sendTaskListRequest(sharedPreferences);
    }

    @Override
    public void showTaskList(final List<String> taskTitles, final Map<String, List<SubTaskDetailResponse>> taskMap) {

        taskExpandableListAdapter = new TaskExpandableListAdapter(getContext(),taskTitles,taskMap);
        expandableListView.setAdapter(taskExpandableListAdapter);
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(getContext(),"startdate: "+taskMap.get(taskTitles.get(groupPosition)).get(childPosition).getStartdate()
                        +"\n enddate: "+taskMap.get(taskTitles.get(groupPosition)).get(childPosition).getEndstart(),Toast.LENGTH_LONG).show();
                LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View myView = inflater.inflate(R.layout.task_dialog,null,false);
                TextView textViewSubTaskId = myView.findViewById(R.id.textView_subtask_id);
                TextView textViewTaskId = myView.findViewById(R.id.textView_task_id);
                TextView textViewProjectId = myView.findViewById(R.id.textView_project_id);
                TextView textViewSubTaskStatus = myView.findViewById(R.id.textView_subtask_status);
                TextView textViewSubTaskDesc = myView.findViewById(R.id.textView_subtask_des);
                TextView textViewstartdate = myView.findViewById(R.id.textView_subtask_startdate);
                TextView textViewendstart = myView.findViewById(R.id.textView_subtask_endstart);

                SubTaskDetailResponse subTaskDetailResponse = taskMap.get(taskTitles.get(groupPosition)).get(childPosition);
                textViewProjectId.setText("Project Id: "+subTaskDetailResponse.getProjectid());
                textViewendstart.setText("End Date: "+subTaskDetailResponse.getEndstart());
                textViewSubTaskId.setText("SubTask Id: "+subTaskDetailResponse.getSubtaskid());
                textViewTaskId.setText("Task Id: "+subTaskDetailResponse.getTaskid());
                textViewSubTaskStatus.setText("SubTask Status: "+subTaskDetailResponse.getSubtaskstatus());
                textViewSubTaskDesc.setText("SubTask Description: "+subTaskDetailResponse.getSubtaskdesc());
                textViewstartdate.setText("Start Date: "+subTaskDetailResponse.getStartdate());

                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Task Information").setView(myView).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.show();

                return false;
            }
        });
    }
}
