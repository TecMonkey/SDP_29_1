package com.example.utshelps.api;

import com.example.utshelps.api.model.WorkshopSetResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Interface that is used by Retrofit to make network calls.
 *
 * Created by Yaseen on 29/08/2016.
 */
public interface UtsHelpsService {
    @GET("workshop/workshopSets/")
    Call<WorkshopSetResponse> getWorkshopSetList();
}
