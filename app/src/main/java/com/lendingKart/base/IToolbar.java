package com.lendingKart.base;

import android.view.View;

public interface IToolbar {

    int getHeaderLeftIconId();

    int getHeaderRightIconId();

    View.OnClickListener getHeaderViewClickListener();

    String getToolbarTitleId();
}
