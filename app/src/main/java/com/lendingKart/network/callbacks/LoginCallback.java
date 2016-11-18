package com.lendingKart.network.callbacks;

import com.lendingKart.network.BaseCallback;
import com.lendingKart.network.ResultNotifiers;
import com.lendingKart.network.apimodels.Login;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Lendingkart on 11/17/2016.
 */

public class LoginCallback extends BaseCallback<Login.Response> {

    public LoginCallback(ResultNotifiers.IBaseNotifier notifier) {
        super(notifier);
    }

    @Override
    public void onSuccessResponse(Login.Response model, Call<Login.Response> call, Response<Login.Response> response) {
        if (model != null) {
            notifyResponse(model);
        } else {
            notifyError("Failed to fetch response");
        }
    }

    private void notifyResponse(Login.Response model) {
        if (mNotifier != null && mNotifier instanceof ResultNotifiers.ILoginResultNotifier) {
            ((ResultNotifiers.ILoginResultNotifier) mNotifier).onLoginResponse(model);
        }
    }
}
