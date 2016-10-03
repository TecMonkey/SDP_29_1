package com.example.utshelps.api;

import com.example.utshelps.api.model.BaseResponse;
import com.example.utshelps.api.model.LoginRequest;
import com.example.utshelps.api.model.WorkshopSetResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Interface that is used by Retrofit to make network calls.
 *
 * Created by Yaseen on 29/08/2016.
 */
public interface UtsHelpsService {
    @GET("workshop/workshopSets/")
    Call<WorkshopSetResponse> getWorkshopSetList();

    @POST("student/login/")
    Call<BaseResponse> login(@Body LoginRequest loginRequest);
}
