package com.example.utshelps.api.model;

import com.example.utshelps.model.Student;
import com.example.utshelps.util.JsonKeys;
import com.google.gson.annotations.SerializedName;

/**
 * Created by yaseen on 5/10/16.
 */

public class StudentResponse extends BaseResponse {

    @SerializedName(JsonKeys.RESULTS)
    private Student mStudent;

    public Student getStudent() {
        return mStudent;
    }

    public void setStudent(Student mStudent) {
        this.mStudent = mStudent;
    }
}
