package com.lendingKart.network;

import android.text.TextUtils;


import com.lendingKart.network.apimodels.APIError;

import java.io.IOException;
import java.lang.annotation.Annotation;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;

/**
 * Extend this class to handle callbacks for specific API call.
 *
 */
public abstract class BaseCallback<T> implements Callback<T> {

    protected ResultNotifiers.IBaseNotifier mNotifier;

    public BaseCallback(ResultNotifiers.IBaseNotifier notifier) {
        mNotifier = notifier;
    }

    /**
     * On Success request.
     *
     * @param model    response model
     * @param call     call
     * @param response response
     */
    public abstract void onSuccessResponse(T model, Call<T> call, Response<T> response);

    /**
     * Got failure response
     *
     * @param error    parsed error object
     * @param call     call
     * @param response response
     */
    void onFailureResponse(APIError error, Call<T> call, Response<T> response) {
        if (error != null) {
            notifyError(error.message());
        } else {
            notifyError("Failed to retrieve response. Please try later.");
        }
    }

    /**
     * Network error.
     *
     * @param call      call
     * @param throwable
     */
    void onNetworkError(Call<T> call, Throwable throwable) {
        notifyError("Network error. Please try later.");
    }

    public void notifyError(String message) {
        if (mNotifier != null) {
            if (TextUtils.isEmpty(message)) message = "Unknown error. Please try later.";
            mNotifier.onErrorMessage(message);
        }
    }

    /**
     * Unknown error
     *
     * @param call
     * @param throwable
     */
    public void onUnknownError(Call<T> call, Throwable throwable) {
        notifyError("Unknown Error. Please try later.");
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            onSuccessResponse(response.body(), call, response);
        } else {
            APIError error = parseError(response);
            onFailureResponse(error, call, response);
        }
    }

    private APIError parseError(Response<?> response) {
        Converter<ResponseBody, APIError> converter =
                LendingkartServiceGenerator.getInstance()
                        .getRetrofit()
                        .responseBodyConverter(APIError.class, new Annotation[0]);
        APIError error;
        try {
            error = converter.convert(response.errorBody());
        } catch (IOException e) {
            error = new APIError();
            error.setMessage("Failed to parse error");
            return new APIError();
        }
        return error;
    }


    @Override
    public void onFailure(Call<T> call, Throwable throwable) {
        if (throwable != null && throwable instanceof IOException) {
            onNetworkError(call, throwable);
        } else {
            onUnknownError(call, throwable);
        }
    }

    void notifySessionExpiry(String message) {
        if (mNotifier != null) {
            if (TextUtils.isEmpty(message)) message = "Session expired. Please Login again.";
            mNotifier.onSessionExpired(message);
        }
    }
}
