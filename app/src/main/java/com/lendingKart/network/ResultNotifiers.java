package com.lendingKart.network;


import com.lendingKart.network.apimodels.Login;

public class ResultNotifiers {
    /**
     * Result notifier for API service.
     * Extend this notifier for different services.
     */
    public interface IBaseNotifier {
        void onErrorMessage(String errorMessage);

        void onSessionExpired(String errorMessage);
    }

    public interface ILoginResultNotifier extends IBaseNotifier {
        void onLoginResponse(Login.Response response);
    }

}
