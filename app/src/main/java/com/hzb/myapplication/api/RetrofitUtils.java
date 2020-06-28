package com.hzb.myapplication.api;


import android.text.TextUtils;
import android.util.Log;

import com.hzb.myapplication.application.Content;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @description
 * @author Created by houzhengbang
 * @desc :Retofit网络请求工具类
 */
public class RetrofitUtils {
    private static final int READ_TIMEOUT = 15;//读取超时时间,单位  秒
    private static final int WRITE_TIMEOUT = 15;//输出超时时间,单位  秒
    private static final int CONN_TIMEOUT = 5;//连接超时时间,单位  秒


    public static OkHttpClient okHttpClient = new OkHttpClient()
            .newBuilder()
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS) //设置读取时间为60S
            .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)//设置输出时间为60S
            .connectTimeout(CONN_TIMEOUT, TimeUnit.SECONDS)//设置连接时间为12s
            .addInterceptor(genericClient())
            .build();


    static class RetrofitInstance {
        private static APIService api = new Retrofit.Builder()
                .baseUrl(Content.BASEURL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(APIService.class);
    }

    //得到Server对象
    public static APIService getServer() {
        return RetrofitInstance.api;
    }

    public static HttpLoggingInterceptor genericClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                if (TextUtils.isEmpty(message)) {
                    return;
                }
                //打印json数据
                Log.i("HttpLoggingInterceptor", "log: " + message);
            }
        });
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }
}
