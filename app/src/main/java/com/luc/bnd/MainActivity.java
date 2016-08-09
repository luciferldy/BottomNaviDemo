package com.luc.bnd;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.luc.bnd.adapter.BaseViewPagerAdapter;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, RadioGroup.OnCheckedChangeListener {

    private BaseViewPagerAdapter mAdapter;
    private ViewPager mViewPager;
    private RadioGroup mRadioGroup;
    private RadioButton mRadioHome;
    private RadioButton mRadioBoard;
    private RadioButton mRadioGallery;
    private RadioButton mRadioMine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.pager_container);
        mAdapter = new BaseViewPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);
        mViewPager.setCurrentItem(BaseViewPagerAdapter.PAGE_HOME);
        mViewPager.addOnPageChangeListener(this);

//        mRadioHome = (RadioButton) findViewById(R.id.bottom_tab_home);
//        mRadioBoard = (RadioButton) findViewById(R.id.bottom_tab_board);
//        mRadioGallery = (RadioButton) findViewById(R.id.bottom_tab_gallery);
//        mRadioMine = (RadioButton) findViewById(R.id.bottom_tab_mine);
        mRadioGroup = (RadioGroup) findViewById(R.id.bottom_navigator);
        mRadioGroup.setOnCheckedChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case BaseViewPagerAdapter.PAGE_HOME:
//                mRadioHome.setChecked(true);
                mRadioGroup.check(R.id.bottom_tab_home);
                break;
            case BaseViewPagerAdapter.PAGE_BOARD:
//                mRadioBoard.setChecked(true);
                mRadioGroup.check(R.id.bottom_tab_board);
                break;
            case BaseViewPagerAdapter.PAGE_GALLERY:
//                mRadioGallery.setChecked(true);
                mRadioGroup.check(R.id.bottom_tab_gallery);
                break;
            case BaseViewPagerAdapter.PAGE_MINE:
//                mRadioMine.setChecked(true);
                mRadioGroup.check(R.id.bottom_tab_mine);
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.bottom_tab_home:
                mViewPager.setCurrentItem(BaseViewPagerAdapter.PAGE_HOME, false);
                break;
            case R.id.bottom_tab_board:
                mViewPager.setCurrentItem(BaseViewPagerAdapter.PAGE_BOARD, false);
                break;
            case R.id.bottom_tab_gallery:
                mViewPager.setCurrentItem(BaseViewPagerAdapter.PAGE_GALLERY, false);
                break;
            case R.id.bottom_tab_mine:
                mViewPager.setCurrentItem(BaseViewPagerAdapter.PAGE_MINE, false);
                break;

        }
    }
}
