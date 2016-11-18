package com.lendingKart.base;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;

import com.lendingKart.R;
import com.lendingKart.custom.RobotoTextView;
import com.lendingKart.utils.PreferenceUtils;
import com.lendingKart.utils.Utils;


public class BaseNavigationalActivity extends BaseActivity implements
        NavigationView.OnNavigationItemSelectedListener, DrawerLayout.DrawerListener, View.OnClickListener {

    protected DrawerLayout mDrawerLayout;
    private RobotoTextView mUserName;
    private RobotoTextView mVersion;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initNavigationalView();
    }

    private void initNavigationalView() {
        mDrawerLayout = ((DrawerLayout) findViewById(R.id.base_drawer_layout));
        mDrawerLayout.addDrawerListener(this);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        initNavigationHeaderViews(navigationView.getHeaderView(0));
        setClickListenersForNavigationHeaderView(navigationView.getHeaderView(0));
    }

    private void initNavigationHeaderViews(View headerView) {
        if (headerView != null) {
            mUserName = (RobotoTextView) headerView.findViewById(R.id.user_name);
            mVersion = (RobotoTextView) headerView.findViewById(R.id.version_name);
            setUserName();
            setAppVersion();
        }
    }

    private void setClickListenersForNavigationHeaderView(View headerView) {
        if (headerView != null) {

        }
    }

    @Override
    protected int getHeaderLayoutId() {
        return getCommonHeaderLayoutId();
    }

    @Override
    protected void initHeaderView(View view) {
        initCommonHeaderViews(view);
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout == null) super.onBackPressed();

        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    protected void onPause() {
        lockDrawer();
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        unlockDrawer();
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        boolean handled = false;

/*        if (id == R.id.nav_how_it_works) {
        } else if (id == R.id.nav_terms) {
        } else if (id == R.id.nav_about_us) {
        } else*/
        /*if (id == R.id.currency_chest_contact_program_check) {
            launchChcpCheck();
        } else*/

        if (mDrawerLayout != null) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        }
        switch (id) {
            case R.id.mail_list:
                onClickMailList();
                handled = true;
                break;
            case R.id.notification_list:
                loadNotificationList();
                handled = true;
                break;

        }
        return handled;
    }

    private void loadNotificationList() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (BaseNavigationalActivity.this == null || BaseNavigationalActivity.this.isFinishing())
                    return;
            }
        }, 100);
    }

    private void onClickLogout() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (BaseNavigationalActivity.this == null || BaseNavigationalActivity.this.isFinishing())
                    return;
            }
        }, 100);

    }


    private void onClickMailList() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (BaseNavigationalActivity.this == null || BaseNavigationalActivity.this.isFinishing())
                    return;
            }
        }, 100);
    }

    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {

    }

    @Override
    public void onDrawerOpened(View drawerView) {

    }

    @Override
    public void onDrawerClosed(View drawerView) {

    }

    @Override
    public void onDrawerStateChanged(int newState) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.header_left_img:
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.base_drawer_layout);
                drawer.openDrawer(GravityCompat.START);
                break;

            case R.id.header_right_img:

                break;
        }
    }

    public void setUserName() {
        if (mUserName != null) {
            String userName = PreferenceUtils.getString(getApplicationContext(), PreferenceUtils.PREFERENCE_KEY_USER_NAME);
            if (userName != null && !TextUtils.isEmpty(userName)) {
                userName = userName.substring(0, 1).toUpperCase() + userName.substring(1);
            } else {
                userName = "User";
            }
            mUserName.setText("Hi " + userName);
        }
    }

    public void setAppVersion() {
        if (mVersion != null) {
            try {
                mVersion.setText("Version " + Utils.getAppVersion(getApplicationContext()));
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
