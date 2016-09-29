package com.example.utshelps.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.utshelps.R;
import com.example.utshelps.activity.MainActivity;
import com.example.utshelps.model.WorkshopSet;

import java.util.ArrayList;

/**
 * Adapter that is used to display a WorkshopSet item in the WorkshopSetListFragment.
 * <p/>
 * Created by Yaseen on 29/08/2016.
 */
public class WorkshopSetListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<WorkshopSet> mWorkshopSetArrayList;

    public WorkshopSetListAdapter(ArrayList<WorkshopSet> workshopSetArrayList) {
        mWorkshopSetArrayList = workshopSetArrayList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View inflatedView = layoutInflater.inflate(R.layout.adapter_workshop_set_list_item, parent, false);
        return new WorkshopViewHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        WorkshopViewHolder workshopViewHolder = (WorkshopViewHolder) holder;
        WorkshopSet workshopSet = mWorkshopSetArrayList.get(position);

        Log.d(MainActivity.TAG, "position is: " + position + " of " + mWorkshopSetArrayList.size());

        workshopViewHolder.workshopIdTextView.setText(Integer.toString(workshopSet.getId()));
        workshopViewHolder.workshopNameTextView.setText(workshopSet.getName());
    }

    @Override
    public int getItemCount() {
        if (mWorkshopSetArrayList != null) return mWorkshopSetArrayList.size();

        return 0;
    }

    public void setWorkshopArrayList(ArrayList<WorkshopSet> workshopSetArrayList) {
        this.mWorkshopSetArrayList = workshopSetArrayList;
        this.notifyDataSetChanged();
    }

    /**
     * A ViewHolder which contains the layouts and views used to display each WorkshopSet element.
     */
    private class WorkshopViewHolder extends RecyclerView.ViewHolder {
        // Because this is a private inner class, I saw no need to set these variables to private.
        public TextView workshopIdTextView;
        public TextView workshopNameTextView;

        public WorkshopViewHolder(View itemView) {
            super(itemView);

            workshopIdTextView = (TextView) itemView.findViewById(R.id.adapter_workshop_set_list_item_workshop_id);
            workshopNameTextView = (TextView) itemView.findViewById(R.id.adapter_workshop_set_list_item_workshop_name);
        }
    }
}
