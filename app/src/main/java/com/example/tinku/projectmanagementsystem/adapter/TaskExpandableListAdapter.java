package com.example.tinku.projectmanagementsystem.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.tinku.projectmanagementsystem.R;
import com.example.tinku.projectmanagementsystem.model.SubTaskDetailResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by KinhangPoon on 7/3/2018.
 */

public class TaskExpandableListAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<String> taskTitles;
    private Map<String,List<SubTaskDetailResponse>> listDatachild;

    public TaskExpandableListAdapter(Context context, List<String> taskTitles, Map<String, List<SubTaskDetailResponse>> listDatachild) {
        this.context = context;
        this.taskTitles = taskTitles;
        this.listDatachild = listDatachild;
    }

    @Override
    public int getGroupCount() {
        return this.taskTitles.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.listDatachild.get(this.taskTitles.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.taskTitles.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.listDatachild.get(this.taskTitles.get(groupPosition)).get(childPosition).getSubtaskname();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.task_list_group,null);
        }
        TextView textViewTaskTitles = convertView.findViewById(R.id.textView_task_title);
        textViewTaskTitles.setText(headerTitle);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String childText = (String) getChild(groupPosition,childPosition);

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.subtask_item,null);
        }
        TextView child = convertView.findViewById(R.id.textView_subtask_item);
        child.setText(childText);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
