package com.example.tinku.projectmanagementsystem.fragment.fragmentsforfab;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.tinku.projectmanagementsystem.R;

/**
 * Created by ryellap on 3/5/18.
 */

public class TabCreateUsers extends Fragment {
    EditText first_name_et, lastName_et, email_et, mobile_et, password_et, role_et;
    Button create_user_btn;


    public TabCreateUsers() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab_create_users, container, false);
        first_name_et = rootView.findViewById(R.id.first_name_et);
        lastName_et = rootView.findViewById(R.id.lastName_et);
        email_et = rootView.findViewById(R.id.email_et);
        mobile_et = rootView.findViewById(R.id.mobile_et);
        password_et = rootView.findViewById(R.id.password_et);
        role_et = rootView.findViewById(R.id.role_et);
        create_user_btn = rootView.findViewById(R.id.create_user_btn);
        create_user_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String first_name = first_name_et.getText().toString();
                String last_name = lastName_et.getText().toString();
                String email = email_et.getText().toString();
                String password = password_et.getText().toString();
                String mobile = mobile_et.getText().toString();
                String role = role_et.getText().toString();
                final String URL = "http://rjtmobile.com/aamir/pms/android-app/pms_reg.php?first_name=" + first_name + "&last_name=" + last_name + "&email=" + email + "&mobile=" + mobile + "&password=" + password + "&company_size=500&your_role=" + role + "";
                RequestQueue requestQueue = Volley.newRequestQueue(getContext());
                StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getContext(), "" + response.toString(), Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getContext(), "Network busy", Toast.LENGTH_SHORT).show();
                    }
                });
                requestQueue.add(stringRequest);
            }
        });
        return rootView;
    }
}
