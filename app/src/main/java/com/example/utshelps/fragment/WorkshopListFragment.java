package com.example.utshelps.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.utshelps.R;
import com.example.utshelps.activity.MainActivity;
import com.example.utshelps.adapter.WorkshopListAdapter;
import com.example.utshelps.api.ApiManager;
import com.example.utshelps.model.Workshop;
import com.example.utshelps.model.WorkshopResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Fragment that fetches and displays a list of Workshops from the api.
 * <p/>
 * Created by Yaseen on 29/08/2016.
 */
public class WorkshopListFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private WorkshopListAdapter mWorkshopListAdapter;
    private ApiManager mApiManager;

    public WorkshopListFragment() {

    }

    /**
     * Initialises the fragments when the layout is being inflated.
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View createdView = inflater.inflate(R.layout.fragment_workshop_list, container, false);

        LinearLayoutManager layoutManager = new LinearLayoutManager(createdView.getContext());
        mRecyclerView = (RecyclerView) createdView.findViewById(R.id.fragment_workshops_list_recycler_view);
        mRecyclerView.setLayoutManager(layoutManager);

        getWorkshopList();

        return createdView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mApiManager = ApiManager.getInstance();
    }

    /**
     * Fetches the workshops from the api and creates a callback method to handle the response.
     */
    private void getWorkshopList() {
        Callback<WorkshopResponse> callback = new Callback<WorkshopResponse>() {
            @Override
            public void onResponse(Call<WorkshopResponse> call, Response<WorkshopResponse> response) {
                if (response.isSuccessful()) {
                    Log.d(MainActivity.TAG, "response was successful");
                    if (response.body().isSuccess()) {
                        ArrayList<Workshop> workshopList = new ArrayList<>(response.body().getWorkshopList());
                        displayWorkshopList(workshopList);
                    }
                } else {
                    Log.d(MainActivity.TAG, "no response from server");
                }
            }

            @Override
            public void onFailure(Call<WorkshopResponse> call, Throwable t) {
                Log.d(MainActivity.TAG, "no internet connectivity");
            }
        };

        mApiManager.getWorkshopList(callback);
    }

    /**
     * Displays the list of workshops.
     * <p/>
     * Creates an adapter if it does not exist or updates the adapter with the new list.
     *
     * @param workshopList
     */
    private void displayWorkshopList(ArrayList<Workshop> workshopList) {
        if (mWorkshopListAdapter == null) {
            mWorkshopListAdapter = new WorkshopListAdapter(workshopList);
            mRecyclerView.setAdapter(mWorkshopListAdapter);
        } else {
            mWorkshopListAdapter.setWorkshopList(workshopList);
        }
    }
}
