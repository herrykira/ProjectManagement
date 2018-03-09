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
import com.example.tinku.projectmanagementsystem.model.EditProjectResponse;
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

public class EditProjects extends Fragment {

    EditText projectName_et, description_et, startDate_et, endDate_et, projectStatus_et;
    Spinner projectId_spinner;
    Button edit_project_button;
    TabProjects tabProjects;
    ArrayList list;
    String projectId;


    //http://rjtmobile.com/aamir/pms/android-app/pms_edit_project.php?
    // project_id=27&
    // project_name=e-commerce&
    // project_status=1
    // &project_desc=xyzss&
    // start_date=2018-04-05&
    // end_end=2018-04-15

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.editproject, container, false);
        projectId_spinner = view.findViewById(R.id.projectId_spinner);
        list = (ArrayList) tabProjects.idOfProjects;
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, list);
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        projectId_spinner.setAdapter(myAdapter);
        projectId_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                projectId = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        projectName_et = view.findViewById(R.id.projectName_et);
        description_et = view.findViewById(R.id.description_et);
        startDate_et = view.findViewById(R.id.startDate_et);
        endDate_et = view.findViewById(R.id.endDate_et);
        edit_project_button = view.findViewById(R.id.edit_project_button);
        projectStatus_et = view.findViewById(R.id.projectStatus_et);

        edit_project_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String projectName = projectName_et.getText().toString();
                String description = description_et.getText().toString();
                String startDate = startDate_et.getText().toString();
                String endDate = endDate_et.getText().toString();
                String projectStatus = projectStatus_et.getText().toString();

                UserService service = RetrofitInstance.getRetrofitInstance().create(UserService.class);
                Call<EditProjectResponse> call = service.getEditProjectResponse(projectId, projectName, projectStatus, description, startDate, endDate);
                call.enqueue(new Callback<EditProjectResponse>() {
                    @Override
                    public void onResponse(Call<EditProjectResponse> call, Response<EditProjectResponse> response) {
                        Toast.makeText(getContext(), "" + response.body().toString(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<EditProjectResponse> call, Throwable t) {

                    }
                });
            }
        });
        return view;
    }

}
