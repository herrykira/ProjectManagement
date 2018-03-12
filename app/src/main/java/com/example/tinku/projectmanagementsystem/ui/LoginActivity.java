package com.example.tinku.projectmanagementsystem.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.tinku.projectmanagementsystem.R;
import com.example.tinku.projectmanagementsystem.fragment.FragmentSwitch;
import com.example.tinku.projectmanagementsystem.fragment.forgot.ForgotFragment;
import com.example.tinku.projectmanagementsystem.fragment.login.LoginFragment;
import com.example.tinku.projectmanagementsystem.ui.user.UserActivity;

public class LoginActivity extends AppCompatActivity implements FragmentSwitch,ActivitySwitch {
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sharedPreferences = getSharedPreferences("myinfo", Context.MODE_PRIVATE);



        getSupportFragmentManager().beginTransaction()
                .replace(R.id.login_main,new LoginFragment())
                .addToBackStack(null).commit();
    }

    @Override
    public void switchToForgot() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.login_main,new ForgotFragment())
                .addToBackStack(null).commit();
    }


    @Override
    public void switchUserActivity() {
        Intent intent = new Intent(LoginActivity.this,UserActivity.class);
        startActivity(intent);
    }
}
