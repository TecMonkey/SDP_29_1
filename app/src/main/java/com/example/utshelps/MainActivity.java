package com.example.utshelps;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.utshelps.model.Workshop;
import com.example.utshelps.model.WorkshopResponse;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private Toolbar mToolbar;
    private NavigationView mNavigationView;
    private ActionBarDrawerToggle mDrawerToggle;
    private FragmentManager mFragmentManager;

    public static final String TAG = "UTS";

    private int fragmentCode = Constants.FRAGMENT_MAIN_DISPLAYED;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        mFragmentManager = getSupportFragmentManager();

        setupDrawerOptions(mNavigationView);

        displayFirstFragment();

        //Intent intent = new Intent(this, LoginActivity.class);
        //startActivityForResult(intent, Constants.LOGIN_ACTIVITY_REQUEST);

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://utshelps9213.cloudapp.net/api/")
                .client(client)
                .build();

        UtsHelpsService utsHelpsService = retrofit.create(UtsHelpsService.class);

        Callback<WorkshopResponse> callback = new Callback<WorkshopResponse>() {
            @Override
            public void onResponse(Call<WorkshopResponse> call, Response<WorkshopResponse> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "response was successful");
                    if (response.body().isSuccess()) {
                        ArrayList<Workshop> workshops = new ArrayList<>(response.body().getWorkshopList());
                        if (workshops.size() > 0) {
                            Workshop w1 = workshops.get(0);
                            Log.d(TAG, "w1 id: " + w1.getId());
                        }
                    }
                } else {
                    Log.d(TAG, "no response from server");
                }
            }

            @Override
            public void onFailure(Call<WorkshopResponse> call, Throwable t) {
                Log.d(TAG, "no internet connectivity");
            }
        };

        Call<WorkshopResponse> call = utsHelpsService.getWorkshops();
        call.enqueue(callback);
    }

    private void displayFirstFragment() {
        Fragment fragment = new MainFragment();
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.drawer_content, fragment);
        fragmentTransaction.commit();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        String loginResult;
        if (resultCode == Constants.LOGIN_ACTIVITY_SUCCESS) {
            loginResult = "Login successful";
            Log.d(TAG, "login successful");
            if (fragmentCode == Constants.FRAGMENT_MAIN_DISPLAYED) {
                TextView loginView = (TextView) findViewById(R.id.fragment_main_login_text_view);
                loginView.setText(loginResult);
            }
        } else if (resultCode == Constants.LOGIN_ACTIVITY_FAILED) {
            loginResult = "Login failed";
            Log.d(TAG, "login failed");
        }
    }

    private void setupDrawerOptions(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                selectNavigationItem(item);
                return true;
            }
        });
    }

    private void selectNavigationItem(MenuItem menuItem) {
        menuItem.setChecked(true);

        Fragment selectedFragment = null;

        switch (menuItem.getItemId()) {
            case R.id.menu_drawer_view_item1:
                selectedFragment = new MainFragment();
                fragmentCode = Constants.FRAGMENT_MAIN_DISPLAYED;
                Log.d(TAG, "Item 1 selected");
                break;
            case R.id.menu_drawer_view_item2:
                selectedFragment = new FragmentTwo();
                fragmentCode = Constants.FRAGMENT_TWO_DISPLAYED;
                Log.d(TAG, "Item 2 selected");
                break;
        }

        displayFragment(selectedFragment);
        mDrawerLayout.closeDrawers();
    }

    private void displayFragment(Fragment fragment) {
        if (fragment == null) return;

        mFragmentManager.popBackStackImmediate();
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.drawer_content, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
        mDrawerLayout.closeDrawers();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar home/up action should open or close the drawer.
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

}
