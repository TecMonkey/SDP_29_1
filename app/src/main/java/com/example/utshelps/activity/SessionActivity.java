package com.example.utshelps.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;

import com.example.utshelps.R;

/**Activity that shows sessions list of a workshop
 * Created by Ferdy on 10/3/2016.
 */

public class SessionActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.session_view, menu);
        return true;
    }

    public void sessionDetails() {


    }




}

