package com.luc.bnd.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.luc.bnd.R;

/**
 * Created by Lucifer on 2016/8/11.
 */
public class BottomNaviView extends FrameLayout{

    private ImageView mIvNormal;
    private ImageView mIvChecked;
    private TextView mTvNormal;
    private TextView mTvChecked;

    public BottomNaviView(Context context) {
        super(context);
    }

    public BottomNaviView(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.bottom_navi_view, this);
        mIvNormal = (ImageView) findViewById(R.id.iv_normal);
        mIvChecked = (ImageView) findViewById(R.id.iv_selected);
        mTvNormal = (TextView) findViewById(R.id.tv_normal);
        mTvChecked = (TextView) findViewById(R.id.tv_selected);

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.BottomNaviView);
        int defaultTc = ta.getColor(R.styleable.BottomNaviView_default_tc, getResources().getColor(R.color.md_grey_700));
        int checkedTc = ta.getColor(R.styleable.BottomNaviView_checked_tc, getResources().getColor(R.color.md_orange_700));

        Drawable defaultIc = ta.getDrawable(R.styleable.BottomNaviView_default_icon);
        Drawable checkedIc = ta.getDrawable(R.styleable.BottomNaviView_checked_icon);

        String text = ta.getString(R.styleable.BottomNaviView_navi_name);
        boolean checked = ta.getBoolean(R.styleable.BottomNaviView_navi_checked, false);

        ta.recycle();

        mTvNormal.setTextColor(defaultTc);
        mTvChecked.setTextColor(checkedTc);

        mIvNormal.setImageDrawable(defaultIc);
        mIvChecked.setImageDrawable(checkedIc);

        mTvNormal.setText(text);
        mTvChecked.setText(text);

        if (checked) {
            check(true);
        }
    }

    /**
     * 更新渐变, alpha 为 1 时是 checked 颜色。
     * @param alpha
     */
    public void updateAlpha(float alpha) {
        mIvNormal.setAlpha(1- alpha);
        mTvNormal.setAlpha(1- alpha);

        mIvChecked.setAlpha(alpha);
        mTvChecked.setAlpha(alpha);
    }

    public void check(boolean checked) {
        if (checked) {
            updateAlpha(1f);
        } else {
            updateAlpha(0f);
        }
    }
}
