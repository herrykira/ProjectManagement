package com.example.tinku.projectmanagementsystem.fragment.fragmentsforfab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.tinku.projectmanagementsystem.R;

/**
 * Created by ryellap on 3/9/18.
 */

public class AssignSubTaskToTeamMember extends Fragment {

    Spinner taskID_spinner, project_id_spinner, team_member_userid_spinner;
    TextView subtask_et;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.assign_subtask_to_team_member, container, false);
        taskID_spinner = view.findViewById(R.id.taskID_spinner);
        subtask_et = view.findViewById(R.id.subtask_et);
        project_id_spinner = view.findViewById(R.id.project_id_spinner);
        team_member_userid_spinner = view.findViewById(R.id.team_member_userid_spinner);
        return view;
    }

}
