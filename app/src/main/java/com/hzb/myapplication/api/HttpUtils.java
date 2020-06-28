package com.hzb.myapplication.api;



import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * FileName: HttpUtilss
 * Author: houzhengbang
 * Date: 2020-05-27 13:10
 * Description: 网络请求  封装类
 */
public class HttpUtils {
    //请求网络
    public static<T> void getData(Observable<T> observable, ObserverUtils<T> observer){
        observable.observeOn(AndroidSchedulers.mainThread())    //在主线程处理数据
//                .subscribeOn(Schedulers.io())                   //在子线程请求数据
                .subscribeOn(Schedulers.newThread())                   //在新 线程请求数据
                .subscribe(observer);

    }
}
