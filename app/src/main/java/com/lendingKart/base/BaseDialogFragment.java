package com.lendingKart.base;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.Window;
import android.view.WindowManager;

import com.lendingKart.R;


public abstract class BaseDialogFragment extends DialogFragment {

    public abstract int getLayoutId();

    public abstract void initViews(Dialog dialog);

    protected IFragmentInteractionListener mFragmentInteractionListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mFragmentInteractionListener = (IFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = initDialog();
        initViews(dialog);
        return dialog;
    }

    private Dialog initDialog() {
        Dialog dialog = new Dialog(getActivity(), R.style.DialogTheme);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        dialog.setContentView(getLayoutId());
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        return dialog;
    }
}
