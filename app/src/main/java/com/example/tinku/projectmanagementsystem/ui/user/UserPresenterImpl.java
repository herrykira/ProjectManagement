package com.example.tinku.projectmanagementsystem.ui.user;

import android.view.View;

/**
 * Created by KinhangPoon on 9/3/2018.
 */

public class UserPresenterImpl implements UserPresenter {
    UserView userView;

    public UserPresenterImpl(UserActivity userActivity) {
        userView = userActivity;
    }

    @Override
    public void createView() {
        userView.updateView();
    }
}
