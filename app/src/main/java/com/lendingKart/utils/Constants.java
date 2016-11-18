package com.lendingKart.utils;

/**
 * Created by Andy on 3/4/2016.
 */
public class Constants {
    public static final String KEY_COMPLAINT = "complaint";
    public static final String KEY_USER_ID = "userId";
    public static final String KEY_PASSWORD = "password";

    public static final int NEW_VERSION_AVAILABLE = 1;
    public static final int OPTIONAL_UPDATE = 2;
    public static final int FORCE_UPDATE = 3;
    public static final int UPDATED_VERSION = 0;

    //10 minute
    public static final long COMPLAIN_FORCE_UPDATE_INTERVAL = 600000;
    //10 minute
    public static final long MAIL_LIST_FORCE_UPDATE_INTERVAL = 600000;


    public static final String LATITUDE = "latitude";
    public static final String LONGITUDE = "longitude";

    public static final String KEY_PM_SCHEDULE = "pmSchedule";
    public static final String KEY_DAILY_COLLECTION = "bundleDailyCollection";
    public static final String KEY_LOGOUT = "logout";

    public static final String DYNAMIC_REPORT_TYPE_WEB = "Web";
    public static final String DYNAMIC_REPORT_TYPE_NATIVE = "Nativ";


    public static final int SUCCESS_RESULT = 0;
    public static final int FAILURE_RESULT = 1;
    public static final String PACKAGE_NAME =
            "com.dental.justdental.location.FetchAddressIntentService";
    public static final String RECEIVER = PACKAGE_NAME + ".RECEIVER";
    public static final String RESULT_DATA_KEY = PACKAGE_NAME +
            ".RESULT_DATA_KEY";
    public static final String LOCATION_DATA_EXTRA = PACKAGE_NAME +
            ".LOCATION_DATA_EXTRA";


    public static final String KEY_NOTIFICATION = "fcm_message";

    public static final String NOTIFICATION_KEY_TITLE = "title";
    public static final String NOTIFICATION_KEY_BODY = "body";
}
