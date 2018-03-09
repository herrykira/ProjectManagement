package com.example.tinku.projectmanagementsystem.fragment.member;

import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;

import com.example.tinku.projectmanagementsystem.model.DetailResponse;
import com.example.tinku.projectmanagementsystem.model.MemberDetailResponse;
import com.example.tinku.projectmanagementsystem.model.MemberTaskResponse;
import com.example.tinku.projectmanagementsystem.model.MembersItem;
import com.example.tinku.projectmanagementsystem.model.Task;
import com.example.tinku.projectmanagementsystem.model.TaskResponse;
import com.example.tinku.projectmanagementsystem.network.RetrofitInstance;
import com.example.tinku.projectmanagementsystem.network.UserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by KinhangPoon on 8/3/2018.
 */

public class MemberPresenterImpl implements MemberPresenter {
    MemberView memberView;
    List<String> titles = new ArrayList<>();

    public MemberPresenterImpl(MemberFragment memberFragment) {
        memberView = memberFragment;
    }

    @Override
    public void createView(View view) {
        memberView.updateView(view);
    }

    @Override
    public void sendMemberRequest(SharedPreferences sharedPreferences) {
        String userId = sharedPreferences.getString("UserId","");
        Log.i("MemberlistUserId",userId);
        if(userId.equals("")){
            return;
        }
        UserService userService = RetrofitInstance.getRetrofitInstance().create(UserService.class);
        Call<TaskResponse> call = userService.getTaskList(userId);
        call.enqueue(new Callback<TaskResponse>() {
            @Override
            public void onResponse(Call<TaskResponse> call, Response<TaskResponse> response) {
                Log.i("MemberListResponse",response.raw().toString());
                List<Task> taskList = response.body().getTasksview();
                for(int i=0;i<taskList.size();i++){
                    String projectid = taskList.get(i).getProjectid();
                    String taskid = taskList.get(i).getTaskid();
                    String subtaskid = taskList.get(i).getSubtaskid();

                    requestMemberList(taskid,projectid);

                }
            }

            @Override
            public void onFailure(Call<TaskResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void getMemberRequest(String userId) {
        UserService userService = RetrofitInstance.getRetrofitInstance().create(UserService.class);
        Call<MemberDetailResponse> call = userService.getMemberDetail(userId);
        call.enqueue(new Callback<MemberDetailResponse>() {
            @Override
            public void onResponse(Call<MemberDetailResponse> call, Response<MemberDetailResponse> response) {
                Log.i("MemberDetailList",response.body().toString());
                String firstName = response.body().getUserfirstname();
                String lastName = response.body().getUserlastname();
                String email = response.body().getUseremail();
                String mobile = response.body().getUsermobile();

                memberView.createDialog(firstName,lastName,email,mobile);
            }

            @Override
            public void onFailure(Call<MemberDetailResponse> call, Throwable t) {

            }
        });
    }

    public void requestMemberList(String taskid,String projectid){
        final Map<String,List<String>> map = new HashMap<>();
        UserService userService = RetrofitInstance.getRetrofitInstance().create(UserService.class);
        Call<MemberTaskResponse> call = userService.getTaskMember(taskid,projectid);
        call.enqueue(new Callback<MemberTaskResponse>() {
            @Override
            public void onResponse(Call<MemberTaskResponse> call, Response<MemberTaskResponse> response) {
                Log.i("MemberTaskResponse",response.body().toString());
                List<MembersItem> members = response.body().getMembers();
                List<String> userIds = new ArrayList<>();
                for(int i=0;i<members.size();i++){
                    String userId = members.get(i).getUserid();
                    String taskId = members.get(i).getTaskid();
                    String projectId = members.get(i).getProjectid();

                    userIds.add(userId);
                    getTaskTitles(map,taskId,projectId,userId,i,members.size()-1);

                }
            }

            @Override
            public void onFailure(Call<MemberTaskResponse> call, Throwable t) {

            }
        });

    }

    public void getTaskTitles(final Map<String,List<String>> map, final String taskId, String projectId, final String userId, final int i, final int size){
        UserService userService = RetrofitInstance.getRetrofitInstance().create(UserService.class);
        Call<DetailResponse> call = userService.getTaskDetail(taskId,projectId);
        call.enqueue(new Callback<DetailResponse>() {
            @Override
            public void onResponse(Call<DetailResponse> call, Response<DetailResponse> response) {
                if(response.body().toString().contains("null")){
                    return;
                }
                Log.i("taskTitles",response.body().getTaskname());
                String taskname = response.body().getTaskname();
                if(!titles.contains(taskname)){
                    titles.add(taskname);
                }
                if(!map.containsKey(taskname)){
                    map.put(taskname, new ArrayList<String>());
                }
                map.get(taskname).add(userId);
                Log.i("member",map.size()+"");
                Log.i("memberid",map.get(taskname).size()+"");
                if(i == size){
                    memberView.updateListView(titles,map);
                }
            }

            @Override
            public void onFailure(Call<DetailResponse> call, Throwable t) {

            }
        });
    }
}
