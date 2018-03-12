package com.example.tinku.projectmanagementsystem.fragment.edittask;

import android.content.Context;
import android.content.SharedPreferences;
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
import com.example.tinku.projectmanagementsystem.fragment.editsubtask.EditSubTaskPresenter;
import com.example.tinku.projectmanagementsystem.fragment.editsubtask.EditSubTaskPresenterImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KinhangPoon on 9/3/2018.
 */

public class EditTaskFragment extends Fragment implements EditTaskView {
    EditTaskPresenter editTaskPresenter;
    EditText editTextProjectId,editTextTaskId;
    Spinner spinnerProjectStatus;
    Button buttonEditTask;
    ArrayAdapter adapter;
    String selectedItem;
    String status;
    SharedPreferences sharedPreferences;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        sharedPreferences = context.getSharedPreferences("myinfo",Context.MODE_PRIVATE);
        editTaskPresenter = new EditTaskPresenterImpl(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.edit_task_fragment,container,false);
        editTaskPresenter.createView(view);
        return view;
    }

    @Override
    public void updateView(View view) {
        editTextProjectId = view.findViewById(R.id.editText_project_id_task);
        editTextTaskId = view.findViewById(R.id.editText_task_id_task);
        spinnerProjectStatus = view.findViewById(R.id.task_projectId_spinner);
        buttonEditTask = view.findViewById(R.id.button_edit_task);

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

        buttonEditTask.setOnClickListener(new View.OnClickListener() {
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

                editTaskPresenter.updateStatus(userid,taskid,projectid,status);

            }
        });
    }

    @Override
    public void showToast(String s) {
        Toast.makeText(getContext(),s,Toast.LENGTH_LONG).show();
    }
}
