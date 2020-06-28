package com.hzb.myapplication.base;

import android.app.Activity;

/**
 * FileName: BaseActivity
 * Author: houzhengbang
 * Date: 2020-05-27 10:15
 * Description: 
 */
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.hzb.myapplication.utils.activityManager.AppManager;
import com.hzb.myapplication.utils.immersionUtil.titleBar.SystemBarUtils;


/**
 * @author Created by houzhengbang
 * @description
 * @desc :baseActivity  全局页面 统一处理
 */
public abstract class BaseActivity extends AppCompatActivity {


    public Activity mActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;


//        StatusBarUtil.setImmersiveStatusBar(this, true);//字体颜色true  黑色  false  白色
////        StatusBarUtil.setTranslucentStatus(this);  // 设置状态栏透明      只设置透明时,整体会上移置顶  透明  和  状态蓝颜色只能设置一个,否则会影响字体颜色
//        StatusBarUtil.setStatusBarColor(this, Color.WHITE);//设置状态栏的颜色


        SystemBarUtils.immersiveStatusBar(this,0);
        AppManager.getInstance().addActivity(this);//添加当前Activity
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        AppManager.getInstance().removeActivity(this);//移除当前Activity
    }


    /**
     * 获取状态栏高度
     *
     * @return
     */
    public  int getStatusBarHeight() {
        //获取status_bar_height资源的ID
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            //根据资源ID获取响应的尺寸值
            return getResources().getDimensionPixelSize(resourceId);
        }
        return 0;
    }
}
