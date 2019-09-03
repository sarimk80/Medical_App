package com.medical.medicalapp.alarm;

public class UserModel {
    private String phone_no;
    private String UserId;

    public UserModel() {
    }

    public UserModel(String phone_no, String userId) {
        this.phone_no = phone_no;
        UserId = userId;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }
}
