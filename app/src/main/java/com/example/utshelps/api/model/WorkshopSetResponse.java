package com.example.utshelps.api.model;

import com.example.utshelps.model.WorkshopSet;
import com.example.utshelps.util.JsonKeys;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Wrapper class around a list of WorkshopSet elements.
 * <p/>
 * Used by Retrofit/Gson to map a response to a class.
 * <p/>
 * Created by Yaseen on 29/08/2016.
 */
public class WorkshopSetResponse extends BaseResponse {

    @SerializedName(JsonKeys.RESULTS)
    private ArrayList<WorkshopSet> mWorkshopSetList;

    public ArrayList<WorkshopSet> getWorkshopSetArrayList() {
        return mWorkshopSetList;
    }

    public void setWorkshopSetArrayList(ArrayList<WorkshopSet> workshopSetArrayList) {
        this.mWorkshopSetList = workshopSetArrayList;
    }
}
