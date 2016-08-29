package com.example.utshelps.api;

import com.example.utshelps.model.Workshop;
import com.example.utshelps.model.WorkshopResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by Yaseen on 29/08/2016.
 */
public interface UtsHelpsService {
    @Headers("AppKey: sdpgroup29")

    @GET("workshop/workshopSets/")
    Call<WorkshopResponse> getWorkshops();
}
