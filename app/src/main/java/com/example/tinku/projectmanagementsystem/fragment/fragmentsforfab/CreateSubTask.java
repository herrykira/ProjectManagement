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
import com.example.tinku.projectmanagementsystem.model.CreateSubTaskResponse;
import com.example.tinku.projectmanagementsystem.network.RetrofitInstance;
import com.example.tinku.projectmanagementsystem.network.UserService;
import com.example.tinku.projectmanagementsystem.tabs.TabAllTasks;
import com.example.tinku.projectmanagementsystem.tabs.TabProjects;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ryellap on 3/7/18.
 */

public class CreateSubTask extends Fragment {


    EditText sub_task_name_et, subtaskStatus_et, subtaskdescription_et, subtaskstartDate_et, subaskendDate_et, subtask_id_et;
    Button create_subtask_btn;
    Spinner project_id_spinner, task_id_spinner;
    ArrayList<String> list;
    List<String> listOfTasksId;
    TabProjects tabProjects;
    TabAllTasks tabAllTasks;
    String selectedTaskId;
    String selectedProjectId;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.createsubtask, container, false);

        project_id_spinner = view.findViewById(R.id.project_id_et);
        list = (ArrayList) tabProjects.idOfProjects;
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, list);
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        project_id_spinner.setAdapter(myAdapter);
        task_id_spinner = view.findViewById(R.id.task_id_et);
        listOfTasksId = tabAllTasks.idOfTasks;
        project_id_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedProjectId = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        ArrayAdapter<String> myAdapterOfTaskIds = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, listOfTasksId);
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        task_id_spinner.setAdapter(myAdapterOfTaskIds);
        task_id_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                selectedTaskId = adapterView.getItemAtPosition(i).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        subtask_id_et = view.findViewById(R.id.subtask_id_et);

        sub_task_name_et = view.findViewById(R.id.sub_task_name_et);
        subtaskStatus_et = view.findViewById(R.id.subtaskStatus_et);
        subtaskdescription_et = view.findViewById(R.id.subtaskdescription_et);
        subtaskstartDate_et = view.findViewById(R.id.subtaskstartDate_et);
        subaskendDate_et = view.findViewById(R.id.subaskendDate_et);
        create_subtask_btn = view.findViewById(R.id.create_subtask_btn);

        create_subtask_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String taskId = subtask_id_et.getText().toString();
                try {
                    int taskid = Integer.parseInt(taskId);
                } catch (NumberFormatException e) {
                    Toast.makeText(getContext(), "Task Id should be integer", Toast.LENGTH_SHORT).show();
                }
                String subTaskName = sub_task_name_et.getText().toString();
                String subtaskStatus = subtaskStatus_et.getText().toString();
                String subTaskDescription = subtaskdescription_et.getText().toString();
                String subTaskStartDate = subtaskstartDate_et.getText().toString();
                String subTaskEndDate = subaskendDate_et.getText().toString();
                if (subTaskDescription.length() <= 10 && subTaskName.length() <= 0 && subtaskStatus.length() <= 0 && subTaskEndDate.length() <= 0 && subTaskStartDate.length() <= 0) {
                    Toast.makeText(getContext(), "Oops Something went wrong please try again", Toast.LENGTH_SHORT).show();
                } else {
                    UserService service = RetrofitInstance.getRetrofitInstance().create(UserService.class);
                    Call<CreateSubTaskResponse> call = service.getCreateSubTaskResponse(selectedProjectId, taskId, subTaskName, subtaskStatus, subTaskDescription, subTaskStartDate, subTaskEndDate);
                    call.enqueue(new Callback<CreateSubTaskResponse>() {
                        @Override
                        public void onResponse(Call<CreateSubTaskResponse> call, Response<CreateSubTaskResponse> response) {
                            Toast.makeText(getContext(), "" + response.body().toString(), Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<CreateSubTaskResponse> call, Throwable t) {

                        }
                    });
                }
            }
        });

        return view;
    }


}
