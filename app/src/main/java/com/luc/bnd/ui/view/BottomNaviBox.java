package com.luc.bnd.ui.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by Lucifer on 2016/8/11.
 */
public class BottomNaviBox extends LinearLayout implements ViewPager.OnPageChangeListener{

    private static final String LOG_TAG = BottomNaviBox.class.getSimpleName();

    private ViewPager mViewPager;

    public BottomNaviBox(Context context) {
        super(context);
    }

    public BottomNaviBox(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setViewPager(ViewPager viewPager) {
        this.mViewPager = viewPager;
        mViewPager.addOnPageChangeListener(this);

        for (int i = 0; i < getChildCount(); i++) {
            final int position = i;
            getChildAt(i).setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    mViewPager.setCurrentItem(position, false);
                    setChildChecked(position);
                }
            });
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
    }



    @Override
    /**
     * @position 当前页面
     * @positionOffset 当前页面偏移的百分比
     * @positionOffsetPixels 当前页面偏移的像素位置
     */
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if (positionOffset  > 0) {
            Log.i(LOG_TAG, "onPageScrolled, position=" + position);
            ((BottomNaviView) getChildAt(position)).updateAlpha(1 - positionOffset);
            ((BottomNaviView) getChildAt(position + 1)).updateAlpha(positionOffset);
        }
    }

    @Override
    public void onPageSelected(int position) {
        setChildChecked(position);
    }

    @Override
    /**
     * @state 1表示正在滑动，2表示滑动完毕，0表示什么都没做
     */
    public void onPageScrollStateChanged(int state) {

    }

    private void setChildChecked(int position) {
        for (int i = 0; i < getChildCount(); i++) {
            ((BottomNaviView) getChildAt(i)).check(false);
        }
        ((BottomNaviView) getChildAt(position)).check(true);
    }


}
