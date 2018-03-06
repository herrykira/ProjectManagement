package com.example.tinku.projectmanagementsystem.fragment.taskDetail;

import android.util.Log;
import android.view.View;

import com.example.tinku.projectmanagementsystem.model.DetailResponse;
import com.example.tinku.projectmanagementsystem.network.RetrofitInstance;
import com.example.tinku.projectmanagementsystem.network.UserService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by KinhangPoon on 5/3/2018.
 */

public class TaskDetailPresenterImpl implements TaskDetailPresenter {
    TaskDetailView taskDetailView;

    public TaskDetailPresenterImpl(TaskDetailFragment taskDetailFragment) {
        taskDetailView = taskDetailFragment;
    }

    @Override
    public void createView(View view) {
        taskDetailView.updateView(view);
    }

    @Override
    public void sendDetailRequest(String taskId, String productId){
        UserService userService = RetrofitInstance.getRetrofitInstance().create(UserService.class);
        Call<DetailResponse> call = userService.getTaskDetail(taskId,productId);
        call.enqueue(new Callback<DetailResponse>() {
            @Override
            public void onResponse(Call<DetailResponse> call, Response<DetailResponse> response) {
                Log.i("DetailResponse",response.message());
                /**
                 * set contents for textView
                 */
                taskDetailView.setText(response);
            }

            @Override
            public void onFailure(Call<DetailResponse> call, Throwable t) {
                Log.e("DetailError",t.getMessage());
            }
        });
    }

}
