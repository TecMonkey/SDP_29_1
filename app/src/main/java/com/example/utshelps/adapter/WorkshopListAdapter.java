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
 * Adapter that is used to display a Workshop item in the WorkshopListFragment.
 * <p/>
 * Created by Yaseen on 29/08/2016.
 */
public class WorkshopListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<Workshop> mWorkshopList;

    public WorkshopListAdapter(ArrayList<Workshop> workshopList) {
        mWorkshopList = workshopList;
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
        Workshop workshop = mWorkshopList.get(position);

        Log.d(MainActivity.TAG, "position is: " + position + " of " + mWorkshopList.size());

        workshopViewHolder.workshopIdTextView.setText(Integer.toString(workshop.getId()));
        workshopViewHolder.workshopNameTextView.setText(workshop.getName());
    }

    @Override
    public int getItemCount() {
        if (mWorkshopList != null) return mWorkshopList.size();

        return 0;
    }

    public void setWorkshopList(ArrayList<Workshop> workshopList) {
        this.mWorkshopList = workshopList;
        this.notifyDataSetChanged();
    }

    /**
     * A ViewHolder which contains the layouts and views used to display each Workshop element.
     */
    private class WorkshopViewHolder extends RecyclerView.ViewHolder {
        // Because this is a private inner class, I saw no need to set these variables to private.
        public TextView workshopIdTextView;
        public TextView workshopNameTextView;

        public WorkshopViewHolder(View itemView) {
            super(itemView);

            workshopIdTextView = (TextView) itemView.findViewById(R.id.adapter_workshop_list_item_workshop_id);
            workshopNameTextView = (TextView) itemView.findViewById(R.id.adapter_workshop_list_item_workshop_name);
        }
    }
}
