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
import com.example.utshelps.adapter.WorkshopSetListAdapter;
import com.example.utshelps.api.ApiManager;
import com.example.utshelps.model.WorkshopSet;
import com.example.utshelps.api.model.WorkshopSetResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Fragment that fetches and displays a list of Workshops from the api.
 * <p/>
 * Created by Yaseen on 29/08/2016.
 */
public class WorkshopSetListFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private WorkshopSetListAdapter mWorkshopSetListAdapter;
    private ApiManager mApiManager;

    public WorkshopSetListFragment() {

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
        View createdView = inflater.inflate(R.layout.fragment_workshop_set_list, container, false);

        LinearLayoutManager layoutManager = new LinearLayoutManager(createdView.getContext());
        mRecyclerView = (RecyclerView) createdView.findViewById(R.id.fragment_workshops_set_list_recycler_view);
        mRecyclerView.setLayoutManager(layoutManager);

        getWorkshopSetList();

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
    private void getWorkshopSetList() {
        Callback<WorkshopSetResponse> callback = new Callback<WorkshopSetResponse>() {
            @Override
            public void onResponse(Call<WorkshopSetResponse> call, Response<WorkshopSetResponse> response) {
                if (response.isSuccessful()) {
                    Log.d(MainActivity.TAG, "response was successful");
                    if (response.body().isSuccessful()) {
                        ArrayList<WorkshopSet> workshopSetArrayList = new ArrayList<>(response.body().getWorkshopSetArrayList());
                        displayWorkshopSetList(workshopSetArrayList);
                    }
                } else {
                    Log.d(MainActivity.TAG, "no response from server");
                }
            }

            @Override
            public void onFailure(Call<WorkshopSetResponse> call, Throwable t) {
                Log.d(MainActivity.TAG, "no internet connectivity");
            }
        };

        mApiManager.getWorkshopSetList(callback);
    }

    /**
     * Displays the list of workshops.
     * <p/>
     * Creates an adapter if it does not exist or updates the adapter with the new list.
     *
     * @param workshopSetArrayList
     */
    private void displayWorkshopSetList(ArrayList<WorkshopSet> workshopSetArrayList) {
        if (mWorkshopSetListAdapter == null) {
            mWorkshopSetListAdapter = new WorkshopSetListAdapter(workshopSetArrayList);
            mRecyclerView.setAdapter(mWorkshopSetListAdapter);
        } else {
            mWorkshopSetListAdapter.setWorkshopArrayList(workshopSetArrayList);
        }
    }
}
