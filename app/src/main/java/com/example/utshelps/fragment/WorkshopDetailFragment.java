package com.example.utshelps.fragment;

import android.app.Fragment;
import android.support.v7.widget.RecyclerView;

import com.example.utshelps.adapter.WorkshopDetailAdapter;
import com.example.utshelps.api.ApiManager;

/**
 * Created by Ferdy on 10/6/2016.
 */

public class WorkshopDetailFragment extends Fragment{
    private RecyclerView mRecylerView;
    private WorkshopDetailAdapter mWorkshopDetailAdapter;
    private ApiManager mApiManager;

    public WorkshopDetailFragment(){

    }


}
