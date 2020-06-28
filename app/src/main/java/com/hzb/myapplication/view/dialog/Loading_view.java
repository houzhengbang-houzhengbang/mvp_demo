package com.hzb.myapplication.view.dialog;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import com.hzb.myapplication.R;


/**
 * FileName: Loading_view
 * Author: houzhengbang
 * Date: 2020-03-24 14:04
 * Description:加载框
 */
public class Loading_view extends ProgressDialog {
    private TextView viewById;
    public Loading_view(Context context) {
        super(context, R.style.DialogTheme);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init(getContext());
    }

    private void init(Context context) {
        setCancelable(true);
        setCanceledOnTouchOutside(false);

        setContentView(R.layout.loading);//loading的xml文件
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        getWindow().setAttributes(params);


        viewById = findViewById(R.id.tv_load_dialog);

        viewById.setText(title);
    }
    private String title;

    public void setTitle (String title){
       this. title = title;

       if(viewById!=null){
           viewById.setText(title);

       }
    }
}