package com.example.tinku.projectmanagementsystem.fragment.taskDetail;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.tinku.projectmanagementsystem.R;
import com.example.tinku.projectmanagementsystem.model.DetailResponse;
import com.example.tinku.projectmanagementsystem.network.RetrofitInstance;
import com.example.tinku.projectmanagementsystem.network.UserService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by KinhangPoon on 4/3/2018.
 */

public class TaskDetailFragment extends Fragment implements TaskDetailView {
    /**
     * declaration
     */
    TaskDetailPresenter taskDetailPresenter;
    TextView textViewDetailTaskId,textViewDetailProjectId,textViewDetailTaskName;
    TextView textViewDetailTaskStatus,textViewDetailTaskDesc,textViewDetailStartDate,textViewDetailEndStart;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        taskDetailPresenter = new TaskDetailPresenterImpl(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.task_detail_fragment,container,false);
        taskDetailPresenter.createView(view);
        return view;
    }

    @Override
    public void updateView(View view) {
        /**
         * initialization
         */
        textViewDetailTaskId = view.findViewById(R.id.textView_detail_taskid);
        textViewDetailProjectId = view.findViewById(R.id.textView_detail_projectid);
        textViewDetailTaskName = view.findViewById(R.id.textView_detail_taskname);
        textViewDetailTaskStatus = view.findViewById(R.id.textView_detail_taskstatus);
        textViewDetailTaskDesc = view.findViewById(R.id.textView_detail_taskdesc);
        textViewDetailStartDate = view.findViewById(R.id.textView_detail_startdate);
        textViewDetailEndStart = view.findViewById(R.id.textView_detail_endstart);


        /**
         * get parameter from bundle
         */
        String taskId = getArguments().getString("taskId");
        String productId = getArguments().getString("productId");

        /**
         * /**
         * use retrofit authenticate and interacte with APIs and sending network requests with OkHttp
         */
        taskDetailPresenter.sendDetailRequest(taskId,productId);


    }

    @Override
    public void setText(Response<DetailResponse> response) {
        textViewDetailTaskId.setText("TaskId: "+response.body().getTaskid());
        textViewDetailEndStart.setText("EndDate: "+response.body().getEndstart());
        textViewDetailProjectId.setText("ProjectId: "+response.body().getProjectid());
        textViewDetailStartDate.setText("StartDate: "+response.body().getStartdate());
        textViewDetailTaskDesc.setText("Task Description: "+response.body().getTaskdesc());
        textViewDetailTaskName.setText("Task Name: "+response.body().getTaskname());
        String taskStatus = getStatus(response.body().getTaskstatus());
        textViewDetailTaskStatus.setText("Task Status: "+taskStatus);
    }
    public String getStatus(String s){
        switch (s){
            case "1":
                return "Start new project";
            case "2":
                return "Not complete";
            default:
                return "Completed";
        }
    }
}
