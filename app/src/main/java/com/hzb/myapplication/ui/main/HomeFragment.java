package com.hzb.myapplication.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.hzb.myapplication.R;
import com.hzb.myapplication.base.BaseActivity;
import com.hzb.myapplication.utils.immersionUtil.titleBar.SystemBarUtils;
import com.hzb.myapplication.utils.immersionUtil.titleBar.TranslucentActionBar;
import com.hzb.myapplication.view.custom.IncludeMyViewLayout;

/**
 * FileName: HomeFragment
 * Author: houzhengbang
 * Date: 2020-05-28 20:03
 * Description:
 */
public class HomeFragment extends Fragment {

    private LinearLayout llRoot;
    private MainActivity mContext;
    private View view;
    private IncludeMyViewLayout includeMyViewLayout;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, null);
        mContext = (MainActivity) getActivity();


        llRoot = (LinearLayout) view.findViewById(R.id.ll_root);

        initsView();


        return view;
    }

    private void initsView() {



        TranslucentActionBar actionBar = (TranslucentActionBar) view.findViewById(R.id.actionbar);
        //初始actionBar
        actionBar.setData("测试", 0, null, 0, null, null);
        //开启渐变
//          actionBar.setNeedTranslucent();
        //设置状态栏高度
        actionBar.setStatusBarHeight(SystemBarUtils.getStatusBarHeight(mContext));

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

//        SystemBarUtils.setPadding(mContext, actionBar);

    }
}
