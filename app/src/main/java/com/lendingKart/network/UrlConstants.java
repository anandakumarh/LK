package com.lendingKart.network;

import com.lendingKart.BuildConfig;

/**
 * Created by Lendingkart on 11/17/2016.
 */

public class UrlConstants {

    public static final String LOGIN_URL ="";
    public static boolean DEBUG_MODE = BuildConfig.DEBUG;
    public static boolean ACCEPT_ALL_CERTIFICATES = DEBUG_MODE;


    // implemented product flavor
    private static boolean isDevMode = false;

    private static final String BASE_URL_STAGING = "";
    private static final String BASE_URL_PRODUCTION = "";
    public static String getBaseUrl() {
        return (isDevMode) ? BASE_URL_STAGING : BASE_URL_PRODUCTION;
    }

    public static final boolean ENABLE_LOGS = true;
}
