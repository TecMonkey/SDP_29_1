package com.example.utshelps.model;

import com.example.utshelps.util.JsonKeys;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Model that represents a WorkshopSet.
 *
 * Created by Yaseen on 29/08/2016.
 */
public class WorkshopSet {
    @SerializedName(JsonKeys.WORKSHOP_SET_ID)
    private int mId;
    @SerializedName(JsonKeys.NAME)
    private String mName;
    @SerializedName(JsonKeys.ARCHIVED_DATE)
    private Date mDateArchived;

    public int getId() {
        return mId;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public Date getDateArchived() {
        return mDateArchived;
    }

    public void setDateArchived(Date mDateArchived) {
        this.mDateArchived = mDateArchived;
    }
}
