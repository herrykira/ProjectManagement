package com.example.tinku.projectmanagementsystem.fragment.member;

import android.content.SharedPreferences;
import android.view.View;

/**
 * Created by KinhangPoon on 8/3/2018.
 */

public interface MemberPresenter {
    public void createView(View view);
    public void sendMemberRequest(SharedPreferences sharedPreferences);
    public void getMemberRequest(String userId);
}
