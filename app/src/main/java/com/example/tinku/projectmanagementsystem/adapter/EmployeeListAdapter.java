package com.example.tinku.projectmanagementsystem.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tinku.projectmanagementsystem.R;
import com.example.tinku.projectmanagementsystem.model.EmployeesItem;

import java.util.List;

/**
 * Created by ryellap on 3/7/18.
 */

public class EmployeeListAdapter extends RecyclerView.Adapter<EmployeeListAdapter.ViewHolder> {

    List<EmployeesItem> employeesItems;
    Context context;

    public EmployeeListAdapter(List<EmployeesItem> employeesItems, Context context) {
        this.employeesItems = employeesItems;
        this.context = context;
    }

    @Override
    public EmployeeListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itememployeelist, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EmployeeListAdapter.ViewHolder holder, int position) {
        EmployeesItem employeesItem = employeesItems.get(position);
        String designation = employeesItem.getEmpdesignation();
        String id = employeesItem.getEmpid();
        String firstname = employeesItem.getEmpfirstname();
        String lastname = employeesItem.getEmplastname();
        String email = employeesItem.getEmpemail();
        String mobilenumber = employeesItem.getEmpmobile();
        String dateOfJoining = employeesItem.getDateofjoining();
        holder.employee_dateOfJoining.setText(dateOfJoining.toString());
        holder.employee_designation.setText(designation.toString());
        holder.employee_email.setText(email.toString());
        holder.employee_id.setText(id.toString());
        holder.employee_mobile_number.setText(mobilenumber.toString());
        holder.employee_lastname.setText(lastname.toString());
        holder.employee_firstname.setText(firstname.toString());

    }

    @Override
    public int getItemCount() {
        return employeesItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView employee_designation, employee_id, employee_firstname, employee_dateOfJoining, employee_lastname, employee_email, employee_mobile_number;

        public ViewHolder(View itemView) { // This is
            super(itemView);
            employee_designation = itemView.findViewById(R.id.employee_designation);
            employee_id = itemView.findViewById(R.id.employee_id);
            employee_firstname = itemView.findViewById(R.id.employee_firstname);
            employee_dateOfJoining = itemView.findViewById(R.id.employee_dateOfJoining);
            employee_lastname = itemView.findViewById(R.id.employee_lastname);
            employee_email = itemView.findViewById(R.id.employee_email);
            employee_mobile_number = itemView.findViewById(R.id.employee_mobile_number);


        }
    }
}
