package com.hzb.myapplication.api;

import com.google.gson.JsonSyntaxException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

/**
 * FileName: ApiException
 * Author: houzhengbang
 * Date: 2020-05-27 13:56
 * Description: 网络请求 状态码处理
 */
public class ApiException {


    public ApiException() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }


    public static String getThrowable(Throwable e) {
        String message = "";
        if ((e instanceof UnknownHostException)) {
            message = "网络异常";

        } else if (e instanceof JsonSyntaxException) {
            message = "数据异常";
        } else if (e instanceof SocketTimeoutException) {
            message = "连接超时";
        } else if (e instanceof ConnectException) {
            message = "连接服务器失败";
        } else {
            message = e.getMessage();
        }
        return message;
    }

    /**
     * 由于服务器传递过来的错误信息直接给用户看的话，用户未必能够理解
     * 需要根据错误码对错误信息进行一个转换，再显示给用户
     *
     * @param code
     * @return
     */
    public static String getApiExceptionMessage(BaseBean code) {
        String message = "";
        switch (Integer.parseInt(code.getErrorCode().trim())) {
            case ABNORMAL_DATA:
                message = "获取数据异常";
                break;
            case ILLEGAL_PARAMETER:
                message = "非法参数";
                break;
            case MISSING_PARAMETER:
                message = "缺少必须的参数";
                break;
            case DATA_CONVERSION_ERROR:
                message = "数据转化错误";
                break;
            case ACCOUNT_DOES_NOT_EXISTS:
                message = "账号不存在";
                break;
            case ACCOUNT_ALREADY_EXISTS:
                message = "账号存在";
                break;
            case PHONE_ALREADY_EXISTS:
                message = "手机号已存在";
                break;
            case ACCOUNT_LOCKED:
                message = "账户已锁定";
                break;
            default:
                message = "未知错误";
                break;
        }
        return message;
    }

    public static final int ABNORMAL_DATA = 500;//	获取数据异常
    public static final int ILLEGAL_PARAMETER = 1003;//	非法参数
    public static final int MISSING_PARAMETER = 4002;//	缺少必须的参数
    public static final int DATA_CONVERSION_ERROR = 4003;//	数据转化错误
    public static final int ACCOUNT_DOES_NOT_EXISTS = 5001;//	账号不存在
    public static final int ACCOUNT_ALREADY_EXISTS = 5002;//	账号已存在
    public static final int PHONE_ALREADY_EXISTS = 5006;//	手机号已存在
    public static final int ACCOUNT_LOCKED = 5013;//	账户已锁定




    /**
     * 500	获取数据异常	很大可能性是后台代码错误返回异常
     * 1001	请求标识对象不存在	传的id对应的数据没有
     * 1003	非法参数	不是指定的几个参数
     * 4002	缺少必须的参数	需要传的参数没有传
     * 4003	数据转化错误	1. 传参类型不正确 如： int类型传的是 string
     * 2.数据类型不正确，如json格式，传的其他方式
     * 5001	5001	账号不存在
     * 5002	5002	账号已存在
     * 5006	5006	手机号已存在
     * 5013	账户已锁定	账号状态为不可用的状态
     * ——	——-	更多待补充
     * 7500	积分不足	积分不足
     * ——	——-	更多待补充
     * 60601	已添加到购物车	已添加到购物车
     */
}