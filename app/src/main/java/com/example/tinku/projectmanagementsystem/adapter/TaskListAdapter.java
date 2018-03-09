package com.example.tinku.projectmanagementsystem.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.tinku.projectmanagementsystem.R;
import com.example.tinku.projectmanagementsystem.fragment.UserFragmentSwitch;
import com.example.tinku.projectmanagementsystem.model.Task;

import java.util.List;

/**
 * Created by KinhangPoon on 5/3/2018.
 */

public class TaskListAdapter extends RecyclerView.Adapter<TaskListAdapter.TaskListViewHolder>{
    List<Task> tasks;
    Context context;
    UserFragmentSwitch userFragmentSwitch;

    /**
     * constructor
     * @param tasks
     * @param context
     */
    public TaskListAdapter(List<Task> tasks, Context context,UserFragmentSwitch userFragmentSwitch) {
        this.tasks = tasks;
        this.context = context;
        this.userFragmentSwitch = userFragmentSwitch;
    }

    @Override
    public TaskListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_list_item,parent,false);
        return new TaskListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TaskListViewHolder holder, int position) {
        /**
         * set contents for each item
         */
        Task task = tasks.get(position);
        final String taskId = task.getTaskid();
        final String projectId = task.getProjectid();
        holder.textViewTaskId.setText("Task id: "+taskId);
        holder.textViewSubtaskId.setText("SubTask id "+task.getSubtaskid());
        holder.textViewProjectId.setText("Project id: "+projectId);

        holder.textViewTaskId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userFragmentSwitch.switchToDetail(taskId,projectId);
            }
        });
        holder.textViewProjectId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userFragmentSwitch.switchToDetail(taskId,projectId);
            }
        });
        holder.textViewSubtaskId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userFragmentSwitch.switchToDetail(taskId,projectId);
            }
        });
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public class TaskListViewHolder extends RecyclerView.ViewHolder {
        /**
         * declaration
         */
        TextView textViewTaskId,textViewProjectId,textViewSubtaskId;
        public TaskListViewHolder(View itemView) {
            super(itemView);
            /**
             * initialization
             */
            textViewProjectId = itemView.findViewById(R.id.textView_project_id_taskList);
            textViewSubtaskId = itemView.findViewById(R.id.textView_subtask_id_taskList);
            textViewTaskId = itemView.findViewById(R.id.textView_task_id_taskList);
        }
    }
}
