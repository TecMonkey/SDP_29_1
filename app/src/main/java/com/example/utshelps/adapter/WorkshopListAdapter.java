package com.example.utshelps.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.utshelps.R;
import com.example.utshelps.activity.MainActivity;
import com.example.utshelps.model.Workshop;

import java.util.ArrayList;

/**
 * Created by Yaseen on 29/08/2016.
 */
public class WorkshopListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<Workshop> mWorkshopsList;

    public WorkshopListAdapter(ArrayList<Workshop> workshopsList) {
        mWorkshopsList = workshopsList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View inflatedView = layoutInflater.inflate(R.layout.adapter_workshop_list_item, parent, false);
        return new WorkshopViewHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        WorkshopViewHolder workshopViewHolder = (WorkshopViewHolder) holder;
        Workshop workshop = mWorkshopsList.get(position);

        Log.d(MainActivity.TAG, "position is: " + position + " of " + mWorkshopsList.size());

        workshopViewHolder.workshopIdTextView.setText(Integer.toString(workshop.getId()));
        workshopViewHolder.workshopNameTextView.setText(workshop.getName());
    }

    @Override
    public int getItemCount() {
        if (mWorkshopsList != null) return mWorkshopsList.size();

        return 0;
    }

    private class WorkshopViewHolder extends RecyclerView.ViewHolder {

        public TextView workshopIdTextView;
        public TextView workshopNameTextView;

        public WorkshopViewHolder(View itemView) {
            super(itemView);

            workshopIdTextView = (TextView) itemView.findViewById(R.id.adapter_workshop_list_item_workshop_id);
            workshopNameTextView = (TextView) itemView.findViewById(R.id.adapter_workshop_list_item_workshop_name);
        }
    }
}
