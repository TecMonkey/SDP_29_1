package com.example.utshelps.api;

import com.example.utshelps.model.WorkshopResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Yaseen on 29/08/2016.
 */
public class ApiManager {
    private static ApiManager mApiManager;
    private UtsHelpsService mService;

    private static final String BASE_URL = "http://utshelps9213.cloudapp.net/api/";
    private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS";

    public static ApiManager getInstance() {
        if (mApiManager == null) {
            mApiManager = new ApiManager();
        }
        return mApiManager;
    }

    private ApiManager() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        Gson gson = new GsonBuilder().setDateFormat(DATE_FORMAT).create();

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BASE_URL)
                .client(client)
                .build();

        mService = retrofit.create(UtsHelpsService.class);
    }

    public void getWorkshops(Callback callback) {
        Call<WorkshopResponse> workshopsCall = mService.getWorkshops();
        workshopsCall.enqueue(callback);
    }
}
