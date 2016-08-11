package com.luc.bnd;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.luc.bnd.adapter.BaseViewPagerAdapter;
import com.luc.bnd.ui.view.BottomNaviBox;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    private BaseViewPagerAdapter mAdapter;
    private ViewPager mViewPager;
    private BottomNaviBox mBottomNaviBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.pager_container);
        mAdapter = new BaseViewPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);
        mBottomNaviBox = (BottomNaviBox) findViewById(R.id.bottom_navi_box);
        mBottomNaviBox.setViewPager(mViewPager);
    }

}
