package com.hzb.myapplication.api;

/**
 * FileName: OnHttpCallBack
 * Author: houzhengbang
 * Date: 2020-05-27 16:39
 * Description: 网络请求返回 数据后  获取数据-回调至P层进行处理
 */
public  interface OnHttpCallBack<T> {
    void onSuccessful(T t);//成功了就回调这个方法,可以传递任何形式的数据给调用者
    void onFaild(Throwable t );//失败了就调用这个方法,可以传递错误的请求消息给调用者
}
