package com.example.tinku.projectmanagementsystem.fragment.edittask;

import android.util.Log;
import android.view.View;

import com.example.tinku.projectmanagementsystem.model.SubTaskStatusResponse;
import com.example.tinku.projectmanagementsystem.network.RetrofitInstance;
import com.example.tinku.projectmanagementsystem.network.UserService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by KinhangPoon on 9/3/2018.
 */

public class EditTaskPresenterImpl implements EditTaskPresenter {
    EditTaskView editTaskView;

    public EditTaskPresenterImpl(EditTaskFragment editTaskFragment) {
        editTaskView = editTaskFragment;
    }

    @Override
    public void createView(View view) {
        editTaskView.updateView(view);
    }

    @Override
    public void updateStatus(String userid, String taskid, String projectid, String status) {
        UserService userService = RetrofitInstance.getRetrofitInstance().create(UserService.class);
        Call<SubTaskStatusResponse> call = userService.getTaskEdit(taskid,projectid,userid,status);
        call.enqueue(new Callback<SubTaskStatusResponse>() {
            @Override
            public void onResponse(Call<SubTaskStatusResponse> call, Response<SubTaskStatusResponse> response) {
                Log.i("editSubtask",response.body().toString());
                editTaskView.showToast("Edit Status Successfully");
            }

            @Override
            public void onFailure(Call<SubTaskStatusResponse> call, Throwable t) {

            }
        });
    }
}
