package com.hzb.myapplication.ui.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.hzb.myapplication.R;
import com.hzb.myapplication.base.BaseActivity;
import com.hzb.myapplication.body.LoginBody;
import com.hzb.myapplication.ui.main.MainActivity;


/**
 * 登录页面
 * --------M层   对P层传递过来的userInfo进行登录(网络请求)判断,处理完成之后将处理结果回调给P层
 * --------P层   传递完数据给M层处理之后,实例化回调对象,成功了就通知V层登录成功,失败了就通知V层显示错误信息
 * --------V层   负责响应用户的交互(获取数据---->提示操作结果)
 */

/**
 * @description
 * @author Created by houzhengbang
 * @desc :登录页
 */
public class LoginActivity extends BaseActivity implements LoginControl.ILoginView {

    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();

        loginPresenter = new LoginPresenter(this);

        loginPresenter.login();
    }



    private TextView mName;

    private void initView() {
        mName = (TextView) findViewById(R.id.name);
    }

    @Override
    public Context getContent() {
        return this;
    }

    @Override
    public LoginBody getUserINfo() {
        return new LoginBody(0);
    }


    public void login(View view) {
        startActivity(new Intent(LoginActivity.this,MainActivity.class));

        finish();
    }
}
