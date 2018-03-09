package com.example.tinku.projectmanagementsystem.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tinku.projectmanagementsystem.R;
import com.example.tinku.projectmanagementsystem.model.ProjectsItem;

import java.util.List;

/**
 * Created by ryellap on 3/7/18.
 */

public class ProjectListAdapter extends RecyclerView.Adapter<ProjectListAdapter.ViewHolder> {
    Context context;
    List<ProjectsItem> projectsItems;


    public ProjectListAdapter(Context context, List<ProjectsItem> projectsItems) {
        this.context = context;
        this.projectsItems = projectsItems;
    }

    @Override
    public ProjectListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemprojectlist, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProjectListAdapter.ViewHolder holder, int position) {
        ProjectsItem projectsItem = projectsItems.get(position);
        String id = projectsItem.getId();
        final String project_name = projectsItem.getProjectname();
        String projectstartdate = projectsItem.getStartdate();
        String projectEnddate = projectsItem.getEndstart();
        String projectDescription = projectsItem.getProjectdesc();
        String projectStatus = projectsItem.getProjectstatus();
        holder.project_id.setText(id.toString());
        holder.project_name.setText(project_name.toString());
        holder.project_description.setText(projectDescription.toString());
        holder.project_end_date.setText(projectEnddate.toString());
        holder.project_start_date.setText(projectstartdate.toString());
        holder.project_status.setText(projectStatus.toString());
        holder.project_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(context, "This is the name of project" + project_name, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return projectsItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView project_id, project_name, project_start_date, project_end_date, project_description, project_status;

        public ViewHolder(View itemView) {
            super(itemView);
            project_id = itemView.findViewById(R.id.project_id);
            project_name = itemView.findViewById(R.id.project_name);
            project_start_date = itemView.findViewById(R.id.project_start_date);
            project_end_date = itemView.findViewById(R.id.project_end_date);
            project_description = itemView.findViewById(R.id.project_description);
            project_status = itemView.findViewById(R.id.project_status);


        }
    }
}
