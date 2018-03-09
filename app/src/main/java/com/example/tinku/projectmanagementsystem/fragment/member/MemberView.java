package com.example.tinku.projectmanagementsystem.fragment.member;

import android.view.View;

import java.util.List;
import java.util.Map;

/**
 * Created by KinhangPoon on 8/3/2018.
 */

public interface MemberView {
    public void updateView(View view);
    public void updateListView(List<String> titles, Map<String, List<String>> map);
    public void createDialog(String firstName,String lastName,String email,String mobile);
}
