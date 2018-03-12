package com.example.tinku.projectmanagementsystem.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.tinku.projectmanagementsystem.R;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity {
//    Button buttonLoginPage, button_admin;
    String roles[] = {"Admin","User"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);
//
//        buttonLoginPage = findViewById(R.id.button_login_page);
//
//        buttonLoginPage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(MainActivity.this, LoginActivity.class);
//                startActivity(i);
//            }
//        });
//        button_admin = findViewById(R.id.button_admin);
//        button_admin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, AdminLoginActivity.class);
//                startActivity(intent);
//            }
//        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        builder.setTitle("Role")
                .setIcon(R.mipmap.owel)
                .setItems(roles, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = null;
                        switch (which){
                            case 0:
                                 intent = new Intent(MainActivity.this, AdminLoginActivity.class);
                                 break;
                                
                            case 1:
                                 intent = new Intent(MainActivity.this, LoginActivity.class);
                                 break;
                        }
                        startActivity(intent);
                    }
                });
        builder.show();
    }
}
