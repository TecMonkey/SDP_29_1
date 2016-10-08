package com.example.utshelps.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.utshelps.model.WorkshopDetail;
import com.example.utshelps.R;
import com.example.utshelps.activity.MainActivity;

import java.util.ArrayList;

/**
 * Created by Ferdy on 10/8/2016.
 */


public class WorkshopDetailAdapter extends RecyclerView.Adapter<WorkshopDetailAdapter.WorkshopViewHolder> {
    private ArrayList<WorkshopDetail> mWorkshopDetails;
    private int mRowLayout;
    private Context mContext;

    public static class WorkshopViewHolder extends RecyclerView.ViewHolder {
        LinearLayout workshopDetailsLayout;
        TextView workshopTitle;
        TextView workshopDescription;


        public WorkshopViewHolder(View v) {
            super(v);
            workshopDetailsLayout = (LinearLayout) v.findViewById(R.id.workshop_sessions_layout);
            workshopTitle = (TextView) v.findViewById(R.id.title);
            workshopDescription = (TextView) v.findViewById(R.id.description);
        }
    }

    public WorkshopDetailAdapter(ArrayList<WorkshopDetail> mWorkshopDetails, int mRowLayout, Context mContext){
        this.mWorkshopDetails = mWorkshopDetails;
        this.mRowLayout = mRowLayout;
        this.mContext = mContext;
    }

    @Override
    public WorkshopDetailAdapter.WorkshopViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(mRowLayout, parent, false);
        return new WorkshopViewHolder(view);
    }


    @Override
    public void onBindViewHolder(WorkshopViewHolder holder, final int position) {
        holder.workshopTitle.setText(mWorkshopDetails.get(position).getmTopic());
        holder.workshopDescription.setText(mWorkshopDetails.get(position).getmWorkshopDescription());
    }

    @Override
    public int getItemCount() {
        return mWorkshopDetails.size();
    }
}

