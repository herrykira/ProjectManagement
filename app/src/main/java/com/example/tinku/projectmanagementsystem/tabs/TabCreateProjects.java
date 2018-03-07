package com.example.tinku.projectmanagementsystem.tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.tinku.projectmanagementsystem.R;

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
        projectStatus_spinner = rootView.findViewById(R.id.projectStatus_spinner);
        adapter = new ArrayAdapter(getContext(), R.layout.support_simple_spinner_dropdown_item);
        adapter = ArrayAdapter.createFromResource(getContext(), R.array.projectStatus, android.R.layout.simple_dropdown_item_1line);

        projectStatus_spinner.setAdapter(adapter);


        String FINAL_URL_CREATE_PROJECT = "http://rjtmobile.com/aamir/pms/android-app/pms_create_project.php?project_name=ecomm&project_status=1&project_desc=xyz&start_date=2018-04-03&end_date=2018-04-15";

        return rootView;
    }

}