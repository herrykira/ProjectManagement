package com.example.tinku.projectmanagementsystem.model;

import com.google.gson.annotations.SerializedName;

public class EmployeesItem {

    @SerializedName("empdesignation")
    private String empdesignation;

    @SerializedName("empid")
    private String empid;

    @SerializedName("empfirstname")
    private String empfirstname;

    @SerializedName("dateofjoining")
    private String dateofjoining;

    @SerializedName("emplastname")
    private String emplastname;

    @SerializedName("empemail")
    private String empemail;

    @SerializedName("empmobile")
    private String empmobile;

    public String getEmpdesignation() {
        return empdesignation;
    }

    public void setEmpdesignation(String empdesignation) {
        this.empdesignation = empdesignation;
    }

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public String getEmpfirstname() {
        return empfirstname;
    }

    public void setEmpfirstname(String empfirstname) {
        this.empfirstname = empfirstname;
    }

    public String getDateofjoining() {
        return dateofjoining;
    }

    public void setDateofjoining(String dateofjoining) {
        this.dateofjoining = dateofjoining;
    }

    public String getEmplastname() {
        return emplastname;
    }

    public void setEmplastname(String emplastname) {
        this.emplastname = emplastname;
    }

    public String getEmpemail() {
        return empemail;
    }

    public void setEmpemail(String empemail) {
        this.empemail = empemail;
    }

    public String getEmpmobile() {
        return empmobile;
    }

    public void setEmpmobile(String empmobile) {
        this.empmobile = empmobile;
    }

    @Override
    public String toString() {
        return
                "EmployeesItem{" +
                        "empdesignation = '" + empdesignation + '\'' +
                        ",empid = '" + empid + '\'' +
                        ",empfirstname = '" + empfirstname + '\'' +
                        ",dateofjoining = '" + dateofjoining + '\'' +
                        ",emplastname = '" + emplastname + '\'' +
                        ",empemail = '" + empemail + '\'' +
                        ",empmobile = '" + empmobile + '\'' +
                        "}";
    }
}