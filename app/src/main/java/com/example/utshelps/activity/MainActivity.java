package com.example.utshelps.activity;

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

import com.example.utshelps.Constants;
import com.example.utshelps.R;
import com.example.utshelps.api.ApiManager;
import com.example.utshelps.fragment.FragmentTwo;
import com.example.utshelps.fragment.MainFragment;
import com.example.utshelps.fragment.WorkshopSetListFragment;
import com.example.utshelps.model.WorkshopSet;
import com.example.utshelps.model.WorkshopSetResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * The activity that is loaded on app launch.
 */
public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private Toolbar mToolbar;
    private NavigationView mNavigationView;
    private ActionBarDrawerToggle mDrawerToggle;
    private FragmentManager mFragmentManager;
    private ApiManager mApiManager;

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

        mApiManager = ApiManager.getInstance();

        //Intent intent = new Intent(this, LoginActivity.class);
        //startActivityForResult(intent, Constants.LOGIN_ACTIVITY_REQUEST);

        //getWorkshopList();
    }

    /**
     * Makes a network call using the ApiManager and handles the response.
     */
    private void getWorkshopList() {
        Callback<WorkshopSetResponse> callback = new Callback<WorkshopSetResponse>() {
            @Override
            public void onResponse(Call<WorkshopSetResponse> call, Response<WorkshopSetResponse> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "response was successful");
                    if (response.body().isSuccess()) {
                        ArrayList<WorkshopSet> workshopSetArrayList = new ArrayList<>(response.body().getWorkshopList());
                        if (workshopSetArrayList.size() > 0) {
                            WorkshopSet w1 = workshopSetArrayList.get(0);
                            Log.d(TAG, "w1 id: " + w1.getId());
                        }
                    }
                } else {
                    Log.d(TAG, "no response from server");
                }
            }

            @Override
            public void onFailure(Call<WorkshopSetResponse> call, Throwable t) {
                Log.d(TAG, "no internet connectivity");
            }
        };

        mApiManager.getWorkshopSetList(callback);
    }

    /**
     * Displays the first fragment on app launch
     */
    private void displayFirstFragment() {
        Fragment fragment = new WorkshopSetListFragment();
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.drawer_content, fragment);
        fragmentTransaction.commit();
    }

    /**
     * Handles the results of an activity which was started by MainActivity.
     * <p/>
     * Currently it is being used to check whether a user was signed in successfully or not.
     *
     * @param requestCode used to identify the activity and why it was requested
     * @param resultCode  used to identify the result
     * @param data        data passed back from the activity that was started
     */
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

    /**
     * Handles item selections made by the user.
     * <p/>
     * Checks which item was selected and responds to that selection.
     *
     * @param menuItem
     */
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

    /**
     * Displays a given fragment
     * <p/>
     * This function also pops the back stack to ensure there is ever only 2 selections from the nav
     * drawer.
     *
     * @param fragment
     */
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
