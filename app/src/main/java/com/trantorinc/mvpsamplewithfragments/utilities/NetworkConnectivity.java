package com.trantorinc.mvpsamplewithfragments.utilities;

/**
 * Created by neelmani.karn on 5/6/2015.
 */

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.trantorinc.mvpsamplewithfragments.R;
import com.trantorinc.mvpsamplewithfragments.logger.AppLogger;

public final class NetworkConnectivity {

    static Context context;
    private static NetworkConnectivity instance = new NetworkConnectivity();
    ConnectivityManager connectivityManager;

    public static NetworkConnectivity getInstance(Context ctx) {
        context = ctx;
        return instance;
    }

    /**
     * Check if internet connection is available or not
     *
     * @return true if internet is available else false
     */
    public boolean isInternetConnectionAvaliable() {
        if (null == context) {
            return true;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        // test for connection
        NetworkInfo netInfo = null;
        if (null != connectivityManager) {
            netInfo = connectivityManager.getActiveNetworkInfo();
        }
        if (null != netInfo && netInfo.isAvailable() && netInfo.isConnected()) {
            return true;
        } else {
            AppLogger.logInfo(context.getString(R.string.noInternet));
            return false;
        }
    }
}