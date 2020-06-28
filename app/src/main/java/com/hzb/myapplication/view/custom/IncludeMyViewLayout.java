package com.hzb.myapplication.view.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hzb.myapplication.R;
import com.hzb.myapplication.utils.DensityUtils;

/**
 * FileName: MyOneLineView
 * Author: houzhengbang
 * Date: 2020-05-29 09:29
 * Description:标题栏  --有了沉浸式状态栏   后  这个目前落灰....
 */

/**
 *
 *  用法   :
 *
 //        includeMyViewLayout = new IncludeMyViewLayout(mContext)
 ////                .setbBg(R.color.colorAccent)
 ////                .initMine(R.mipmap.ic_launcher, "第一行", "", true)
 //                .setRootMarginsTopBottom(20, 0);
 ////                .setOnRootClickListener(this, 5);
 //
 //
 //        includeMyViewLayout.initMine(R.mipmap.ic_launcher, "第一行", "", true);
 //        includeMyViewLayout.setOnRootClickListener(this, 5);
 //        //icon + 文字 + 箭头
 //        llRoot.addView(includeMyViewLayout);
 //
 //
 //        includeMyViewLayout.initMine(R.mipmap.ic_launcher, "第二行", "", true);
 //        includeMyViewLayout.setOnRootClickListener(this, 2);
 //
 //
 //        //icon + 文字 + 文字 + 箭头
 //        llRoot.addView(new IncludeMyViewLayout(mContext)
 //                .init(R.mipmap.ic_launcher, "第二行")
 //                .setRootMarginsTopBottom(20, 20)
 //                .setOnRootClickListener(this, 2));
 //
 //        //icon + 文字 + 文字 + 箭头
 //        llRoot.addView(new IncludeMyViewLayout(mContext)
 //                .initMine(R.mipmap.ic_launcher, "第三行", "", true)
 //                .setRootMarginsTopBottom(20, 20)
 //                .setOnRootClickListener(this, 1));
 }

 //    @Override
 //    public void onRootClick(View view) {
 //        int position = 0;
 //        switch ((int) view.getTag()) {
 //            case 5:
 //                position = 0;
 //                initEditView(position, (Integer) view.getTag());
 //
 //                break;
 //            case 2:
 //                position = 1;
 //                initEditView(position, (Integer) view.getTag());
 //
 //                break;
 //            case 1:
 //                position = 2;
 //                initEditView(position, (Integer) view.getTag());
 //                break;
 //
 //            default:
 //                break;
 //        }
 //        Toast.makeText(mContext, "点击了第" + position + "行" + "-----" + (int) view.getTag(), Toast.LENGTH_SHORT).show();
 //    }
 //
 //    private void initEditView(int postion, int tag) {
 //        if (llRoot.getChildCount() >= (postion + 1)) {
 //            llRoot.removeViewAt(postion);
 //
 ////            IncludeMyViewLayout childAt = (IncludeMyViewLayout) llRoot.getChildAt(postion);
 ////            if (childAt != null) {
 ////                childAt.init(R.mipmap.ic_launcher, "呵呵");
 ////            }
 //            //icon + 文字 + 文字 + 箭头
 ////            llRoot.addView(new IncludeMyViewLayout(mContext)
 ////                    .init(R.mipmap.ic_launcher, "呵呵")
 ////                    .setRootMarginsTopBottom(20, 20)
 ////                    .setRootPaddingTopBottom(50, 10)
 ////                    .setOnRootClickListener(this, tag), postion);
 //        }
 //    }
 */
public class IncludeMyViewLayout extends LinearLayout {

    /**
     * 上下分割线，默认隐藏上面分割线
     */
    private View dividerTop, dividerBottom;

    /**
     * 最外层容器
     */
    private LinearLayout llRoot;
    /**
     * 最左边的Icon
     */
    private ImageView ivLeftIcon;
    /**
     * 中间的文字内容
     */
    private TextView tvTextContent;
    /**
     * 右边的文字
     */
    private TextView tvRightText;

    /**
     * 右边的icon 通常是箭头
     */
    private ImageView ivRightIcon;


    /**
     * 整个一行被点击
     */
    public static interface OnRootClickListener {
        void onRootClick(View view);
    }

    /**
     * 右边箭头的点击事件
     */
    public static interface OnArrowClickListener {
        void onArrowClick(View view);
    }

    public IncludeMyViewLayout(Context context) {
        super(context);
    }

    public IncludeMyViewLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    /**
     * 初始化各个控件
     */
    public IncludeMyViewLayout init() {
        LayoutInflater.from(getContext()).inflate(R.layout.include_my_view_layout, this, true);
        llRoot = (LinearLayout) findViewById(R.id.ll_root);

        dividerTop = findViewById(R.id.divider_top);
        dividerBottom = findViewById(R.id.divider_bottom);

        ivLeftIcon = (ImageView) findViewById(R.id.iv_left_icon);
        tvTextContent = (TextView) findViewById(R.id.tv_text_content);

        tvRightText = (TextView) findViewById(R.id.tv_right_text);
        ivRightIcon = (ImageView) findViewById(R.id.iv_right_icon);
        return this;
    }


    /**
     * 默认情况下的样子  icon + 文字 + 右箭头 + 下分割线
     *
     * @param iconRes     icon图片
     * @param textContent 文字内容
     */
    public IncludeMyViewLayout init(int iconRes, String textContent) {
        init();
        showDivider(false, true);
        setLeftIcon(iconRes);
        setTextContent(textContent);
        setRightText("");
        showArrow(true);
        return this;
    }

    /**
     * 我的页面每一行  icon + 文字 + 右箭头（显示/不显示） + 右箭头左边的文字（显示/不显示）+ 下分割线
     *
     * @param iconRes     icon图片
     * @param textContent 文字内容
     */
    public IncludeMyViewLayout initMine(int iconRes, String textContent, String textRight, boolean showArrow) {
        init(iconRes, textContent);

        setRightText(textRight);
        showArrow(showArrow);
        return this;
    }


    /**
     * icon + 文字  + 下分割线
     *
     * @return
     */
    public IncludeMyViewLayout initItemWidthEdit(int iconRes, String textContent) {
        init(iconRes, textContent);
        showArrow(false);
        return this;
    }

    //---------------------下面是对每个部分的一些设置     上面是应用中常用场景封装-----------------------//

    /**
     * 设置背景样式
     */
//    public IncludeMyViewLayout setbBg(int url) {
////        llRoot.setBackgroundColor(R.color.colorAccent);
//        return this;
//    }

    /**
     * 设置root的paddingTop 与 PaddingBottom 从而控制整体的行高
     * paddingLeft 与 paddingRight 保持默认 20dp
     */
    public IncludeMyViewLayout setRootPaddingTopBottom(int paddintTop, int paddintBottom) {
        llRoot.setPadding(DensityUtils.dp2px(getContext(), 20),
                DensityUtils.dp2px(getContext(), paddintTop),
                DensityUtils.dp2px(getContext(), 20),
                DensityUtils.dp2px(getContext(), paddintBottom));
        return this;
    }

    /**
     * 设置root的paddingLeft 与 PaddingRight 从而控制整体的行高
     * <p>
     * paddingTop 与 paddingBottom 保持默认 15dp
     */
    public IncludeMyViewLayout setRootPaddingLeftRight(int paddintTop, int paddintRight) {
        llRoot.setPadding(DensityUtils.dp2px(getContext(), paddintTop),
                DensityUtils.dp2px(getContext(), 15),
                DensityUtils.dp2px(getContext(), paddintRight),
                DensityUtils.dp2px(getContext(), 15));
        return this;
    }

    /**
     * marginTop 与 marginBottom 从而控制 上下 间距
     * marginLeft 与 marginRight 保持默认 0dp
     */
    public IncludeMyViewLayout setRootMarginsTopBottom(int marginTop, int marginBottom) {
        LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(
                DensityUtils.dp2px(getContext(), 0),
                DensityUtils.dp2px(getContext(), marginTop),
                DensityUtils.dp2px(getContext(), 0),
                DensityUtils.dp2px(getContext(), marginBottom));
        llRoot.setLayoutParams(lp);
        return this;
    }

    /**
     * marginLeft与 marginRight 从而控制 左右 间距
     * marginTop 与  marginBottom保持默认 0dp
     */
    public IncludeMyViewLayout setRootMarginsLeftRight(int marginleft, int marginRight) {
        LayoutParams lp = new LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(
                DensityUtils.dp2px(getContext(), marginleft),
                DensityUtils.dp2px(getContext(), 0),
                DensityUtils.dp2px(getContext(), marginRight),
                DensityUtils.dp2px(getContext(), 0));
        llRoot.setLayoutParams(lp);
        return this;
    }


    /**
     * 设置上下分割线的显示情况
     *
     * @return
     */
    public IncludeMyViewLayout showDivider(Boolean showDividerTop, Boolean showDivderBottom) {
        if (showDividerTop) {
            dividerTop.setVisibility(VISIBLE);
        } else {
            dividerTop.setVisibility(GONE);
        }
        if (showDivderBottom) {
            dividerBottom.setVisibility(VISIBLE);
        } else {
            dividerBottom.setVisibility(GONE);
        }
        return this;
    }

    /**
     * 设置上分割线的颜色
     *
     * @return
     */
    public IncludeMyViewLayout setDividerTopColor(int dividerTopColorRes) {
        dividerTop.setBackgroundColor(getResources().getColor(dividerTopColorRes));
        return this;
    }

    /**
     * 设置上分割线的高度
     *
     * @return
     */
    public IncludeMyViewLayout setDividerTopHigiht(int dividerTopHigihtDp) {
        ViewGroup.LayoutParams layoutParams = dividerTop.getLayoutParams();
        layoutParams.height = DensityUtils.dp2px(getContext(), dividerTopHigihtDp);
        dividerTop.setLayoutParams(layoutParams);
        return this;
    }

    /**
     * 设置下分割线的颜色
     *
     * @return
     */
    public IncludeMyViewLayout setDividerBottomColor(int dividerBottomColorRes) {
        dividerBottom.setBackgroundColor(getResources().getColor(dividerBottomColorRes));
        return this;
    }

    /**
     * 设置上分割线的高度
     *
     * @return
     */
    public IncludeMyViewLayout setDividerBottomHigiht(int dividerBottomHigihtDp) {
        ViewGroup.LayoutParams layoutParams = dividerBottom.getLayoutParams();
        layoutParams.height = DensityUtils.dp2px(getContext(), dividerBottomHigihtDp);
        dividerBottom.setLayoutParams(layoutParams);
        return this;
    }

    /**
     * 设置左边Icon
     *
     * @param iconRes
     */
    public IncludeMyViewLayout setLeftIcon(int iconRes) {
        ivLeftIcon.setImageResource(iconRes);
        return this;
    }

    /**
     * 设置左边Icon显示与否
     *
     * @param showLeftIcon
     */
    public IncludeMyViewLayout showLeftIcon(boolean showLeftIcon) {
        if (showLeftIcon) {
            ivLeftIcon.setVisibility(VISIBLE);
        } else {
            ivLeftIcon.setVisibility(GONE);
        }
        return this;
    }

    /**
     * 设置左边Icon 以及Icon的宽高
     */
    public IncludeMyViewLayout setLeftIconSize(int widthDp, int heightDp) {
        ViewGroup.LayoutParams layoutParams = ivLeftIcon.getLayoutParams();
        layoutParams.width = DensityUtils.dp2px(getContext(), widthDp);
        layoutParams.height = DensityUtils.dp2px(getContext(), heightDp);
        ivLeftIcon.setLayoutParams(layoutParams);
        return this;
    }


    /**
     * 设置中间的文字内容
     *
     * @param textContent
     * @return
     */
    public IncludeMyViewLayout setTextContent(String textContent) {
        tvTextContent.setText(textContent);
        return this;
    }

    /**
     * 设置中间的文字颜色
     *
     * @return
     */
    public IncludeMyViewLayout setTextContentColor(int colorRes) {
        tvTextContent.setTextColor(getResources().getColor(colorRes));
        return this;
    }

    /**
     * 设置中间的文字大小
     *
     * @return
     */
    public IncludeMyViewLayout setTextContentSize(int textSizeSp) {
        tvTextContent.setTextSize(textSizeSp);
        return this;
    }

    /**
     * 设置右边文字内容
     *
     * @return
     */
    public IncludeMyViewLayout setRightText(String rightText) {
        tvRightText.setText(rightText);
        return this;
    }


    /**
     * 设置右边文字颜色
     *
     * @return
     */
    public IncludeMyViewLayout setRightTextColor(int colorRes) {
        tvRightText.setTextColor(getResources().getColor(colorRes));
        return this;
    }

    /**
     * 设置右边文字大小
     *
     * @return
     */
    public IncludeMyViewLayout setRightTextSize(int textSize) {
        tvRightText.setTextSize(textSize);
        return this;
    }

    /**
     * 设置右箭头的显示与不显示
     *
     * @param showArrow
     */
    public IncludeMyViewLayout showArrow(boolean showArrow) {
        if (showArrow) {
            ivRightIcon.setVisibility(VISIBLE);
        } else {
            ivRightIcon.setVisibility(GONE);
        }
        return this;
    }

    /**
     * 设置右边icon
     */
    public IncludeMyViewLayout setIvRightIcon(int iconRes) {

        ivRightIcon.setImageResource(iconRes);

        return this;
    }

    /**
     * 设置右边Icon 以及Icon的宽高
     */
    public IncludeMyViewLayout setRightIconSize(int widthDp, int heightDp) {
        ViewGroup.LayoutParams layoutParams = ivRightIcon.getLayoutParams();
        layoutParams.width = DensityUtils.dp2px(getContext(), widthDp);
        layoutParams.height = DensityUtils.dp2px(getContext(), heightDp);
        ivRightIcon.setLayoutParams(layoutParams);
        return this;
    }

    //----------------------下面是一些点击事件

    public IncludeMyViewLayout setOnRootClickListener(final OnRootClickListener onRootClickListener, final int tag) {
        llRoot.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                llRoot.setTag(tag);
                onRootClickListener.onRootClick(llRoot);
            }
        });
        return this;
    }

    public IncludeMyViewLayout setOnArrowClickListener(final OnArrowClickListener onArrowClickListener, final int tag) {

        ivRightIcon.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ivRightIcon.setTag(tag);
                onArrowClickListener.onArrowClick(ivRightIcon);
            }
        });
        return this;
    }
}
