package com.hzb.myapplication.application;

import android.app.DownloadManager;
import android.content.Context;
import android.content.IntentFilter;

import androidx.multidex.MultiDexApplication;

/**
 * @description
 * @author Created by houzhengbang
 * @desc :全局变量--它的生命周期就等于这个程序的生命周期
 */
public class MyApplication extends MultiDexApplication {

    private static Context mContext;
    private static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();

        mContext = getApplicationContext();

    }
    public static Context getContext() {
        return mContext;
    }

    public static synchronized MyApplication getInstance() {
        return instance;
    }

}
