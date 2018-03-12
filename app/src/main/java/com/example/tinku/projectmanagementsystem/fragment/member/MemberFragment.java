package com.example.tinku.projectmanagementsystem.fragment.member;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.example.tinku.projectmanagementsystem.R;
import com.example.tinku.projectmanagementsystem.adapter.MemberExpandableListAdapter;

import java.util.List;
import java.util.Map;


/**
 * Created by KinhangPoon on 3/3/2018.
 */

public class MemberFragment extends Fragment implements MemberView {
    /**
     * declaration
     */
    TextView textViewMember;
    MemberPresenter memberPresenter;
    SharedPreferences sharedPreferences;
    ExpandableListView expandableListView;
    MemberExpandableListAdapter memberExpandableListAdapter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        memberPresenter = new MemberPresenterImpl(this);
        sharedPreferences = context.getSharedPreferences("myinfo",Context.MODE_PRIVATE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.member_fragment,container,false);
        /**
         * initialization
         */
        memberPresenter.createView(view);
        memberPresenter.sendMemberRequest(sharedPreferences);

        return view;
    }

    @Override
    public void updateView(View view) {
        textViewMember = view.findViewById(R.id.textView_member);
        expandableListView = view.findViewById(R.id.expandableListview_member);

    }

    @Override
    public void updateListView(final List<String> titles, final Map<String, List<String>> map) {
        memberExpandableListAdapter = new MemberExpandableListAdapter(getContext(),titles,map);
        expandableListView.setAdapter(memberExpandableListAdapter);
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                String userId = map.get(titles.get(groupPosition)).get(childPosition);
                memberPresenter.getMemberRequest(userId);
                return false;
            }
        });
    }

    @Override
    public void createDialog(String firstName, String lastName, String email, String mobile) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View myView = inflater.inflate(R.layout.dialog,null,false);
        TextView FirstName = myView.findViewById(R.id.textView_first);
        TextView LastName = myView.findViewById(R.id.textView_last);
        TextView Email = myView.findViewById(R.id.textView_email);
        TextView Mobile = myView.findViewById(R.id.textView_mobile);

        FirstName.setText("First Name: "+firstName);
        LastName.setText("Last Name: "+lastName);
        Email.setText("Email: "+email);
        Mobile.setText("Mobile: "+mobile);

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Member Information").setView(myView).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();

    }
}
