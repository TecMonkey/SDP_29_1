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

    public int getId() {
        return mId;
    }

    public String getTopic() {
        return mTopic;
    }

    public String getWorkshopSession() {
        return mWorkshopSession;
    }

    public String getStartDate() {
        return mStartDate;
    }

    public String getEndDate() {
        return mEndDate;
    }

    public int getNumAvail() {
        return mNumAvail;
    }

    public int getMax() {
        return mMax;
    }

    public int getSessionId() {
        return mSessionId;
    }

    public String getCampus() {
        return mCampus;
    }
}
