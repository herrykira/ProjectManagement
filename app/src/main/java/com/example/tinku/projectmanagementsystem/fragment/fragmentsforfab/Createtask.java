package com.example.tinku.projectmanagementsystem.fragment.fragmentsforfab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.tinku.projectmanagementsystem.R;
import com.example.tinku.projectmanagementsystem.model.CreateTaskResponse;
import com.example.tinku.projectmanagementsystem.network.RetrofitInstance;
import com.example.tinku.projectmanagementsystem.network.UserService;
import com.example.tinku.projectmanagementsystem.tabs.TabProjects;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ryellap on 3/7/18.
 */

public class Createtask extends Fragment {

    Spinner project_id_spinner;
    EditText taskName_et, taskStatus_et, Taskdescription_et, TaskstartDate_et, TaskendDate_et;
    Button create_task_btn;
    ArrayList<String> list;
    TabProjects tabProjects;
    String project_id;

    //http://rjtmobile.com/aamir/pms/android-app/pms_create_task.php?
    // project_id=27
    // &task_name=categoryscreen
    // &task_status=1
    // &task_desc=xyz
    // &start_date=2018-04-03
    // &end_date=2018-04-15

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.createtask, container, false);
        project_id_spinner = view.findViewById(R.id.project_id_spinner);
        list = (ArrayList) tabProjects.idOfProjects;
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, list);
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        project_id_spinner.setAdapter(myAdapter);
        project_id_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                project_id = adapterView.getItemAtPosition(i).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        taskName_et = view.findViewById(R.id.taskName_et);
        taskStatus_et = view.findViewById(R.id.taskStatus_et);
        Taskdescription_et = view.findViewById(R.id.Taskdescription_et);
        TaskstartDate_et = view.findViewById(R.id.TaskstartDate_et);
        TaskendDate_et = view.findViewById(R.id.TaskendDate_et);
        create_task_btn = view.findViewById(R.id.create_task_btn);
        create_task_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String taskName = taskName_et.getText().toString();
                String taskStatus = taskStatus_et.getText().toString();
                String taskDescription = Taskdescription_et.getText().toString();
                String taskStartDate = TaskstartDate_et.getText().toString();
                String taskEndDate = TaskendDate_et.getText().toString();
                if (taskName.length() <= 0 && taskStatus.length() <= 0 && taskDescription.length() <= 0 && taskStartDate.length() <= 0 && taskEndDate.length() <= 0) {
                    Toast.makeText(getContext(), "All fealds are mandatory", Toast.LENGTH_SHORT).show();
                } else {
                    UserService service = RetrofitInstance.getRetrofitInstance().create(UserService.class);
                    Call<CreateTaskResponse> call = service.getCreateTaskResponse(project_id, taskName, taskStatus, taskDescription, taskStartDate, taskEndDate);
                    call.enqueue(new Callback<CreateTaskResponse>() {
                        @Override
                        public void onResponse(Call<CreateTaskResponse> call, Response<CreateTaskResponse> response) {
                            Toast.makeText(getContext(), "response to create task" + response.body().toString(), Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<CreateTaskResponse> call, Throwable t) {

                        }
                    });
                }

            }
        });


        return view;

    }
}
