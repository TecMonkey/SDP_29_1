package com.example.utshelps.api;

import com.example.utshelps.api.model.BaseResponse;
import com.example.utshelps.api.model.LoginRequest;
import com.example.utshelps.api.model.StudentResponse;
import com.example.utshelps.api.model.WorkshopDetailResponse;
import com.example.utshelps.api.model.WorkshopSetResponse;
import com.example.utshelps.model.Student;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

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

    @POST("student/register/")
    Call<StudentResponse> register(@Body Student student);

    @GET("workshop/workshopSets/")
    Call<WorkshopDetailResponse> getWorkshopDetailList();/**(@Query("api_key") String apiKey*/
}
