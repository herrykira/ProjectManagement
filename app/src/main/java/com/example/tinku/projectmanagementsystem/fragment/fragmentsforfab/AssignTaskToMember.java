package com.example.tinku.projectmanagementsystem.fragment.fragmentsforfab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.tinku.projectmanagementsystem.R;

/**
 * Created by ryellap on 3/9/18.
 */

public class AssignTaskToMember extends Fragment {

    EditText taskID_et;
    Spinner projectID_spinner, team_member_spinner;
    Button create_user_btn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.assign_task_to_team_member, container, false);
        taskID_et = view.findViewById(R.id.TaskID_et);
        projectID_spinner = view.findViewById(R.id.projectID_spinner);
        team_member_spinner = view.findViewById(R.id.team_member_spinner);
        create_user_btn = view.findViewById(R.id.create_user_btn);
        return view;
    }

}
