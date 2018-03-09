package com.example.tinku.projectmanagementsystem.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.tinku.projectmanagementsystem.R;
import com.example.tinku.projectmanagementsystem.model.MemberDetailResponse;
import com.example.tinku.projectmanagementsystem.model.SubTaskDetailResponse;
import com.example.tinku.projectmanagementsystem.network.RetrofitInstance;
import com.example.tinku.projectmanagementsystem.network.UserService;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by KinhangPoon on 8/3/2018.
 */

public class MemberExpandableListAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<String> taskTitles;
    private Map<String,List<String>> listDatachild;

    public MemberExpandableListAdapter(Context context, List<String> taskTitles, Map<String, List<String>> listDatachild) {
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
        return this.listDatachild.get(this.taskTitles.get(groupPosition)).get(childPosition);
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
            convertView = inflater.inflate(R.layout.member_task_list,null);
        }
        TextView textViewTaskTitles = convertView.findViewById(R.id.textView_member_task_title);
        textViewTaskTitles.setText("Task: "+headerTitle);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String childId = (String) getChild(groupPosition,childPosition);

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.member_name,null);
        }
        final TextView child = convertView.findViewById(R.id.textView_member_name);
        UserService userService = RetrofitInstance.getRetrofitInstance().create(UserService.class);
        Call<MemberDetailResponse> call = userService.getMemberDetail(childId);
        call.enqueue(new Callback<MemberDetailResponse>() {
            @Override
            public void onResponse(Call<MemberDetailResponse> call, Response<MemberDetailResponse> response) {
                Log.i("memberDetail",response.body().getUserfirstname());
                String name = response.body().getUserfirstname()+" "+response.body().getUserlastname();
                child.setText(name);
            }

            @Override
            public void onFailure(Call<MemberDetailResponse> call, Throwable t) {

            }
        });

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
