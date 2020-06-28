package com.hzb.myapplication.ui.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.WindowManager;

import com.hzb.myapplication.R;
import com.hzb.myapplication.base.BaseActivity;
import com.hzb.myapplication.ui.guide.GuideActivity;
import com.hzb.myapplication.ui.login.LoginActivity;
import com.hzb.myapplication.utils.statusbarUtil.StatusBarUtil;


/**
 * @description
 * @author Created by houzhengbang
 * @desc :欢迎页
 */
public class SplashActivity extends BaseActivity implements  SplashControl.ISplashView {

    private SplashPresenter splashPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_start_page);

        //全屏
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN); //隐藏状态栏
//        StatusBarUtil.setTranslucentStatus(this);  // 设置状态栏透明      只设置透明时,整体会上移置顶  透明  和  状态蓝颜色只能设置一个,否则会影响字体颜色



//        StatusBarUtil.setImmersiveStatusBar(this, true);//字体颜色true  黑色  false  白色
//        StatusBarUtil.setTranslucentStatus(this);  // 设置状态栏透明      只设置透明时,整体会上移置顶  透明  和  状态蓝颜色只能设置一个,否则会影响字体颜色
//        StatusBarUtil.setStatusBarColor(this, Color.WHITE);//设置状态栏的颜色
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN); //隐藏状态栏



        splashPresenter = new SplashPresenter(this);
        splashPresenter.timing();

    }

    @Override
    public Context getContent() {
        return this;
    }

    @Override
    public void toLogin() {
        goHome();
    }

    /**
     * 跳转到主页面
     */
    private void goHome() {
        startActivity(new Intent(SplashActivity.this, GuideActivity.class));
        finish();// 销毁当前活动界面
    }
}
