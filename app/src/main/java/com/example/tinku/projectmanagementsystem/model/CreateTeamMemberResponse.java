package com.example.tinku.projectmanagementsystem.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class CreateTeamMemberResponse {

    @SerializedName("msg")
    private List<String> msg;

    public List<String> getMsg() {
        return msg;
    }

    public void setMsg(List<String> msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return
                "CreateTeamMemberResponse{" +
                        "msg = '" + msg + '\'' +
                        "}";
    }
}