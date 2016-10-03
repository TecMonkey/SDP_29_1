package com.example.utshelps.model;

import com.example.utshelps.util.JsonKeys;
import com.google.gson.annotations.SerializedName;

/**
 * This class is extended by all api response classes. It stores values which are returned by all
 * API responses (IsSuccess and DisplayMessage).
 *
 * Created by yaseen on 3/10/16.
 */

public class BaseResponse {
    @SerializedName(JsonKeys.IS_SUCCESS)
    protected boolean mIsSuccess;
    @SerializedName(JsonKeys.DISPLAY_MESSAGE)
    protected String mDisplayMessage;

    public BaseResponse() {

    }

    public boolean isSuccessful() {
        return mIsSuccess;
    }

    public void setSuccess(boolean mIsSuccess) {
        this.mIsSuccess = mIsSuccess;
    }

    public String getDisplayMessage() {
        return mDisplayMessage;
    }

    public void setDisplayMessage(String mDisplayMessage) {
        this.mDisplayMessage = mDisplayMessage;
    }
}
