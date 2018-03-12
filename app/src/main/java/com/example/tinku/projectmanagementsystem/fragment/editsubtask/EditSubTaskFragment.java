package com.example.tinku.projectmanagementsystem.fragment.editsubtask;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
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
import com.example.tinku.projectmanagementsystem.model.SubTaskStatusResponse;
import com.example.tinku.projectmanagementsystem.network.RetrofitInstance;
import com.example.tinku.projectmanagementsystem.network.UserService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by KinhangPoon on 9/3/2018.
 */

public class EditSubTaskFragment extends Fragment implements EditSubTaskView {
    EditSubTaskPresenter editSubTaskPresenter;
    EditText editTextProjectId,editTextTaskId,editTextSubTaskId;
    Spinner spinnerProjectStatus;
    Button buttonEditSubTask;
    ArrayAdapter adapter;
    String selectedItem;
    String status;
    SharedPreferences sharedPreferences;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        sharedPreferences = context.getSharedPreferences("myinfo",Context.MODE_PRIVATE);
        editSubTaskPresenter = new EditSubTaskPresenterImpl(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.edit_subtask_fragment,container,false);
        editSubTaskPresenter.createView(view);
        return view;
    }

    @Override
    public void updateView(View view) {
        editTextProjectId = view.findViewById(R.id.editText_project_id_subtask);
        editTextTaskId = view.findViewById(R.id.editText_task_id_subtask);
        editTextSubTaskId = view.findViewById(R.id.editText_subtask_id_subtask);
        spinnerProjectStatus = view.findViewById(R.id.subtask_projectId_spinner);
        buttonEditSubTask = view.findViewById(R.id.button_edit_subtask);

        final List<String> statusList = new ArrayList<>();
        statusList.add("Start new project");
        statusList.add("Not complete");
        statusList.add("Completed");

        adapter = new ArrayAdapter(getContext(),R.layout.support_simple_spinner_dropdown_item,statusList);
        spinnerProjectStatus.setAdapter(adapter);
        spinnerProjectStatus.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedItem = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        buttonEditSubTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (selectedItem){
                    case "Start new project":
                        status = "1";
                    case "Not complete":
                        status = "2";
                    case "Completed":
                        status = "3";
                }
                String userid = sharedPreferences.getString("UserId","");
                String projectid = editTextProjectId.getText().toString();
                String taskid = editTextTaskId.getText().toString();
                String subtaskid = editTextSubTaskId.getText().toString();

                editSubTaskPresenter.updateStatus(userid,taskid,subtaskid,projectid,status);

            }
        });
    }

    @Override
    public void showToast(String s) {
        Toast.makeText(getContext(),s,Toast.LENGTH_LONG).show();
    }
}
