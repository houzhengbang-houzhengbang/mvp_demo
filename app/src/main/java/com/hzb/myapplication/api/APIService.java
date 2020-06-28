package com.hzb.myapplication.api;

import com.hzb.myapplication.bean.LoginBean;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

import static com.hzb.myapplication.application.Content.login;

/**
 * @description
 * @author Created by houzhengbang
 * @desc :API--接口  服务[这里处理的是同一的返回格式 resultCode  resultInfo Data<T> --->这里的data才是返回的结果,T就是泛型 具体返回的been对象或集合]
 */
public interface APIService {
    /**
     * 用户登录的接口
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(login)
    Observable<LoginBean> userLogin(@Body RequestBody body);

}
