package com.lendingKart.ui.login;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.lendingKart.R;
import com.lendingKart.base.BaseActivity;

public class LoginActivity extends BaseActivity
{

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
        setContentView(R.layout.activity_login);
    }


}
