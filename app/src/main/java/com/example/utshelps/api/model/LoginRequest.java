package com.example.utshelps.api.model;

import com.example.utshelps.util.JsonKeys;
import com.google.gson.annotations.SerializedName;

/**
 * Created by yaseen on 4/10/16.
 */

public class LoginRequest {
    @SerializedName(JsonKeys.STUDENT_ID)
    private String mStudentId;
    @SerializedName(JsonKeys.PASSWORD)
    private String mPassword;

    public String getStudentId() {
        return mStudentId;
    }

    public void setStudentId(String mStudentId) {
        this.mStudentId = mStudentId;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String mPassword) {
        this.mPassword = mPassword;
    }
}
