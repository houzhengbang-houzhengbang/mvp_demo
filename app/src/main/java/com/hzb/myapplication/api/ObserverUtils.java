package com.hzb.myapplication.api;


import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;

import com.hzb.myapplication.application.Content;
import com.hzb.myapplication.view.dialog.Loading_view;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


/**
 * @author Created by houzhengbang
 * @description
 * @desc :封装 Observer(内容观察者)  监听数据的变化
 */
public abstract class ObserverUtils<T> implements Observer<T> {

    public static final String TAG = "ObserverUtils-";


    private boolean isShow = false;
    private Loading_view dialog;
    private Context mContent;


    public ObserverUtils(Context mContent, boolean flag) {
        this.isShow = flag;
        this.mContent = mContent;
    }


    @Override
    public void onComplete() {
        if (isShow) {
            if (dialog != null)
                dialog.dismiss();
        }
    }

    @Override
    public void onSubscribe(final Disposable d) {
        if (isShow) {
            dialog = new Loading_view(mContent);
            dialog.setIndeterminate(true);
            dialog.setCanceledOnTouchOutside(false);
            dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialogInterface) {
                    // 对话框取消 直接停止执行请求
                    if (!d.isDisposed()) {
                        d.dispose();
                    }
                }
            });
            dialog.show();
        }
    }

    @Override
    public void onNext(T t) {
        //加判空，防止网络请求返回空的情况
        if (t != null && t instanceof BaseBean) {
            BaseBean baseBean = (BaseBean) t;
            Log.i(TAG, "onNext====" + baseBean.getResult());
            if (baseBean.getResult().equals(Content.FAIL)) {
                Log.e(TAG, "onNext: " + ApiException.getApiExceptionMessage(baseBean));
            }
            //请求正常
            onHSuccess(t);
        }
    }

    //将错误集中处理，或者将错误返回  单独处理
    @Override
    public void onError(Throwable e) {

        Log.e(TAG, "onError: " + ApiException.getThrowable(e));

        if (isShow) {
            if (dialog != null)
                dialog.dismiss();
        }
    }

    public abstract void onHSuccess(T t);//成功了就回调这个方法,可以传递任何形式的数据给调用者

//    public abstract void onHError(Throwable t);//失败了就调用这个方法,可以传递错误的请求消息给调用者
}