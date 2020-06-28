package com.hzb.myapplication.api;

/**
 * @description
 * @author Created by houzhengbang
 * @desc :数据格式  公共类
 */
public class BaseBean<T> {

    /**
     * "result": "fail",
     * "errorCode": "4002",
     *  "errorMsg": "缺少必须的参数"
     */
    protected String result;
    protected String errorCode;
    protected String errorMsg;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
