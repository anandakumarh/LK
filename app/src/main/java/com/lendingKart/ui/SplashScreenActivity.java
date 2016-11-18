package com.lendingKart.ui;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.crashlytics.android.Crashlytics;
import com.lendingKart.R;
import com.lendingKart.base.BaseActivity;
import com.lendingKart.ui.login.LoginActivity;
import io.fabric.sdk.android.Fabric;

public class SplashScreenActivity extends BaseActivity {

    @Override
    protected int getHeaderLayoutId() {
        return getCommonHeaderLayoutId();
    }

    @Override
    protected void initHeaderView(View view) {
        initCommonHeaderViews(view);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        addContentView(R.layout.activity_splash_screen);
        launchNextScreen();
    }

    /**
     * Method which introduces delay
     */
    private void launchNextScreen() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                launchHomeScreen();
            }
        }, 1000);

    }

    /**
     * Method which launches Home Screen
     */
    private void launchHomeScreen() {
        Intent intent = new Intent(SplashScreenActivity.this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        overridePendingTransition(R.anim.exit_anim, R.anim.exit_anim);
    }
}
