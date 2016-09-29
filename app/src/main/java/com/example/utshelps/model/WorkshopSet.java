package com.example.utshelps.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Model that represents a WorkshopSet.
 *
 * Created by Yaseen on 29/08/2016.
 */
public class WorkshopSet {
    @SerializedName("WorkshopSetId")
    private int mId;
    @SerializedName("Name")
    private String mName;
    @SerializedName("ArchivedDate")
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
