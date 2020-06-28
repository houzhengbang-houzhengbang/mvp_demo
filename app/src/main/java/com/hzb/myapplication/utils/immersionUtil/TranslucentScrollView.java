package com.hzb.myapplication.utils.immersionUtil;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ScrollView;

import com.hzb.myapplication.R;
import com.hzb.myapplication.utils.immersionUtil.utils.SizeUtils;

/**
 * Created by 晖仔(Milo) on 2017/2/13.
 * email:303767416@qq.com
 *
 * 搭配沉浸式使用   titlebar
 */

/**
 * 用法  一:
 * implements ActionBarClickListener, TranslucentScrollView.TranslucentChangedListener
 *
 *
 *   actionBar = (TranslucentActionBar) findViewById(R.id.actionbar);
 *         //初始actionBar
 *         actionBar.setData("测试", 0, null, 0, null, null);
 *         //开启渐变
 *         actionBar.setNeedTranslucent();
 *         //设置状态栏高度
 *         actionBar.setStatusBarHeight(getStatusBarHeight());
 *
 *         translucentScrollView = (TranslucentScrollView) findViewById(R.id.pullzoom_scrollview);
 *         //设置透明度变化监听
 *         translucentScrollView.setTranslucentChangedListener(this);
 *         //关联需要渐变的视图
 *         translucentScrollView.setTransView(actionBar);
 *         //设置ActionBar键渐变颜色
 *         translucentScrollView.setTransColor(getResources().getColor(R.color.orange_dft));
 *
 *         zoomView = findViewById(R.id.lay_header);
 *         //关联伸缩的视图
 *         translucentScrollView.setPullZoomView(zoomView);
 *
 *     public void onTranslucentChanged(int transAlpha) {
 *         actionBar.tvTitle.setVisibility(transAlpha > 48 ? View.VISIBLE : View.GONE);
 *     }
 *
 *     <RelativeLayout
 *     android:layout_width="match_parent"
 *     android:layout_height="match_parent">
 *
 *      <com.milo.lib.TranslucentScrollView
 *         android:id="@+id/pullzoom_scrollview"
 *         android:layout_width="match_parent"
 *         android:layout_height="wrap_content">
 *
 *         放置具体内容
 *         </com.milo.lib.TranslucentScrollView>
 *
 *
 *         //标题
 *           <com.milo.demo.widget.TranslucentActionBar
 *         android:id="@+id/actionbar"
 *         android:layout_width="match_parent"
 *         android:layout_height="wrap_content"
 *         android:background="@color/orange_dft" >
 *         </com.milo.demo.widget.TranslucentActionBar>
 *
 *          </RelativeLayout>
 */

/**
 *  用法 二 :
 *  mPullZoomView = (PullZoomView) findViewById(R.id.mPullZoomView);
 *         mActionBar = findViewById(R.id.mActionBar);
 *         mStatusBarHolder = findViewById(R.id.mStatusBarHolder);
 *         mTvTitle = findViewById(R.id.mTvTitle);
 *
 *
 *         //关联需要渐变的视图
 *         mPullZoomView.setHeaderView(R.layout.view_header);
 *         //渐变之后 的 视图
 *         mPullZoomView.addNormalView(R.layout.view_normal);//可以连续添加多个
 *         mPullZoomView.setDamping(0.2f, 0);
 *
 *
 *         //设置标题栏的高度--距屏幕顶部 否则会置顶
 *         ViewGroup.LayoutParams params = mStatusBarHolder.getLayoutParams();
 *         params.height += SystemBarUtils.getStatusBarHeight(this);
 *         mStatusBarHolder.setLayoutParams(params);
 *
 *         mTvTitle.setVisibility(View.GONE);
 *         //要渐变的  view  颜色   位置
 *         mPullZoomView.attachTransView(mActionBar, getResources().getColor(R.color.colorPrimary), -1, -1);
 *         //要渐变 的 透明度 到达一定值 后自行判断设置
 *         mPullZoomView.setTranslucentChangedListener(new TranslucentScrollView.TranslucentChangedListener() {
 *             @Override
 *             public void onTranslucentChanged(int transAlpha) {
 *                 mTvTitle.setVisibility(transAlpha > 48 ? View.VISIBLE : View.GONE);
 *             }
 *         });
 *         mPullZoomView.mLayoutTransSV.setVerticalScrollBarEnabled(false);
 *
 *
 *
 *         <RelativeLayout
 *     android:layout_width="match_parent"
 *     android:layout_height="match_parent">
 *
 *     <com.milo.lib.PullZoomView
 *         android:id="@+id/mPullZoomView"
 *         android:layout_width="match_parent"
 *         android:layout_height="wrap_content" />
 *
 *     <LinearLayout
 *         android:id="@+id/mActionBar"
 *         android:layout_width="match_parent"
 *         android:layout_height="wrap_content"
 *         android:background="@color/colorPrimary"
 *         android:orientation="vertical">
 *
 *         <View
 *             android:id="@+id/mStatusBarHolder"
 *             android:layout_width="match_parent"
 *             android:layout_height="0dp" />
 *
 *         <RelativeLayout
 *             android:layout_width="match_parent"
 *             android:layout_height="50dp">
 *
 *             <TextView
 *                 android:id="@+id/mTvTitle"
 *                 android:layout_width="wrap_content"
 *                 android:layout_height="wrap_content"
 *                 android:layout_centerInParent="true"
 *                 android:text="SecondDemoActivity"
 *                 android:textColor="@color/white"
 *                 android:textSize="17sp"
 *                 android:textStyle="bold" />
 *         </RelativeLayout>
 *     </LinearLayout>
 * </RelativeLayout>
 */


public class TranslucentScrollView extends ScrollView {
    static final String TAG = TranslucentScrollView.class.getSimpleName();

    //伸缩视图
    private View    zoomView;
    //伸缩视图初始高度
    private int     zoomViewInitHeight = 0;
    // 记录首次按下位置
    private float   mFirstPosition     = 0;
    // 是否正在放大
    private Boolean mScaling           = false;

    //渐变的视图
    private View transView;
    //渐变颜色
    private int  transColor  = Color.WHITE;
    //渐变开始位置
    private int  transStartY = 50;
    //渐变结束位置
    private int  transEndY   = 300;

    //渐变开始默认位置，Y轴，50dp
    public final int DFT_TRANSSTARTY  = 50;
    //渐变结束默认位置，Y轴，300dp
    public final int DFT_TRANSENDY    = 300;
    //默认阻力开始生效距离
    public final int DFT_DAMPDISTANCE = 50;

    //阻力系数
    private float mDamping       = 0.0f;
    //阻力生效距离
    private int   mDamplDistance = 0;

    private TranslucentScrollView.TranslucentChangedListener translucentChangedListener;

    public interface TranslucentChangedListener {
        /**
         * 透明度变化，取值范围0-255
         *
         * @param transAlpha
         */
        void onTranslucentChanged(int transAlpha);
    }

    public TranslucentScrollView(Context context) {
        super(context);
    }

    public TranslucentScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mDamplDistance = SizeUtils.dip2px(context, DFT_DAMPDISTANCE);
    }

    public TranslucentScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setTranslucentChangedListener(TranslucentScrollView.TranslucentChangedListener translucentChangedListener) {
        this.translucentChangedListener = translucentChangedListener;
    }

    /**
     * 设置伸缩视图
     *
     * @param zoomView
     */
    public void setPullZoomView(View zoomView) {
        this.zoomView = zoomView;
        zoomViewInitHeight = zoomView.getLayoutParams().height;
        if (zoomViewInitHeight == LayoutParams.MATCH_PARENT || zoomViewInitHeight == WindowManager.LayoutParams.WRAP_CONTENT) {
            zoomView.post(new Runnable() {
                @Override
                public void run() {
                    zoomViewInitHeight = TranslucentScrollView.this.zoomView.getHeight();
                }
            });
        }
    }

    /**
     * 设置渐变视图
     *
     * @param transView 渐变的视图
     */
    public void setTransView(View transView) {
        setTransView(transView, getResources().getColor(R.color.colorPrimary), SizeUtils.dip2px(getContext(), DFT_TRANSSTARTY), SizeUtils.dip2px(getContext(), DFT_TRANSENDY));
    }

    /**
     * 设置渐变颜色
     *
     * @param colorRes 渐变的颜色
     */
    public void setTransColor(int colorRes) {
        this.transColor = colorRes;
    }

    /**
     * 设置渐变视图
     *
     * @param transView  渐变的视图
     * @param transColor 渐变颜色
     * @param transEndY  渐变结束位置
     */
    public void setTransView(View transView, int transColor, int transStartY, int transEndY) {
        this.transView = transView;
        this.transColor = transColor;
        //初始视图-透明
        this.transView.setBackgroundColor(setAlphaComponent(transColor, 0));
        if (transStartY == -1) {
            this.transStartY = SizeUtils.dip2px(getContext(), DFT_TRANSSTARTY);
        } else {
            this.transStartY = transStartY;
        }

        if (transEndY == -1) {
            this.transEndY = SizeUtils.dip2px(getContext(), DFT_TRANSENDY);
        } else {
            this.transEndY = transEndY;
        }

        if (this.transEndY == 0) {
            throw new IllegalArgumentException("transEndY 不得等于 0 ");
        } else if (this.transStartY == this.transEndY) {
            throw new IllegalArgumentException("transStartY 不得等于 transEndY .. ");
        } else if (this.transStartY > this.transEndY) {
            throw new IllegalArgumentException("transStartY 不得大于 transEndY .. ");
        }
    }

    public void  setDamping(float damping, int dampDistance) {
        if (damping < 0.0f || damping > 1.0f) {
            throw new IllegalArgumentException("damping 取值需要在 0.0f-1.0f 之间");
        }
        this.mDamping = damping;
        if (dampDistance != -1) {
            mDamplDistance   = SizeUtils.dip2px(getContext(), dampDistance);
        }
    }

    /**
     * 获取透明度
     *
     * @return
     */
    private int getTransAlpha() {
        float scrollY = getScrollY();
        if (transStartY != 0) {
            if (scrollY <= transStartY) {
                return 0;
            } else if (scrollY >= transEndY) {
                return 255;
            } else {
                return (int) ((scrollY - transStartY) / (transEndY - transStartY) * 255);
            }
        } else {
            if (scrollY >= transEndY) {
                return 255;
            }
            return (int) ((transEndY - scrollY) / transEndY * 255);
        }
    }

    /**
     * 重置ZoomView
     */
    private void resetZoomView() {
        final ViewGroup.LayoutParams lp = zoomView.getLayoutParams();
        final float h = zoomView.getLayoutParams().height;// ZoomView当前高度

        // 设置动画
        ValueAnimator anim = ObjectAnimator.ofFloat(0.0F, 1.0F).setDuration(200);

        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float cVal = (Float) animation.getAnimatedValue();
                lp.height = (int) (h - (h - zoomViewInitHeight) * cVal);
                zoomView.setLayoutParams(lp);
            }
        });
        anim.start();
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        int transAlpha = getTransAlpha();

        if (transView != null) {
            transView.setBackgroundColor(setAlphaComponent(transColor, transAlpha));
        }
        if (translucentChangedListener != null) {
            translucentChangedListener.onTranslucentChanged(transAlpha);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (zoomView != null) {
            ViewGroup.LayoutParams params = zoomView.getLayoutParams();
            switch (event.getAction()) {
                case MotionEvent.ACTION_UP:
                    //手指离开后恢复图片
                    mScaling = false;
                    resetZoomView();
                    break;
                case MotionEvent.ACTION_MOVE:
                    if (!mScaling) {
                        if (getScrollY() == 0) {
                            mFirstPosition = event.getY();
                        } else {
                            break;
                        }
                    }

                    int distance = (int) ((event.getY() - mFirstPosition) * 0.6);
                    if (distance < 0) {
                        break;
                    }
                    mScaling = true;
                    if (mDamping == 0.0f) {
                        params.height = zoomViewInitHeight + distance;
                    } else {
                        float appendHeight = (distance <= mDamplDistance ? distance : mDamplDistance + ((distance - mDamplDistance) * mDamping));
                        params.height = zoomViewInitHeight + (int) appendHeight;
                    }

                    zoomView.setLayoutParams(params);
                    return true;
            }
        }

        return super.onTouchEvent(event);
    }

    private static int setAlphaComponent(int color, int alpha) {
        if (alpha < 0 || alpha > 255) {
            throw new IllegalArgumentException("alpha must be between 0 and 255.");
        }
        return (color & 0x00ffffff) | (alpha << 24);
    }

}
