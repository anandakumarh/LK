package com.lendingKart.network;

import com.lendingKart.network.apimodels.Login;
import com.lendingKart.network.callbacks.LoginCallback;

import retrofit2.Call;

public class LendingkartServiceManager {
    private static LendingkartServiceManager sManager;

    private LendingkartServiceManager() {

    }

    public static LendingkartServiceManager getInstance() {
        if (sManager == null) {
            sManager = new LendingkartServiceManager();
        }
        return sManager;
    }

    public Call performLogin(Login.Request request, ResultNotifiers.ILoginResultNotifier notifier) {
        Call<Login.Response> loginCall = LendingkartServiceGenerator.getInstance().getService()
                .login(request);
        loginCall.enqueue(new LoginCallback(notifier));
        return loginCall;
    }

}