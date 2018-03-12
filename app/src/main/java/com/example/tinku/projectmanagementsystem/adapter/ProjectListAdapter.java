package com.example.tinku.projectmanagementsystem.adapter;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tinku.projectmanagementsystem.R;
import com.example.tinku.projectmanagementsystem.fragment.fragmentsforfab.EditProject;
import com.example.tinku.projectmanagementsystem.model.ProjectsItem;
import com.example.tinku.projectmanagementsystem.ui.AdminActivity;

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
        final String id = projectsItem.getId();
        final String project_name = projectsItem.getProjectname();
        final String projectstartdate = projectsItem.getStartdate();
        final String projectEnddate = projectsItem.getEndstart();
        final String projectDescription = projectsItem.getProjectdesc();
        final String projectStatus = projectsItem.getProjectstatus();
        int projectstatus = Integer.parseInt(projectStatus);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new EditProject();
                Bundle bundle = new Bundle();
                bundle.putString("ID", id); // passsing the ID of particular item for Particular item
                bundle.putString("psd", projectstartdate);
                bundle.putString("ped", projectEnddate);
                bundle.putString("name", project_name);
                bundle.putString("pd", projectDescription);
                bundle.putString("status", projectStatus);
                fragment.setArguments(bundle);
                FragmentManager fm = ((AdminActivity) context).getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.addToBackStack("");
                ft.replace(R.id.container_viewpager, fragment);
                ft.commit();

            }
        });
        holder.project_id.setText(id.toString());
        holder.project_name.setText(project_name.toString());
        holder.project_description.setText(projectDescription.toString());
        holder.project_end_date.setText(projectEnddate.toString());
        holder.project_start_date.setText(projectstartdate.toString());
        if (projectstatus == 1) {
            holder.project_status.setText("Start New Project");
            if (projectstatus == 2) {
                holder.project_status.setText("Not Completed");
                if (projectstatus == 3) {
                    holder.project_status.setText("Completed");

                }
            }
        }
    }

    @Override
    public int getItemCount() {
        return projectsItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView project_id, project_name, project_start_date, project_end_date, project_description, project_status;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            project_id = itemView.findViewById(R.id.project_id);
            project_name = itemView.findViewById(R.id.project_name);
            project_start_date = itemView.findViewById(R.id.project_start_date);
            project_end_date = itemView.findViewById(R.id.project_end_date);
            project_description = itemView.findViewById(R.id.project_description);
            project_status = itemView.findViewById(R.id.project_status);
            cardView = itemView.findViewById(R.id.cardViewOfProjectsList);


        }
    }
}
