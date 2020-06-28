package com.hzb.myapplication.ui.main;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.hzb.myapplication.R;
import com.hzb.myapplication.application.MyApplication;
import com.hzb.myapplication.base.BaseActivity;
import com.hzb.myapplication.ui.splash.SplashActivity;
import com.hzb.myapplication.utils.immersionUtil.titleBar.SystemBarUtils;
import com.hzb.myapplication.utils.immersionUtil.titleBar.TranslucentActionBar;
import com.hzb.myapplication.utils.statusbarUtil.StatusBarUtil;

public class MainActivity extends BaseActivity {
    private BottomNavigationView bottomNavigationView;
    private HomeFragment work_fragment;
    private MyFragment message_fragment;
    private Fragment[] fragments;
    private int lastfragment;//用于记录上个选择的Fragment

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        SystemBarUtils.immersiveStatusBar(this, 0);

//        StatusBarUtil.setStatusBarColor(MainActivity.this, Color.rgb(255, 210, 117));//设置状态栏的颜色

        initFragment();

//
//        TranslucentActionBar actionBar = (TranslucentActionBar) findViewById(R.id.actionbar);
//        //初始actionBar
//        actionBar.setData("测试", 0, null, 0, null, null);
        //开启渐变
//          actionBar.setNeedTranslucent();
        //设置状态栏高度
//          actionBar.setStatusBarHeight(SystemBarUtils.getStatusBarHeight(mContext));

//          translucentScrollView = (TranslucentScrollView) findViewById(R.id.pullzoom_scrollview);
//          //设置透明度变化监听
//          translucentScrollView.setTranslucentChangedListener(this);
//          //关联需要渐变的视图
//          translucentScrollView.setTransView(actionBar);
//          //设置ActionBar键渐变颜色
//          translucentScrollView.setTransColor(getResources().getColor(R.color.orange_dft));
//
//          zoomView = findViewById(R.id.lay_header);
//          //关联伸缩的视图
//          translucentScrollView.setPullZoomView(zoomView);


    }


    private void initFragment() {
        work_fragment = new HomeFragment();
        message_fragment = new MyFragment();
        fragments = new Fragment[]{ work_fragment,message_fragment};
        lastfragment = 0;
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_fragment, work_fragment).show(work_fragment).commit();
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(changeFragment);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener changeFragment = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.action_message: {
                    if (lastfragment != 0) {
                        switchFragment(lastfragment, 0);
                        lastfragment = 0;
//                        StatusBarUtil.setStatusBarColor(MainActivity.this, Color.rgb(255, 210, 117));//设置状态栏的颜色

                    }
                    return true;
                }
                case R.id.action_work: {
                    if (lastfragment != 1) {
                        switchFragment(lastfragment, 1);
                        lastfragment = 1;
//                        StatusBarUtil.setStatusBarColor(MainActivity.this, Color.rgb(253, 110, 100));//设置状态栏的颜
                    }
                    return true;
                }
            }
            return false;
        }
    };


    //切换Fragment
    private void switchFragment(int lastfragment, int index) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.hide(fragments[lastfragment]);//隐藏上个Fragment
        if (fragments[index].isAdded() == false) {
            transaction.add(R.id.frame_fragment, fragments[index]);
        }
        transaction.show(fragments[index]).commitAllowingStateLoss();
    }

}
