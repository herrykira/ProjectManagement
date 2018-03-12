package com.example.tinku.projectmanagementsystem.fragment.editsubtask;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.tinku.projectmanagementsystem.model.SubTaskStatusResponse;
import com.example.tinku.projectmanagementsystem.network.RetrofitInstance;
import com.example.tinku.projectmanagementsystem.network.UserService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by KinhangPoon on 9/3/2018.
 */

public class EditSubTaskPresenterImpl implements EditSubTaskPresenter {
    EditSubTaskView editSubTaskView;

    public EditSubTaskPresenterImpl(EditSubTaskFragment editSubTaskFragment) {
        editSubTaskView = editSubTaskFragment;
    }

    @Override
    public void createView(View view) {
        editSubTaskView.updateView(view);
    }

    @Override
    public void updateStatus(String userid, String taskid, String subtaskid, String projectid, String status) {
        UserService userService = RetrofitInstance.getRetrofitInstance().create(UserService.class);
        Call<SubTaskStatusResponse> call = userService.getSubTaskEdit(taskid,subtaskid,projectid,userid,status);
        call.enqueue(new Callback<SubTaskStatusResponse>() {
            @Override
            public void onResponse(Call<SubTaskStatusResponse> call, Response<SubTaskStatusResponse> response) {
                Log.i("editSubtask",response.body().toString());
                editSubTaskView.showToast("Edit Status Successfully");
            }

            @Override
            public void onFailure(Call<SubTaskStatusResponse> call, Throwable t) {

            }
        });
    }
}
