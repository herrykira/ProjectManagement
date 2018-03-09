package com.example.tinku.projectmanagementsystem.fragment.fragmentsforfab;

import android.os.Bundle;
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
import com.example.tinku.projectmanagementsystem.model.CreateProjectResponse;
import com.example.tinku.projectmanagementsystem.network.RetrofitInstance;
import com.example.tinku.projectmanagementsystem.network.UserService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ryellap on 3/3/18.
 */

public class TabCreateProjects extends Fragment {
    Button create_project_button;
    EditText projectName_et;
    Spinner projectStatus_spinner;
    EditText description_et;
    EditText startDate_et;
    EditText endDate_et;
    ArrayAdapter adapter;
    String selectedItem;
    String status;

    //http://rjtmobile.com/aamir/pms/android-app/pms_create_project.php?project_name=ecomm&
    // project_status=1&project_desc=xyz&start_date=2018-04-03&end_date=2018-04-15

    public TabCreateProjects() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab_create_project, container, false);
        projectName_et = rootView.findViewById(R.id.projectName_et);
        description_et = rootView.findViewById(R.id.description_et);
        startDate_et = rootView.findViewById(R.id.startDate_et);
        endDate_et = rootView.findViewById(R.id.endDate_et);
        projectStatus_spinner = rootView.findViewById(R.id.projectId_spinner);
        adapter = new ArrayAdapter(getContext(), R.layout.support_simple_spinner_dropdown_item);
        adapter = ArrayAdapter.createFromResource(getContext(), R.array.projectStatus, android.R.layout.simple_dropdown_item_1line);

        projectStatus_spinner.setAdapter(adapter);
        projectStatus_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedItem = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });


        create_project_button = rootView.findViewById(R.id.create_project_button);

        create_project_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedItem.equals("Start new project")) {
                    status = 1 + "";
                }
                if (selectedItem.equals("Not complete")) {
                    status = 2 + "";
                }
                if (selectedItem.equals("Completed")) {
                    status = 3 + "";
                }
                String projectName = projectName_et.getText().toString();
                String description = description_et.getText().toString();
                String startDate = startDate_et.getText().toString();
                String endDate = endDate_et.getText().toString();
                UserService service = RetrofitInstance.getRetrofitInstance().create(UserService.class);
                Call<CreateProjectResponse> call = service.getCreateProjectResponse(projectName, status, description, startDate, endDate);
                call.enqueue(new Callback<CreateProjectResponse>() {
                    @Override
                    public void onResponse(Call<CreateProjectResponse> call, Response<CreateProjectResponse> response) {
                        Toast.makeText(getContext(), "" + response.body().toString(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<CreateProjectResponse> call, Throwable t) {

                    }
                });
            }
        });

        return rootView;
    }


}