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

        Intent intent = new Intent(this, LoginActivity.class);
        startActivityForResult(intent, Constants.LOGIN_ACTIVITY_REQUEST);
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

        if (selectedFragment != null) {
            FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.drawer_content, selectedFragment);
            fragmentTransaction.addToBackStack(null);

            fragmentTransaction.commit();
        }
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
