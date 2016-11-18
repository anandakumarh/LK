package com.lendingKart.network;


import com.lendingKart.network.apimodels.Login;
import com.lendingKart.utils.Configuration;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Define all APIs here one by one. Every URL and API methods must be defined here.
 *
 */
interface LendingkartService {
    String BASE_URL = Configuration.CONFIGURABLE_BASE_URL;

    @POST(UrlConstants.LOGIN_URL)
    Call<Login.Response> login(@Body Login.Request request);

}
