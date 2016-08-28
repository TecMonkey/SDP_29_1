package com.example.utshelps.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Yaseen on 29/08/2016.
 */
public class WorkshopResponse {

    @SerializedName("Results")
    private List<Workshop> mWorkshopList;
    @SerializedName("IsSuccess")
    private boolean mSuccess;
    @SerializedName("DisplayMessage")
    private String mDisplayMessage;

    public List<Workshop> getWorkshopList() {
        return mWorkshopList;
    }

    public void setWorkshopList(List<Workshop> mWorkshopList) {
        this.mWorkshopList = mWorkshopList;
    }

    public boolean isSuccess() {
        return mSuccess;
    }

    public void setSuccess(boolean mSuccess) {
        this.mSuccess = mSuccess;
    }

    public String getDisplayMessage() {
        return mDisplayMessage;
    }

    public void setDisplayMessage(String mDisplayMessage) {
        this.mDisplayMessage = mDisplayMessage;
    }
}
