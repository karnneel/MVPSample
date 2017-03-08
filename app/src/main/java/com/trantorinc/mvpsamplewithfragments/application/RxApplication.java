package com.trantorinc.mvpsamplewithfragments.application;

import android.app.Application;

import com.trantorinc.mvpsamplewithfragments.networkservice.NetworkService;


public class RxApplication extends Application {

    private static NetworkService networkService;

    @Override
    public void onCreate() {
        super.onCreate();

        networkService = new NetworkService();

    }

    public static NetworkService getNetworkService() {
        return networkService;
    }


}