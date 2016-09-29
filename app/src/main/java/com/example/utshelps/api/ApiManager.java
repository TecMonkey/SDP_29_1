package com.example.utshelps.api;

import com.example.utshelps.model.WorkshopSetResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Singleton class that wraps around the UtsHelpService and manages all network requests.
 * <p/>
 * This class can be used by any part of the application to make calls to the api.
 * <p/>
 * Created by Yaseen on 29/08/2016.
 */
public class ApiManager {
    private static ApiManager mApiManager;
    private UtsHelpsService mService;

    private static final String BASE_URL = "http://188.166.249.70/api/";
    private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZ";

    public static ApiManager getInstance() {
        if (mApiManager == null) {
            mApiManager = new ApiManager();
        }
        return mApiManager;
    }

    private ApiManager() {
        // The interceptor is used to view the requests and responses sent over the wire.
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        // Have to create our own custom gson so that we can successfully parse the date.
        Gson gson = new GsonBuilder().setDateFormat(DATE_FORMAT).create();

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BASE_URL)
                .client(client)
                .build();

        mService = retrofit.create(UtsHelpsService.class);
    }

    /**
     * Makes a call to the server to retrieve a list of workshops.
     *
     * @param callback
     */
    public void getWorkshopSetList(Callback callback) {
        Call<WorkshopSetResponse> workshopsCall = mService.getWorkshopSetList();
        workshopsCall.enqueue(callback);
    }
}