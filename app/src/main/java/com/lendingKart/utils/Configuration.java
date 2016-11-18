package com.lendingKart.utils;

import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by Lendingkart on 11/17/2016.
 */

public class Configuration {
    public static final String CONFIGURABLE_BASE_URL = "";
    public static HttpLoggingInterceptor.Level HTTP_LOG_LEVEL = HttpLoggingInterceptor.Level.BODY;
    public static boolean ENABLE_LOGS = true;

    //connection Timeout 6s
    public static long CONNECTION_TIME_OUT_MILI = 5000;
}
