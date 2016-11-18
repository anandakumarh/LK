package com.lendingKart.network;


import com.lendingKart.utils.Configuration;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class LendingkartServiceGenerator {
    private Retrofit retrofit;
    private static LendingkartServiceGenerator sServerInstance;

    private LendingkartServiceGenerator() {
        OkHttpClient.Builder sHttpClient = new OkHttpClient.Builder();
        HttpLoggingInterceptor sLogging = new HttpLoggingInterceptor();
        sLogging.setLevel(Configuration.HTTP_LOG_LEVEL);
        sHttpClient.addInterceptor(sLogging);

        sHttpClient.connectTimeout(Configuration.CONNECTION_TIME_OUT_MILI, TimeUnit.MILLISECONDS);

        Retrofit.Builder builder =
                new Retrofit.Builder()
                        .baseUrl(Configuration.CONFIGURABLE_BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create());

        retrofit = builder
                .client(sHttpClient.build())
                .build();
    }

    /* Package Access */
    static LendingkartServiceGenerator getInstance() {
        if (sServerInstance == null) {
            sServerInstance = new LendingkartServiceGenerator();
        }
        return sServerInstance;
    }

    /* Package Access */
    LendingkartService getService() {
        return retrofit.create(LendingkartService.class);
    }

    /* Package Access */
    Retrofit getRetrofit() {
        return retrofit;
    }


}