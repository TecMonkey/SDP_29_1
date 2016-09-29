package com.example.utshelps.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Wrapper class around a list of WorkshopSet elements.
 * <p/>
 * Used by Retrofit/Gson to map a response to a class.
 * <p/>
 * Created by Yaseen on 29/08/2016.
 */
public class WorkshopSetResponse {

    @SerializedName("Results")
    private ArrayList<WorkshopSet> mWorkshopSetList;
    @SerializedName("IsSuccess")
    private boolean mSuccess;
    @SerializedName("DisplayMessage")
    private String mDisplayMessage;

    public ArrayList<WorkshopSet> getWorkshopList() {
        return mWorkshopSetList;
    }

    public void setWorkshopList(ArrayList<WorkshopSet> mWorkshopSetList) {
        this.mWorkshopSetList = mWorkshopSetList;
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
