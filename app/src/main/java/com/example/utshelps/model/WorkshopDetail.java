package com.example.utshelps.model;

import com.example.utshelps.util.JsonKeys;
import com.google.gson.annotations.SerializedName;

/**
 * Model that represents the workshop details
 * Displaying workshop details, followed by a list of sessions.
 * Created by Ferdy on 10/5/2016.
 */

public class WorkshopDetail {
    @SerializedName(JsonKeys.WORKSHOP_ID)
    private int mId;
    @SerializedName(JsonKeys.TOPIC)
    private String mTopic;
    @SerializedName(JsonKeys.CUTOFF)
    private String mCutoff;
    @SerializedName(JsonKeys.WORKSHOP_SESSIONS)
    private String mWorkshopSession;
    @SerializedName(JsonKeys.DESCRIPTION)
    private String mWorkshopDescription;
    @SerializedName(JsonKeys.START_DATE)
    private String mStartDate;
    @SerializedName(JsonKeys.END_DATE)
    private String mEndDate;
    @SerializedName(JsonKeys.PLACES_AVAILABLE)
    private int mNumAvail;
    @SerializedName(JsonKeys.MAXIMUM)
    private int mMax;
    @SerializedName(JsonKeys.WORKSHOP_SESSION_ID)
    private int mSessionId;
    @SerializedName(JsonKeys.CAMPUS)
    private String mCampus;

    public WorkshopDetail(int mId, String mTopic, String mCutoff, String mWorkshopDescription, String mWorkshopSession, String mStartDate,
                          String mEndDate, int mNumAvail, int mMax, int mSessionId, String mCampus) {
        this.mId = mId;
        this.mTopic = mTopic;
        this.mCutoff = mCutoff;
        this.mWorkshopSession = mWorkshopSession;
        this.mWorkshopDescription = mWorkshopDescription;
        this.mStartDate = mStartDate;
        this.mEndDate = mEndDate;
        this.mNumAvail = mNumAvail;
        this.mMax = mMax;
        this.mSessionId = mSessionId;
        this.mCampus = mCampus;

    }

    public String getmWorkshopDescription() {
        return mWorkshopDescription;
    }

    public void setmWorkshopDescription(String mWorkshopDescription) {
        this.mWorkshopDescription = mWorkshopDescription;
    }

    public int getId() {
        return mId;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmTopic() {
        return mTopic;
    }

    public void setmTopic(String mTopic) {
        this.mTopic = mTopic;
    }

    public String getmCutoff() {
        return mCutoff;
    }

    public void setmCutoff(String mCutoff) {
        this.mCutoff = mCutoff;
    }

    public String getmWorkshopSession() {
        return mWorkshopSession;
    }

    public void setmWorkshopSession(String mWorkshopSession) {
        this.mWorkshopSession = mWorkshopSession;
    }

    public String getmStartDate() {
        return mStartDate;
    }

    public void setmStartDate(String mStartDate) {
        this.mStartDate = mStartDate;
    }

    public String getmEndDate() {
        return mEndDate;
    }

    public void setmEndDate(String mEndDate) {
        this.mEndDate = mEndDate;
    }

    public int getmNumAvail() {
        return mNumAvail;
    }

    public void setmNumAvail(int mNumAvail) {
        this.mNumAvail = mNumAvail;
    }

    public int getmMax() {
        return mMax;
    }

    public void setmMax(int mMax) {
        this.mMax = mMax;
    }

    public int getmSessionId() {
        return mSessionId;
    }

    public void setmSessionId(int mSessionId) {
        this.mSessionId = mSessionId;
    }

    public String getmCampus() {
        return mCampus;
    }

    public void setmCampus(String mCampus) {
        this.mCampus = mCampus;
    }
}
