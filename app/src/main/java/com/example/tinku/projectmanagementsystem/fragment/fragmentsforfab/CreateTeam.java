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
import android.widget.Spinner;
import android.widget.Toast;

import com.example.tinku.projectmanagementsystem.R;
import com.example.tinku.projectmanagementsystem.model.CreateTeamMemberResponse;
import com.example.tinku.projectmanagementsystem.network.RetrofitInstance;
import com.example.tinku.projectmanagementsystem.network.UserService;
import com.example.tinku.projectmanagementsystem.tabs.TabEmployeeList;
import com.example.tinku.projectmanagementsystem.tabs.TabProjects;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ryellap on 3/7/18.
 */

public class CreateTeam extends Fragment {
    Spinner spinner_TeammemberID, spinner_projectID;
    Button Create_team_btn;
    ArrayList<String> list;
    TabProjects tabProjects;
    TabEmployeeList tabEmployeeList;
    List<String> listOfEmployees;
    String employeeId, projectId;

    //http://rjtmobile.com/aamir/pms/android-app/pms_create_project_team.php?
    // project_id=27&
    // team_member_userid=14


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.createteam, container, false);
        spinner_TeammemberID = view.findViewById(R.id.spinner_TeammemberID);
        spinner_projectID = view.findViewById(R.id.spinner_projectID);

        list = (ArrayList) tabProjects.idOfProjects;
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, list);
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_projectID.setAdapter(myAdapter);
        spinner_projectID.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                projectId = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        listOfEmployees = tabEmployeeList.list;
        ArrayAdapter<String> myAdapterOfemployeeid = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, listOfEmployees);
        myAdapterOfemployeeid.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_TeammemberID.setAdapter(myAdapterOfemployeeid);
        spinner_TeammemberID.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                employeeId = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Create_team_btn = view.findViewById(R.id.Create_team_btn);
        Create_team_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                UserService service = RetrofitInstance.getRetrofitInstance().create(UserService.class);
                Call<CreateTeamMemberResponse> call = service.getCreateTeamMember(projectId, employeeId);
                call.enqueue(new Callback<CreateTeamMemberResponse>() {
                    @Override
                    public void onResponse(Call<CreateTeamMemberResponse> call, Response<CreateTeamMemberResponse> response) {
                        Toast.makeText(getContext(), "Created" + response.body().toString(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<CreateTeamMemberResponse> call, Throwable t) {

                    }
                });
            }
        });
        return view;
    }


}
