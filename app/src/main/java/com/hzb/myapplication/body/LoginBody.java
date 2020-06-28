package com.hzb.myapplication.body;

/**
 * FileName: LoginBody
 * Author: houzhengbang
 * Date: 2020-05-27 11:41
 * Description:
 */
public class LoginBody {
    private int app;

   private int position;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getApp() {
        return app;
    }

    public void setApp(int app) {
        this.app = app;
    }

    public LoginBody(int app, int position) {
        this.app = app;
        this.position = position;
    }

    public LoginBody(int app) {
        this.app = app;
//        this.position = position;
    }
}
