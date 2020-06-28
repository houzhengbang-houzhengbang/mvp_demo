package com.hzb.myapplication.ui.login;

import android.content.Context;

import com.hzb.myapplication.api.OnHttpCallBack;
import com.hzb.myapplication.bean.LoginBean;
import com.hzb.myapplication.body.LoginBody;

/**
 * FileName: LoginModel
 * Author: houzhengbang
 * Date: 2020-05-27 10:17
 * Description:
 */
/**
 *  登录的桥梁(View和Model的桥梁)-------P通过将V拿到的数据交给M来处理  P又将处理的结果回显到V
 *  说白点就是P中new出M和V 然后通过调用它们两个的方法来完成操作
 */
public class LoginControl {

    /**
     * V视图层
     */
    interface ILoginView {
        Context getContent();
        LoginBody getUserINfo();
    }

    /**
     * 逻辑处理层
     */
    interface ILoginModel {
        void login(Context content, LoginBody userInfo, OnHttpCallBack<LoginBean> callBack);//登录
    }

    /**
     * P视图与逻辑处理的连接层
     */
    interface ILoginPresenter {
        void login();
    }
}
