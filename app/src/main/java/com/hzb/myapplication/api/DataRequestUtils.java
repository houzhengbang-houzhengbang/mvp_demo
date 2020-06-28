package com.hzb.myapplication.api;

import com.google.gson.Gson;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * FileName: DataRequestUtils
 * Author: houzhengbang
 * Date: 2020-05-27 19:27
 * Description: @RequestBody主要用来接收前端传递给后端的json字符串中的数据的(请求体中的数据的)；
 */
public class DataRequestUtils {

    public static <T> RequestBody getRequest(T data) {
        Gson gson = new Gson();
        String toJson = gson.toJson(data);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), toJson);
        return requestBody;
    }
}
