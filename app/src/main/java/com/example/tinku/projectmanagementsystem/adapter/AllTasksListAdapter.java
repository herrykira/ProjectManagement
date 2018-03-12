package com.example.tinku.projectmanagementsystem.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tinku.projectmanagementsystem.R;
import com.example.tinku.projectmanagementsystem.model.ProjectTaskItem;

import java.util.List;

/**
 * Created by ryellap on 3/11/18.
 */

public class AllTasksListAdapter extends RecyclerView.Adapter<AllTasksListAdapter.ViewHolder> {
    List<ProjectTaskItem> projectTaskItems;
    Context context;

    public AllTasksListAdapter(List<ProjectTaskItem> projectTaskItems, Context context) {
        this.projectTaskItems = projectTaskItems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_all_tasks_list, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ProjectTaskItem projectTaskItem = projectTaskItems.get(position);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        holder.TaskName_tv_tasklist.setText(projectTaskItem.getTaskname());
        holder.taskID_tasklist.setText(projectTaskItem.getTaskid());
        holder.projectID_TaskList.setText(projectTaskItem.getProjectid());
        holder.end_date_tasklist.setText(projectTaskItem.getEndstart());
        holder.startdate_tasklist.setText(projectTaskItem.getStartdate());
        int projectstatus = Integer.parseInt(projectTaskItem.getTaskstatus());
        if (projectstatus == 1) {
            holder.task_status_tasklist.setText("Start New Project");
        }
        if (projectstatus == 2) {
            holder.task_status_tasklist.setText("Not Completed");
        }
        if (projectstatus == 3) {
            holder.task_status_tasklist.setText("Completed");
        }
    
        holder.task_description_tasklist.setText(projectTaskItem.getTaskdesc());

    }

    @Override
    public int getItemCount() {
        return projectTaskItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView TaskName_tv_tasklist, taskID_tasklist, projectID_TaskList, task_status_tasklist, task_description_tasklist, startdate_tasklist, end_date_tasklist;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardViewOfTasList);
            TaskName_tv_tasklist = itemView.findViewById(R.id.TaskName_tv_tasklist);
            taskID_tasklist = itemView.findViewById(R.id.taskID_tasklist);
            projectID_TaskList = itemView.findViewById(R.id.projectID_TaskList);
            task_status_tasklist = itemView.findViewById(R.id.task_status_tasklist);
            task_description_tasklist = itemView.findViewById(R.id.task_description_tasklist);
            startdate_tasklist = itemView.findViewById(R.id.startdate_tasklist);
            end_date_tasklist = itemView.findViewById(R.id.end_date_tasklist);
        }
    }
}
