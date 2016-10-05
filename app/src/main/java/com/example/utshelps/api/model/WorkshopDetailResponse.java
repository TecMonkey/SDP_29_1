package com.example.utshelps.api.model;

import com.example.utshelps.model.WorkshopDetail;
import com.example.utshelps.util.JsonKeys;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Ferdy on 10/5/2016.
 */

public class WorkshopDetailResponse extends BaseResponse {

    //JsonKeys.RESULTS are in ArrayList
    @SerializedName(JsonKeys.RESULTS)
    private ArrayList <WorkshopDetail> mWorkshopDetails;

    public ArrayList <WorkshopDetail> getWorkshopDetailArrayList()
    { return mWorkshopDetails; }

}
